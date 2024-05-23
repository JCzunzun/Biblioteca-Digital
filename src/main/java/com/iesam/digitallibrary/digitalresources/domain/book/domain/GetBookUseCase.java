package com.iesam.digitallibrary.digitalresources.domain.book.domain;

public class GetBookUseCase {
    private final BookRepository bookRepository;

    public GetBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book execute(String id) {
        return bookRepository.obtainBook(id);
    }
}
