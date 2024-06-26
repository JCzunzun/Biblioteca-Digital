package com.iesam.digitallibrary.user.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.digitallibrary.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.loan.domain.GetFinishedLoansUseCase;
import com.iesam.digitallibrary.loan.domain.GetLoansPendingUseCase;
import com.iesam.digitallibrary.loan.domain.Loan;
import com.iesam.digitallibrary.user.domain.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class UserFileLocalDataSource implements UserLocalDataSource {
    private String nameFile = "users.txt";
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
            FileWriter myWriter = new FileWriter(nameFile, true);
            myWriter.write(gson.toJson(user) + System.lineSeparator());
            myWriter.close();
            System.out.println("Se logro guardar el usuario");
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
        try {
            File ficheroUSer = new File(nameFile);
            if (!ficheroUSer.exists()) {
                ficheroUSer.createNewFile();
            }
            Scanner scanner = new Scanner(ficheroUSer);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                User user = gson.fromJson(data, User.class);
                users.add(user);
            }
            return users;
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al obtener el listado de usuarios");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUser(String id) {
        ArrayList<User> users = getUsers();
        for (User user : users) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Loan> obtainLoansOfUser(String id) {
        User user= getUser(id);
        ArrayList<Loan> loans= user.getLoanActives();
        return loans;

    }

}

