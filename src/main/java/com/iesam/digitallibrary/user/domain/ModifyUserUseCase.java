package com.iesam.digitallibrary.user.domain;

import com.iesam.digitallibrary.loan.domain.Loan;
import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;

import java.util.ArrayList;

public class ModifyUserUseCase {
    public final UserRepository userRepository;

    public ModifyUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(User user) {
        GetLoansOfUserUseCase loansOfUserUseCase= new GetLoansOfUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        ArrayList<Loan> loansOfUSer=loansOfUserUseCase.execute(user.getId());
        User user1= new User(user.getId(), user.getDni(), user.getName(), user.getEmail(), user.getPhone(),user.getAddres(),loansOfUSer);
        userRepository.modifyUser(user1);
    }
}
