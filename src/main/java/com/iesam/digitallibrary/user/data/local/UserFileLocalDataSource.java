package com.iesam.digitallibrary.user.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.digitallibrary.user.domain.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserFileLocalDataSource implements UserLocalDataInterface {
    private String nameFile = "users.bin";
    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<User>>() {
    }.getType();

    @Override
    public void createUser(User user) {
        try{
            File ficheroUSer = new File(nameFile);
            if (!ficheroUSer.exists()) {
                ficheroUSer.createNewFile();
            }
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(user));
            myWriter.close();
            System.out.println("No se logro guardar el usuario");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la informacion");
            e.printStackTrace();
        }
    }
}

