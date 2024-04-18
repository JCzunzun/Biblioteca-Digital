package com.iesam.digitallibrary.user.domain;

public class User {
    public final String id;
    public final String dni;
    public final String name;
    public final String email;
    public final String phone;
    public final String addres;
    public final String loanActives;

    public User(String id, String dni, String name, String email, String phone, String addres, String loanActives) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.addres = addres;
        this.loanActives = loanActives;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddres() {
        return addres;
    }

    public String getLoanActives() {
        return loanActives;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", addres='" + addres + '\'' +
                ", loanActives='" + loanActives + '\'' +
                '}';
    }
}
