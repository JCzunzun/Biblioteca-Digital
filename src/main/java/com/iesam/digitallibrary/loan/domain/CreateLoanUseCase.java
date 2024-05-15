package com.iesam.digitallibrary.loan.domain;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CreateLoanUseCase {
    private final LoanRepository loanRepository;

    public CreateLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public void execute (Loan loan){
        loan.setStatusLoan("Pending");
        LocalDate localDate=LocalDate.now();
        loan.setStarLoanDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        LocalDate daysplus=localDate.plusDays(31);
        loan.setEndLoanDate(Date.from(daysplus.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        loanRepository.createLoan(loan);
    }
}
