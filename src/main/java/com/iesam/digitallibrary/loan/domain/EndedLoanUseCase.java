package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.loan.data.local.LoanFileLocalDataSource;

public class EndedLoanUseCase {
    private final LoanRepository loanRepository;

    public EndedLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public void execute(String id){
        loanRepository.endedLoan(id);
    }

}
