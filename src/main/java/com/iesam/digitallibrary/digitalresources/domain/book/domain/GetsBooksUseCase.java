package com.iesam.digitallibrary.digitalresources.domain.book.domain;

import java.util.ArrayList;

public class GetsBooksUseCase {
    private final BookRepository bookRepository;

    public GetsBooksUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public ArrayList<Book> execute(){
        return bookRepository.getsBooks();
    }
}
