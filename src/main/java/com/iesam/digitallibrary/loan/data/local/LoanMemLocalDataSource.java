package com.iesam.digitallibrary.loan.data.local;

import com.iesam.digitallibrary.loan.domain.Loan;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class LoanMemLocalDataSource implements LoanLocalDataSource{
    ArrayList<Loan> loans= new ArrayList<>();
    private static LoanMemLocalDataSource instance=null;
    public LoanMemLocalDataSource newInstance(){
        if(instance== null){
            instance= new LoanMemLocalDataSource();
        }
        return instance;
    }
    @Override
    public void createLoan(Loan loan) {
         loans.add(loan);
    }

    @Override
    public void deleteLoan(String id) {
        for(Loan loan: loans){
            if(loan.getIdLoan().equals(id)){
                loans.remove(loan);
            }
        }
    }

    @Override
    public ArrayList<Loan> obtainLoansPending() {
        ArrayList<Loan> loansPending = new ArrayList<>();
        for(Loan loan:loans){
            if(!loan.getStatusLoan().equals("Finished")){
                loansPending.add(loan);
            }
        }
        return loansPending;
    }

    @Override
    public ArrayList<Loan> obtainFinishedLoans() {
        ArrayList<Loan> loansFinished = new ArrayList<>();
        for(Loan loan:loans){
            if(loan.getStatusLoan().equals("Finished")){
                loansFinished.add(loan);
            }
        }
        return loansFinished;
    }

    @Override
    public void endedLoan(String id) {
        ArrayList<Loan> loanPending=obtainLoansPending();
        Loan loanEnded;
        for(Loan loan:loanPending){
            if(loan.getIdLoan().equals(id)){
                loanEnded=loan;
                loanEnded.setStatusLoan("Finished");
                deleteLoan(loanEnded.getIdLoan());
                createLoan(loanEnded);
            }
        }
    }

    @Override
    public ArrayList<Loan> obtainLoans() {
        return loans;
    }
}
