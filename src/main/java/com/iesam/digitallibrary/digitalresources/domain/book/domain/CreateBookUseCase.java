package com.iesam.digitallibrary.digitalresources.domain.book.domain;

public class CreateBookUseCase {
    private final BookRepository bookRepository;

    public CreateBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute(Book book) {
        book.setType("Libro");
        bookRepository.createBook(book);
    }
}
