package com.iesam.digitallibrary.digitalresources.domain.book.data.local;

import com.iesam.digitallibrary.digitalresources.domain.book.domain.Book;

import java.util.ArrayList;

public class BookMemLocalDataSource implements BookLocalDataSource{
    ArrayList<Book> books= new ArrayList<>();
    private static BookMemLocalDataSource instance=null;
    public BookMemLocalDataSource newInstance(){
        if(instance== null){
            instance= new BookMemLocalDataSource();
        }
        return instance;
    }
    @Override
    public void createBook(Book book) {
        books.add(book);
    }

    @Override
    public void deleteBook(String id) {
        for(Book book:books){
            if(book.getId().equals(id)){
                books.remove(book);
            }
        }
    }

    @Override
    public void modifiedBook(Book book) {
        deleteBook(book.getId());
        createBook(book);
    }

    @Override
    public ArrayList<Book> getsBooks() {
        return books;
    }

    @Override
    public Book obtainBook(String id) {
        for(Book book: books){
            if(book.getId().equals(id)){
                return book;
            }
        }
        return null;
    }
}
