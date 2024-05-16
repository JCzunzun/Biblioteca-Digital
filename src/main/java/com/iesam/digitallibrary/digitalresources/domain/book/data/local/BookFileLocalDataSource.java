package com.iesam.digitallibrary.digitalresources.domain.book.data.local;

import com.google.gson.Gson;
import com.iesam.digitallibrary.digitalresources.data.local.DigitalResourceFileLocalDataSource;
import com.iesam.digitallibrary.digitalresources.data.local.DigitalResourceLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.Book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookFileLocalDataSource implements BookLocalDataSource{
    private String nameFile="DigitalResource.txt";
    private Gson gson = new Gson();
    DigitalResourceLocalDataSource digitalResourceLocalDataSource;
    public BookFileLocalDataSource(DigitalResourceLocalDataSource digitalResourceLocalDataSource){
        this.digitalResourceLocalDataSource= digitalResourceLocalDataSource;
    }

    @Override
    public void createBook(Book book) {
        digitalResourceLocalDataSource.createDigitalResource(book);
    }

    @Override
    public void deleteBook(String id) {
        try {

            File ficheroBook = new File(nameFile);
            if (!ficheroBook.exists()) {
                ficheroBook.createNewFile();
            }
            Scanner scanner = new Scanner(ficheroBook);
            ArrayList<Book> books = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                Book book = gson.fromJson(data, Book.class);
                if (!book.getId().equals(id)) {
                    books.add(book);
                }
            }
            FileWriter myWriter = new FileWriter(nameFile);
            for (Book book : books) {
                myWriter.write(gson.toJson(book) + System.lineSeparator());
            }
            myWriter.close();

        } catch (IOException e){
            System.out.println("Ha ocurrido un error al eliminar el usuario");
            e.printStackTrace();
        }
    }

    @Override
    public void modifiedBook(Book book) {
        deleteBook(book.getId());
        createBook(book);
    }

    @Override
    public ArrayList<Book> getsBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            File ficheroBook = new File(nameFile);
            if (!ficheroBook.exists()) {
                ficheroBook.createNewFile();
            }
            Scanner scanner = new Scanner(ficheroBook);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                Book book = gson.fromJson(data, Book.class);
                if(book.getType().equals("Libro")){
                    books.add(book);
                }

            }
            return books;
        }catch (IOException e){
            System.out.println("Ha ocurrido un error al obtener el listado de usuarios");
            e.printStackTrace();
        }
        return null;
    }

}
