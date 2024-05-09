package com.iesam.digitallibrary.digitalresources.domain.book.domain;

public class ModifyBookUseCase {
    private final BookRepository bookRepository;

    public ModifyBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void execute(Book book){
        bookRepository.modifiedBook(book);
    }
}
