package com.iesam.digitallibrary.loan.data.local;

import com.iesam.digitallibrary.loan.domain.Loan;

import java.util.ArrayList;

public interface LoanLocalDataSource {
    void createLoan(Loan loan);
    void deleteLoan(String id);
    ArrayList<Loan> obtainLoansPending();
    ArrayList<Loan> obtainFinishedLoans();
    ArrayList<Loan> obtainLoans();
    Loan obtainSpecifiedLoan(String id);
}
