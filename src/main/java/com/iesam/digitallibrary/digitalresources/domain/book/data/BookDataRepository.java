package com.iesam.digitallibrary.digitalresources.domain.book.data;

import com.iesam.digitallibrary.digitalresources.data.local.DigitalResourceLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.book.data.local.BookLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.Book;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.BookRepository;

import java.util.ArrayList;

public class BookDataRepository implements BookRepository {
    DigitalResourceLocalDataSource digitalResourceLocalDataSource;
    public BookDataRepository(DigitalResourceLocalDataSource digitalResourceLocalDataSource){
        this.digitalResourceLocalDataSource= digitalResourceLocalDataSource;
    }
    @Override
    public void createBook(Book book) {
        digitalResourceLocalDataSource.createDigitalResource(book);
    }

    @Override
    public void deleteBook(String id) {

    }

    @Override
    public void modifiedBook(Book book) {

    }

    @Override
    public ArrayList<Book> getsBooks() {
        return null;
    }
}
