package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.digitalresources.DigitalResource;

public class Loan {
    public final DigitalResource digitalResource;
    public final String statusLoan;
    public final String starLoanDate;
    public final String endLoanDate;

    public Loan(DigitalResource digitalResource, String statusLoan, String starLoanDate, String endLoanDate) {
        this.digitalResource = digitalResource;
        this.statusLoan = statusLoan;
        this.starLoanDate = starLoanDate;
        this.endLoanDate = endLoanDate;
    }

    public DigitalResource getDigitalResource() {
        return digitalResource;
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
