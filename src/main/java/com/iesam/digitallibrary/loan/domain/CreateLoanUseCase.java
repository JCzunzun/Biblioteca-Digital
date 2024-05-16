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

        loanRepository.createLoan(loan);
    }
}
