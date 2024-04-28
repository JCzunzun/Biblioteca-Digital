package com.iesam.digitallibrary.loan.data.local;

import com.google.gson.Gson;
import com.iesam.digitallibrary.loan.domain.Loan;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
}
