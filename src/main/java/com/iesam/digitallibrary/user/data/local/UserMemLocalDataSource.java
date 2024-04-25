package com.iesam.digitallibrary.user.data.local;

import com.iesam.digitallibrary.user.domain.User;

import java.util.ArrayList;
import java.util.Map;

public class UserMemLocalDataSource implements  UserLocalDataInterface{
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
}
