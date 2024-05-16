package com.iesam.digitallibrary.loan.data.local;

import com.google.gson.Gson;
import com.iesam.digitallibrary.loan.domain.Loan;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class LoanFileLocalDataSource implements LoanLocalDataSource {
    private String nameFile = "loans.txt";
    private Gson gson = new Gson();

    @Override
    public void createLoan(Loan loan) {

        try {
            File ficheroLoan = new File(nameFile);
            if (!ficheroLoan.exists()) {
                ficheroLoan.createNewFile();
            }
            FileWriter myWriter = new FileWriter(nameFile, true);
            myWriter.write(gson.toJson(loan) + System.lineSeparator());
            myWriter.close();
            System.out.println("Se logro guardar el usuario");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la informacion");
            e.printStackTrace();
        }

    }

    @Override
    public void deleteLoan(String id) {
        try {
            File ficheroLoan = new File(nameFile);
            if (!ficheroLoan.exists()) {
                ficheroLoan.createNewFile();
            }
            Scanner scanner = new Scanner(ficheroLoan);
            ArrayList<Loan> loans = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                Loan loan = gson.fromJson(data, Loan.class);
                if (!loan.getIdLoan().equals(id)) {
                    loans.add(loan);
                }
            }
            FileWriter myWriter = new FileWriter(nameFile);
            for (Loan loan : loans) {
                myWriter.write(gson.toJson(loan) + System.lineSeparator());
            }
            myWriter.close();

        } catch (IOException e){
            System.out.println("Ha ocurrido un error al eliminar el usuario");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Loan> obtainLoansPending() {
        ArrayList<Loan> loans = new ArrayList<>();
        try {
            File ficheroLoan = new File(nameFile);
            if (!ficheroLoan.exists()) {
                ficheroLoan.createNewFile();
            }
            Scanner scanner = new Scanner(ficheroLoan);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                Loan loan = gson.fromJson(data, Loan.class);
                if(!loan.getStatusLoan().equals("Finished") ){
                    loans.add(loan);
                }

            }
            return loans;
        }catch (IOException e){
            System.out.println("Ha ocurrido un error al obtener el listado de usuarios");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Loan> obtainFinishedLoans() {
        ArrayList<Loan> loans = new ArrayList<>();
        try {
            File ficheroLoan = new File(nameFile);
            if (!ficheroLoan.exists()) {
                ficheroLoan.createNewFile();
            }
            Scanner scanner = new Scanner(ficheroLoan);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                Loan loan = gson.fromJson(data, Loan.class);
                if(loan.getStatusLoan().equals("Finished") ){
                    loans.add(loan);
                }

            }
            return loans;
        }catch (IOException e){
            System.out.println("Ha ocurrido un error al obtener el listado de usuarios");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void endedLoan(String id) {
        Loan loan= obtainSpecifiedLoan(id);
        deleteLoan(id);
        loan= new Loan(loan.getIdLoan(),loan.getIdUser(), loan.getIdDigitalResource(),"","");
        createLoan(loan);
    }

    @Override
    public ArrayList<Loan> obtainLoans() {
        ArrayList<Loan> loans = new ArrayList<>();
        try {
            File ficheroLoan = new File(nameFile);
            if (!ficheroLoan.exists()) {
                ficheroLoan.createNewFile();
            }
            Scanner scanner = new Scanner(ficheroLoan);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                Loan loan = gson.fromJson(data, Loan.class);
                loans.add(loan);
            }
            return loans;
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al obtener el listado de usuarios");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Loan obtainSpecifiedLoan(String id) {
        ArrayList <Loan> loans= obtainLoans();
        for(Loan loan:loans){
            if(loan.getIdLoan().equals(id)){
                return loan;
            }
        }
        return null;
    }
}
