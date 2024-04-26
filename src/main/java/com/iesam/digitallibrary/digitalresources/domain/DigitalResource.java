package com.iesam.digitallibrary.digitalresources.domain;

public class DigitalResource {
    public final String id;
    public final String name;
    public final String stateOfDeterioration;
    public final String autor;

    public DigitalResource(String id, String name, String stateOfDeterioration, String autor) {
        this.id = id;
        this.name = name;
        this.stateOfDeterioration = stateOfDeterioration;
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStateOfDeterioration() {
        return stateOfDeterioration;
    }

    public String getAutor() {
        return autor;
    }
}
