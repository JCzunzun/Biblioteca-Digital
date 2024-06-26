package com.iesam.digitallibrary.user.domain;

import com.iesam.digitallibrary.loan.domain.Loan;

import java.util.ArrayList;

public interface UserRepository {
    void createUser(User user);

    void deleteUser(String id);

    void modifyUser(User user);

    ArrayList<User> getUsers();

    User getUser(String id);
    ArrayList<Loan> getLoansOfUser(String id);
}
