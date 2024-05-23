package com.iesam.digitallibrary.loan.domain;

public class GetLoanUseCase {
    private final LoanRepository loanRepository;

    public GetLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan execute(String id) {
        return loanRepository.obtainSpecifiedLoan(id);
    }
}
