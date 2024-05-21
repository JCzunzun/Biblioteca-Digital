package com.iesam.digitallibrary.digitalresources.domain.book.domain;

import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;

public class Book extends DigitalResource {
    public final String numberOfPages;
    public final String description;
    public final String gender;

    public Book(String id, String name, String stateOfDeterioration, String autor, String numberOfPages, String description, String gender) {
        super(autor, stateOfDeterioration, name, id);
        this.numberOfPages = numberOfPages;
        this.description = description;
        this.gender = gender;
    }

    public Book(String id, String name, String stateOfDeterioration, String autor, String loanStatus, String gender, String description, String numberOfPages) {
        super(id, name, stateOfDeterioration, autor, loanStatus);
        this.gender = gender;
        this.description = description;
        this.numberOfPages = numberOfPages;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public String getDescription() {
        return description;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Book{" +
                "autor='" + autor + '\'' +
                ", stateOfDeterioration='" + stateOfDeterioration + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                ", numberOfPages='" + numberOfPages + '\'' +
                '}';
    }
}
