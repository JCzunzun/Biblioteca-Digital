package com.iesam.digitallibrary.loan.data.local;

import com.iesam.digitallibrary.loan.domain.Loan;

import java.time.LocalDate;
import java.util.ArrayList;

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
}
