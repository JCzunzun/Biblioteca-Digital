package com.iesam.digitallibrary.digitalresources.domain.book.data.local;

import com.google.gson.Gson;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.Book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookFileLocalDataSource implements BookLocalDataSource{
    private String nameFile="books.txt";
    private Gson gson = new Gson();
    @Override
    public void createBook(Book book) {
        try {
            File ficheroUSer = new File(nameFile);
            if (!ficheroUSer.exists()) {
                ficheroUSer.createNewFile();
            }
            FileWriter myWriter = new FileWriter(nameFile,true);
            myWriter.write(gson.toJson(book)+System.lineSeparator());
            myWriter.close();
            System.out.println("Se logro guardar el usuario");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la informacion");
            e.printStackTrace();
        }
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
}
