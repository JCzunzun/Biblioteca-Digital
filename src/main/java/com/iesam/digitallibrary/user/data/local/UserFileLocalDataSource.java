package com.iesam.digitallibrary.user.data.local;

import com.iesam.digitallibrary.user.domain.User;

import java.io.*;

public class UserFileLocalDataSource implements UserLocalDataInterface{
    private String nameFile="users.bin";
   @Override
    public void createUser(User user) {
        try(OutputStream os = new FileOutputStream(nameFile,true);
            ObjectOutputStream oos= new ObjectOutputStream(os); ){
            oos.writeObject(user);
            oos.close();
            System.out.println("No se logro guardar el usuario");
        }catch (IOException e){
            System.out.println("Ha ocurrido un error al guardar la informacion");
            e.printStackTrace();
        }
    }
}
