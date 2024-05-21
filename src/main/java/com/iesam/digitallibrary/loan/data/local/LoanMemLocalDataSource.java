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
            if(loan.idLoan.equals(id)){
                loans.remove(loan);
            }
        }
    }

    @Override
    public ArrayList<Loan> obtainLoansPending() {
        ArrayList<Loan> loansPending = new ArrayList<>();
        for(Loan loan:loans){
            if(!loan.statusLoan.equals("Finished")){
                loansPending.add(loan);
            }
        }
        return loansPending;
    }

    @Override
    public ArrayList<Loan> obtainFinishedLoans() {
        ArrayList<Loan> loansFinished = new ArrayList<>();
        for(Loan loan:loans){
            if(loan.statusLoan.equals("Finished")){
                loansFinished.add(loan);
            }
        }
        return loansFinished;
    }


    @Override
    public ArrayList<Loan> obtainLoans() {
        return loans;
    }

    @Override
    public Loan obtainSpecifiedLoan(String id) {
        for(Loan loan:loans){
            if(loan.idLoan.equals(id)){
                return loan;
            }
        }
        return null;
    }
}
