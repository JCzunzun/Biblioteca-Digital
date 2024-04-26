package com.iesam.digitallibrary.digitalresources.domain.book.data.local;

import com.iesam.digitallibrary.digitalresources.domain.book.domain.Book;

public interface BookLocalDataSource {
    void createBook(Book book);
    void deleteBook(String id);
    void modifiedBook(Book book);
}
