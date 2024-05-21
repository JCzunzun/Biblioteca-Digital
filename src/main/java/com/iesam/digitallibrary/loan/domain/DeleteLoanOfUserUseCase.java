package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.domain.ModifyUserUseCase;
import com.iesam.digitallibrary.user.domain.User;
import com.iesam.digitallibrary.user.domain.UserFactory;
import com.iesam.digitallibrary.user.domain.UserRepository;

import java.util.ArrayList;

public class DeleteLoanOfUserUseCase {
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;

    public DeleteLoanOfUserUseCase(LoanRepository loanRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
    }

    public void execute (String id){

        Loan loan= loanRepository.obtainSpecifiedLoan(id);
        User user= userRepository.getUser(loan.idUser);

        ArrayList<Loan> loansUser= user.getLoanActives();

        loansUser.removeIf(loanDelete -> loan.idLoan.equals(loanDelete.idLoan));

        User userModified= UserFactory.build(user.getId(), user.getDni(), user.getName(),user.getEmail(), user.getPhone(), user.getAddres(),loansUser);
        userRepository.modifyUser(userModified);
    }
}
