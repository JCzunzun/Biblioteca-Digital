package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;

import java.util.Date;


public class Loan {
    private final String idLoan;
    private final String idUser;
    public final String idDigitalResource;
    public final String statusLoan;
    public final Date starLoanDate;
    public final Date endLoanDate;

    public Loan(String idLoan, String idUser, String idDigitalResource, String statusLoan, Date starLoanDate, Date endLoanDate) {
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

    public Date getEndLoanDate() {
        return endLoanDate;
    }

    public Date getStarLoanDate() {
        return starLoanDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "idLoan='" + idLoan + '\'' +
                ", idUser='" + idUser + '\'' +
                ", idDigitalResource='" + idDigitalResource + '\'' +
                ", statusLoan='" + statusLoan + '\'' +
                ", starLoanDate=" + starLoanDate +
                ", endLoanDate=" + endLoanDate +
                '}';
    }
}
