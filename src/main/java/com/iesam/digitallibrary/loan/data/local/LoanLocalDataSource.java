package com.iesam.digitallibrary.loan.data.local;

import com.iesam.digitallibrary.loan.domain.Loan;

public interface LoanLocalDataSource {
    void createLoan(Loan loan);
    void deleteLoan(String id);
}
