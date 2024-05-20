package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.domain.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class CreateLoanUseCase {
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;

    public CreateLoanUseCase(LoanRepository loanRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
    }
    public void execute (Loan loan){
        User user= userRepository.getUser(loan.idUser);
        ArrayList<Loan> loans= user.getLoanActives();
        loans.add(loan);
        User user1= UserFactory.build(user.getId(),user.getDni(), user.getName(),user.getEmail(),user.getPhone(), user.getAddres(), loans );
        userRepository.modifyUser(user1);
        loanRepository.createLoan(loan);
    }
}
