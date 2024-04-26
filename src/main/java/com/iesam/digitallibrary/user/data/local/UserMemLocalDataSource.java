package com.iesam.digitallibrary.user.data.local;

import com.iesam.digitallibrary.user.domain.User;

import java.util.ArrayList;

public class UserMemLocalDataSource implements UserLocalDataSource {
    ArrayList<User> users= new ArrayList<>();
    private static UserMemLocalDataSource instance=null;
    public UserMemLocalDataSource newInstance(){
        if(instance== null){
            instance= new UserMemLocalDataSource();
        }
        return instance;
    }
    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUSer(String id) {
        for(User user: users){
            if(user.getId().equals(id)){
                users.remove(user);
            }
        }
    }

    @Override
    public void modifyUser(User user) {
        deleteUSer(user.getId());
        createUser(user);
    }

    @Override
    public ArrayList<User> getUsers() {
        return users;
    }
}
