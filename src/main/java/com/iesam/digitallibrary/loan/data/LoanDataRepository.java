package com.iesam.digitallibrary.loan.data;

import com.iesam.digitallibrary.loan.data.local.LoanLocalDataSource;
import com.iesam.digitallibrary.loan.domain.Loan;
import com.iesam.digitallibrary.loan.domain.LoanRepository;

import java.util.ArrayList;

public class LoanDataRepository implements LoanRepository {
    LoanLocalDataSource loanLocalDataSource;
    public LoanDataRepository(LoanLocalDataSource loanLocalDataSource){
        this.loanLocalDataSource= loanLocalDataSource;
    }
    @Override
    public void createLoan(Loan loan) {
        loanLocalDataSource.createLoan(loan);
    }

    @Override
    public void deleteLoan(String id) {
        loanLocalDataSource.deleteLoan(id);
    }

    @Override
    public ArrayList<Loan> obtainLoansPending() {
        return loanLocalDataSource.obtainLoansPending();
    }

    @Override
    public ArrayList<Loan> obtainFinishedLoans() {
        return loanLocalDataSource.obtainFinishedLoans();
    }

    @Override
    public void endedLoan(String id) {
        loanLocalDataSource.endedLoan(id);
    }

    @Override
    public ArrayList<Loan> obtainLoans() {
        return loanLocalDataSource.obtainLoans();
    }

}
