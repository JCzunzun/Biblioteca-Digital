package com.iesam.digitallibrary.user.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.digitallibrary.user.domain.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserFileLocalDataSource implements UserLocalDataInterface{
    private String nameFile="users.txt";
    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<User>() {
    }.getType();

    @Override
    public void createUser(User user) {
        try {
            File ficheroUSer = new File(nameFile);
            if (!ficheroUSer.exists()) {
                ficheroUSer.createNewFile();
            }
            FileWriter myWriter = new FileWriter(nameFile,true);
            myWriter.write(gson.toJson(user)+System.lineSeparator());
            myWriter.close();
            System.out.println("No se logro guardar el usuario");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la informacion");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUSer(String id) {
        try {

            File ficheroUSer = new File(nameFile);
            if (!ficheroUSer.exists()) {
                ficheroUSer.createNewFile();
            }
            Scanner scanner = new Scanner(ficheroUSer);
            ArrayList<User> users = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                User user = gson.fromJson(data, User.class);
                if (!user.getId().equals(id)) {
                    users.add(user);
                }
            }
            FileWriter myWriter = new FileWriter(nameFile);
            for (User user : users) {
                myWriter.write(gson.toJson(user) + System.lineSeparator());
            }
            myWriter.close();

        } catch (IOException e){
            System.out.println("Ha ocurrido un error al eliminar el usuario");
            e.printStackTrace();
        }
    }
}
