package com.iesam.digitallibrary.digitalresources.domain.book.domain;

import java.util.ArrayList;

public interface BookRepository {
    void createBook(Book book);
    void deleteBook(String id);
    void modifiedBook(Book book);
    ArrayList<Book> getsBooks();
    Book obtainBook(String id);
}
