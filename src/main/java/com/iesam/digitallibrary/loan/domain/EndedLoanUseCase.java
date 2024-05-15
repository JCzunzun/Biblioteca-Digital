package com.iesam.digitallibrary.loan.domain;

public class EndedLoanUseCase {
    private final LoanRepository loanRepository;

    public EndedLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public void execute(String id){
        loanRepository.endedLoan(id);
    }
}
