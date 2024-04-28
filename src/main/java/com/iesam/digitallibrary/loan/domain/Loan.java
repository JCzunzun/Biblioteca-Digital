package com.iesam.digitallibrary.loan.domain;

public class Loan {
    private final String idUser;
    public final String idDigitalResource;
    public final String statusLoan;
    public final String starLoanDate;
    public final String endLoanDate;

    public Loan(String idUser, String idDigitalResource, String statusLoan, String starLoanDate, String endLoanDate) {
        this.idUser = idUser;
        this.idDigitalResource = idDigitalResource;
        this.statusLoan = statusLoan;
        this.starLoanDate = starLoanDate;
        this.endLoanDate = endLoanDate;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getIdDigitalResource() {
        return idDigitalResource;
    }

    public String getStatusLoan() {
        return statusLoan;
    }

    public String getStarLoanDate() {
        return starLoanDate;
    }

    public String getEndLoanDate() {
        return endLoanDate;
    }
}
