package com.iesam.digitallibrary.user.data;

import com.iesam.digitallibrary.user.data.local.UserLocalDataSource;
import com.iesam.digitallibrary.user.domain.User;
import com.iesam.digitallibrary.user.domain.UserRepository;

import java.util.ArrayList;

public class UserDataRepository implements UserRepository {
    UserLocalDataSource userLocalDataSource;
    public UserDataRepository(UserLocalDataSource userLocalDataSource){
        this.userLocalDataSource = userLocalDataSource;
    }
    @Override
    public void createUser(User user) {
        userLocalDataSource.createUser(user);
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
        return userLocalDataSource.getUsers();
    }

    @Override
    public User getUser(String id) {
        return userLocalDataSource.getUser(id);
    }
}
