package com.iesam.digitallibrary.user.data.local;

import com.iesam.digitallibrary.user.domain.User;

import java.util.ArrayList;

public interface UserLocalDataInterface {
    void createUser(User user);
    void deleteUSer(String id);
    void modifyUser(User user);
    ArrayList<User> getUsers();
}
