package com.iesam.digitallibrary.digitalresources.domain.book.data;

import com.iesam.digitallibrary.digitalresources.domain.book.data.local.BookLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.Book;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.BookRepository;

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
}
