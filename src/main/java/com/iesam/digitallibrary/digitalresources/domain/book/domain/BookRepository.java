package com.iesam.digitallibrary.digitalresources.domain.book.domain;

public interface BookRepository {
    void createBook(Book book);
    void deleteBook(String id);
    void modifiedBook(Book book);
}
