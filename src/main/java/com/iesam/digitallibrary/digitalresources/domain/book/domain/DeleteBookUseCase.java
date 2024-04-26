package com.iesam.digitallibrary.digitalresources.domain.book.domain;

public class DeleteBookUseCase {
    private final BookRepository bookRepository;

    public DeleteBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void execute (String id){
        bookRepository.deleteBook(id);
    }
}
