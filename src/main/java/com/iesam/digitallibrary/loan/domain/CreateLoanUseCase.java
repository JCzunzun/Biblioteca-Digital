package com.iesam.digitallibrary.loan.domain;

public class CreateLoanUseCase {
    private final LoanRepository loanRepository;

    public CreateLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public void execute (Loan loan){
        loanRepository.createLoan(loan);
    }
}
