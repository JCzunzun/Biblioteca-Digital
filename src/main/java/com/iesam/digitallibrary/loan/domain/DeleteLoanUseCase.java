package com.iesam.digitallibrary.loan.domain;

public class DeleteLoanUseCase {
    private final LoanRepository loanRepository;

    public DeleteLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public void execute(String id){
        loanRepository.deleteLoan(id);
    }
}
