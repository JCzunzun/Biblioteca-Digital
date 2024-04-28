package com.iesam.digitallibrary.digitalresources.domain.book.domain;

public class ModifiedBookUseCase {
    private final BookRepository bookRepository;

    public ModifiedBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void execute(Book book){
        bookRepository.modifiedBook(book);
    }
}
