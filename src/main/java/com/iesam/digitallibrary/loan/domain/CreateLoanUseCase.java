package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.domain.CreateUserUseCase;
import com.iesam.digitallibrary.user.domain.GetUserUseCase;
import com.iesam.digitallibrary.user.domain.ModifyUserUseCase;
import com.iesam.digitallibrary.user.domain.User;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class CreateLoanUseCase {
    private final LoanRepository loanRepository;

    public CreateLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public void execute (Loan loan){
        GetUserUseCase getUserUseCase= new GetUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        User user= getUserUseCase.execute(loan.getIdUser());
        ArrayList<Loan> loans= user.getLoanActives();
        loans.add(loan);
        ModifyUserUseCase modifyUserUseCase= new ModifyUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        User user1= new User(user.getId(),user.getDni(), user.getName(),user.getEmail(),user.getPhone(), user.getAddres(), loans );
        loanRepository.createLoan(loan);
    }
}
