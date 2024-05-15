package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class Loan {
    public final String idLoan;
    public final String idUser;
    public final String idDigitalResource;
    private String statusLoan;
    private Date starLoanDate;
    private Date endLoanDate;

    public Loan(String idLoan, String idUser, String idDigitalResource) {
        this.idLoan = idLoan;
        this.idUser = idUser;
        this.idDigitalResource = idDigitalResource;
    }

    public void setStatusLoan(String statusLoan) {
        this.statusLoan = statusLoan;
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

    public void setEndLoanDate(Date endLoanDate) {
        this.endLoanDate = endLoanDate;
    }

    public void setStarLoanDate(Date starLoanDate) {
        this.starLoanDate = starLoanDate;
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
