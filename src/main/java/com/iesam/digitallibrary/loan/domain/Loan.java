package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Loan {
    public final String idLoan;
    public final String idUser;
    public final String idDigitalResource;
    public final String statusLoan;
    public final String starLoanDate;
    public final String endLoanDate;

    public Loan(String idLoan, String idUser, String idDigitalResource) {
        this.idLoan = idLoan;
        this.idUser = idUser;
        this.idDigitalResource = idDigitalResource;
        this.statusLoan = "Pending";
        this.starLoanDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));;
        this.endLoanDate = LocalDate.now().plusDays(21).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));;
    }

    public Loan(String idLoan, String idUser, String idDigitalResource, String starLoanDate, String endLoanDate) {
        this.idLoan = idLoan;
        this.idUser = idUser;
        this.idDigitalResource = idDigitalResource;
        this.statusLoan = "Finished";
        this.starLoanDate = starLoanDate;
        this.endLoanDate = endLoanDate;
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
