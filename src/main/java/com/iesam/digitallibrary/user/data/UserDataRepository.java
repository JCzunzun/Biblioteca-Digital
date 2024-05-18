package com.iesam.digitallibrary.user.data;

import com.iesam.digitallibrary.loan.domain.Loan;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.data.local.UserLocalDataSource;
import com.iesam.digitallibrary.user.data.local.UserMemLocalDataSource;
import com.iesam.digitallibrary.user.domain.User;
import com.iesam.digitallibrary.user.domain.UserRepository;

import java.util.ArrayList;

public class UserDataRepository implements UserRepository {
    UserLocalDataSource userLocalDataSource;
    public UserDataRepository(UserLocalDataSource userLocalDataSource){
        this.userLocalDataSource = userLocalDataSource;
    }
    UserFileLocalDataSource userFileLocalDataSource;
    UserMemLocalDataSource userMemLocalDataSource;
    public UserDataRepository(UserFileLocalDataSource userFileLocalDataSource, UserMemLocalDataSource userMemLocalDataSource){
        this.userFileLocalDataSource=userFileLocalDataSource;
        this.userMemLocalDataSource=userMemLocalDataSource;
    }
    @Override
    public void createUser(User user) {
        userFileLocalDataSource.createUser(user);
        userMemLocalDataSource.createUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userLocalDataSource.deleteUSer(id);
    }

    @Override
    public void modifyUser(User user) {
        userLocalDataSource.modifyUser(user);
    }

    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> usersMem=userMemLocalDataSource.getUsers();
        if(!usersMem.isEmpty()){
            return usersMem;
        }else {
            usersMem=userFileLocalDataSource.getUsers();
            for (User user : usersMem) {
                userMemLocalDataSource.createUser(user);
            }
            return usersMem;
        }
    }

    @Override
    public User getUser(String id) {
        User userMem=userMemLocalDataSource.getUser(id);

        if(userMem!=null){
            return userMem;
        }
        else {
            userMem=userFileLocalDataSource.getUser(id);
            userMemLocalDataSource.createUser(userMem);
            return userMem;
        }

    }

    @Override
    public ArrayList<Loan> getLoansOfUser(String id) {
        return userLocalDataSource.obtainLoansOfUser(id);
    }
}
