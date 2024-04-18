package com.iesam.digitallibrary.user.data.local;

import com.iesam.digitallibrary.user.domain.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileLocalDataSource implements UserLocalDataInterface {
    private String nameFile = "users.bin";

    @Override
    public void createUser(User user) {
        try (FileOutputStream os = new FileOutputStream(nameFile, true);
             ObjectOutputStream oos = new ObjectOutputStream(os);) {
            oos.writeObject(user);
            oos.close();
            System.out.println("No se logro guardar el usuario");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la informacion");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUSer(String id) {
        try (FileInputStream is = new FileInputStream(nameFile);
             ObjectInputStream ois = new ObjectInputStream(is);
             OutputStream os = new FileOutputStream(nameFile);
             ObjectOutputStream oos = new ObjectOutputStream(os);) {
            List<User> users = new ArrayList<>();
            for (; ; ) {
                try {
                    users.add((User) ois.readObject());
                } catch (EOFException e) {
                    System.out.println("Archivo terminado de leer");
                    break;
                } catch (ClassNotFoundException e) {
                    System.out.println("Archivo no encontrado");
                    break;
                }
            }
            for (User user : users) {
                if (user.getId().equals(id)) {
                    users.remove(user);
                }
            }
            for (User user : users) {
                oos.writeObject(user);
            }

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al eliminar el usuario");
            e.printStackTrace();
        }
    }

    @Override
    public void modifyUser(User user) {
        deleteUSer(user.getId());
        createUser(user);
    }

    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (FileInputStream is = new FileInputStream(nameFile);
             ObjectInputStream ois = new ObjectInputStream(is);) {

            for (; ; ) {
                try {
                    users.add((User) ois.readObject());
                } catch (EOFException e) {
                    System.out.println("Archivo terminado de leer");
                    break;
                } catch (ClassNotFoundException e) {
                    System.out.println("Archivo no encontrado");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al obtener los usuarios");
            e.printStackTrace();
        }

        return users;
    }
}
