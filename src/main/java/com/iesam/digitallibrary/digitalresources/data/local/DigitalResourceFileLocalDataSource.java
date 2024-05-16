package com.iesam.digitallibrary.digitalresources.data.local;

import com.google.gson.Gson;
import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.Book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DigitalResourceFileLocalDataSource implements DigitalResourceLocalDataSource{
    private String nameFile="DigitalResource.txt";
    private Gson gson = new Gson();
    @Override
    public void createDigitalResource(DigitalResource digitalResource) {
        try {
            File ficheroResource = new File(nameFile);
            if (!ficheroResource.exists()) {
                ficheroResource.createNewFile();
            }
            FileWriter myWriter = new FileWriter(nameFile,true);
            myWriter.write(gson.toJson(digitalResource)+System.lineSeparator());
            myWriter.close();
            System.out.println("Se logro guardar el usuario");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la informacion");
            e.printStackTrace();
        }
    }


}
