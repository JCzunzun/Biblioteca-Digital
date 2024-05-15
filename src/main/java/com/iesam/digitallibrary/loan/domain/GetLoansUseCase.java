package com.iesam.digitallibrary.loan.domain;

import java.util.ArrayList;

public class GetLoansUseCase {
    private final LoanRepository loanRepository;

    public GetLoansUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public ArrayList<Loan> execute(){
        return loanRepository.obtainLoans();
    }
}
