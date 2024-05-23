package com.iesam.digitallibrary.loan.domain;

public class LoanFactory {
    public static Loan build(String id, String idUser, String idDigitalResource, String loanStartDate, String endLoanDate) {
        Loan loan = new Loan(id, idUser, idDigitalResource, loanStartDate, endLoanDate);
        return loan;
    }
}
