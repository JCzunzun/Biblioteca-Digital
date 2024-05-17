package com.iesam.digitallibrary.digitalresources.domain.book.data;

import com.iesam.digitallibrary.digitalresources.data.local.DigitalResourceLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.book.data.local.BookLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.Book;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.BookRepository;

import java.util.ArrayList;

public class BookDataRepository implements BookRepository {
    BookLocalDataSource bookLocalDataSource;
    public BookDataRepository(BookLocalDataSource bookLocalDataSource){
        this.bookLocalDataSource= bookLocalDataSource;
    }
    @Override
    public void createBook(Book book) {
        bookLocalDataSource.createBook(book);
    }

    @Override
    public void deleteBook(String id) {
        bookLocalDataSource.deleteBook(id);
    }

    @Override
    public void modifiedBook(Book book) {
        bookLocalDataSource.modifiedBook(book);
    }

    @Override
    public ArrayList<Book> getsBooks() {
        return bookLocalDataSource.getsBooks();
    }

    @Override
    public Book obtainBook(String id) {
        return bookLocalDataSource.obtainBook(id);
    }
}
