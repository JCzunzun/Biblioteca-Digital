package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;

public class Loan {
    private final String idLoan;
    private final String idUser;
    public final String idDigitalResource;
    public final String statusLoan;
    public final String starLoanDate;
    public final String endLoanDate;

    public Loan(String idLoan, String idUser, String idDigitalResource, String statusLoan, String starLoanDate, String endLoanDate) {
        this.idLoan = idLoan;
        this.idUser = idUser;
        this.idDigitalResource = idDigitalResource;
        this.statusLoan = statusLoan;
        this.starLoanDate = starLoanDate;
        this.endLoanDate = endLoanDate;
    }

    public String getIdLoan() {
        return idLoan;
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
