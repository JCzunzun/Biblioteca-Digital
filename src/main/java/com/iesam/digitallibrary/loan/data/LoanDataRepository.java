package com.iesam.digitallibrary.loan.data;

import com.iesam.digitallibrary.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.loan.data.local.LoanLocalDataSource;
import com.iesam.digitallibrary.loan.domain.DeleteLoanOfUserUseCase;
import com.iesam.digitallibrary.loan.domain.GetLoanUseCase;
import com.iesam.digitallibrary.loan.domain.Loan;
import com.iesam.digitallibrary.loan.domain.LoanRepository;
import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.domain.GetUserUseCase;
import com.iesam.digitallibrary.user.domain.ModifyUserUseCase;
import com.iesam.digitallibrary.user.domain.User;

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
    public ArrayList<Loan> obtainLoans() {
        return loanLocalDataSource.obtainLoans();
    }

    @Override
    public Loan obtainSpecifiedLoan(String id) {
        return loanLocalDataSource.obtainSpecifiedLoan(id);
    }

}
