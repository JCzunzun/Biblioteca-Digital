package com.iesam.digitallibrary.digitalresources.domain;

public class DigitalResource {
    public final String id;
    public final String name;
    public final String stateOfDeterioration;
    public final String autor;
    private String type;
    public final String loanStatus;

    public DigitalResource(String autor, String stateOfDeterioration, String name, String id) {
        this.autor = autor;
        this.stateOfDeterioration = stateOfDeterioration;
        this.name = name;
        this.id = id;
        loanStatus="Available";
    }

    public DigitalResource(String id, String name, String stateOfDeterioration, String autor, String loanStatus) {
        this.id = id;
        this.name = name;
        this.stateOfDeterioration = stateOfDeterioration;
        this.autor = autor;
        this.loanStatus = loanStatus;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
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

    @Override
    public String toString() {
        return "DigitalResource{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", stateOfDeterioration='" + stateOfDeterioration + '\'' +
                ", autor='" + autor + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
