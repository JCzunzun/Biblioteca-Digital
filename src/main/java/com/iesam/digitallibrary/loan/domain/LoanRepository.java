package com.iesam.digitallibrary.loan.domain;

import java.util.ArrayList;

public interface LoanRepository {
    void createLoan(Loan loan);

    void deleteLoan(String id);

    ArrayList<Loan> obtainLoansPending();

    ArrayList<Loan> obtainFinishedLoans();

    ArrayList<Loan> obtainLoans();

    Loan obtainSpecifiedLoan(String id);
}
