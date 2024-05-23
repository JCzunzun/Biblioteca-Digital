package com.iesam.digitallibrary.loan.domain;

import java.util.ArrayList;

public class GetFinishedLoansUseCase {
    private final LoanRepository loanRepository;

    public GetFinishedLoansUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public ArrayList<Loan> execute() {
        return loanRepository.obtainFinishedLoans();
    }
}
