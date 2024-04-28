package com.iesam.digitallibrary.loan.data.local;

import com.iesam.digitallibrary.loan.domain.Loan;

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
}
