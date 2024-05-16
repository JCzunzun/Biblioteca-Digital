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

    @Override
    public ArrayList<DigitalResource> getAllResources() {
        ArrayList<DigitalResource> resources = new ArrayList<>();
        try {
            File ficheroResources = new File(nameFile);
            if (!ficheroResources.exists()) {
                ficheroResources.createNewFile();
            }
            Scanner scanner = new Scanner(ficheroResources);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                DigitalResource resource = gson.fromJson(data, DigitalResource.class);
                if(resource.getType().equals("Libro")){
                    resources.add(resource);
                }

            }
            return resources;
        }catch (IOException e){
            System.out.println("Ha ocurrido un error al obtener el listado de usuarios");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DigitalResource getDigitalResource(String id) {
        ArrayList<DigitalResource> resources= getAllResources();
        for(DigitalResource resource: resources){
            if(resource.getId().equals(id)){
                return resource;
            }
        }
        return null;
    }


}
