package com.iesam.digitallibrary.digitalresources.domain.book.domain;

public class BookFactory {
    public static Book Build(String id, String name, String stateOfDeterioration, String autor, String loanStatus, String gender, String description, String numberOfPages) {
        return new Book(id, name, stateOfDeterioration, autor, loanStatus, gender, description, numberOfPages);
    }
}
