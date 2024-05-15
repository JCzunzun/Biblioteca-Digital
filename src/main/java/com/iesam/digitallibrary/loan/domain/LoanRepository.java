package com.iesam.digitallibrary.loan.domain;

import java.util.ArrayList;

public interface LoanRepository {
    void createLoan(Loan loan);
    void deleteLoan(String id);
    ArrayList<Loan> obtainLoansPending();
    ArrayList<Loan> obtainFinishedLoans();
    void endedLoan(String id);
}
