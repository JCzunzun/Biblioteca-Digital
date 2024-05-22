package com.iesam.digitallibrary.loan.domain;

import java.util.ArrayList;

public class GetLoansPendingUseCase {
    private final LoanRepository loanRepository;

    public GetLoansPendingUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public ArrayList<Loan> execute() {
        return loanRepository.obtainLoansPending();
    }
}
