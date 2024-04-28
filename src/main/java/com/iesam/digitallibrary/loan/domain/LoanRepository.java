package com.iesam.digitallibrary.loan.domain;

public interface LoanRepository {
    void createLoan(Loan loan);
    void deleteLoan(String id);
}
