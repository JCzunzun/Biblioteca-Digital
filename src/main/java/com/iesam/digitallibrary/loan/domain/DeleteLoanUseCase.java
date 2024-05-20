package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.domain.GetUserUseCase;
import com.iesam.digitallibrary.user.domain.ModifyUserUseCase;
import com.iesam.digitallibrary.user.domain.User;

import java.util.ArrayList;

public class DeleteLoanUseCase {
    private final LoanRepository loanRepository;

    public DeleteLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public void execute(String id){

        loanRepository.deleteLoan(id);
    }
}
