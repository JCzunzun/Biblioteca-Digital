package com.iesam.digitallibrary.user.data.local;

import com.iesam.digitallibrary.loan.domain.Loan;
import com.iesam.digitallibrary.user.domain.User;

import java.util.ArrayList;

public interface UserLocalDataSource {
    void createUser(User user);

    void deleteUSer(String id);

    void modifyUser(User user);

    ArrayList<User> getUsers();

    User getUser(String id);
    ArrayList<Loan> obtainLoansOfUser(String id);

}
