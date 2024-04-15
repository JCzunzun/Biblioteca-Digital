package com.iesam.digitallibrary.digitalresources.book.domain;

import com.iesam.digitallibrary.digitalresources.DigitalResource;

public class Book extends DigitalResource {
    public final String numberOfPages;
    public final String description;

    public final String gender;

    public Book(String id, String name, String stateOfDeterioration, String autor, String numberOfPages, String description, String gender) {
        super(id, name, stateOfDeterioration, autor);
        this.numberOfPages = numberOfPages;
        this.description = description;
        this.gender = gender;
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
}
