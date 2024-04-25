package com.iesam.digitallibrary.user.data;

import com.iesam.digitallibrary.user.data.local.UserLocalDataInterface;
import com.iesam.digitallibrary.user.domain.User;
import com.iesam.digitallibrary.user.domain.UserRepository;

public class UserDataRepository implements UserRepository {
    UserLocalDataInterface userLocalDataInterface;
    public UserDataRepository(UserLocalDataInterface userLocalDataInterface){
        this.userLocalDataInterface= userLocalDataInterface;
    }
    @Override
    public void createUser(User user) {
        userLocalDataInterface.createUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userLocalDataInterface.deleteUSer(id);
    }
}
