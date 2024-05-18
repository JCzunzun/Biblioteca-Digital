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
        GetUserUseCase getUserUseCase= new GetUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        GetLoanUseCase getLoanUseCase= new GetLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        Loan loan= getLoanUseCase.execute(id);
        User user= getUserUseCase.execute(loan.getIdUser());
        ArrayList<Loan> loansUser= user.getLoanActives();
        loansUser.removeIf(loanDelete -> loan.getIdLoan().equals(loanDelete.getIdLoan()));
        ModifyUserUseCase modifyUserUseCase= new ModifyUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        User userModified= new User(user.getId(), user.getDni(), user.getName(),user.getEmail(), user.getPhone(), user.getAddres(),loansUser);
        modifyUserUseCase.execute(userModified);
        loanRepository.deleteLoan(id);
    }
}
