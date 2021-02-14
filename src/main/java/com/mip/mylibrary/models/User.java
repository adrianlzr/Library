package com.mip.mylibrary.models;

import java.util.UUID;

public class User {
    public enum UserRole {
        cititor,
        bibliotecar
    }

    private UUID id;
    private String nume;
    private String prenume;
    private String email;
    private String password;
    private UserRole rol;

    public User(String nume, String prenume, String email, String password, UserRole rol) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserRole getRole() {
        return rol;
    }

    public void setRole(UserRole role) {
        this.rol = role;
    }

    public String getId() {
        return id.toString();
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
}
