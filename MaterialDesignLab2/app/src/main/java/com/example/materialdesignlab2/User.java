package com.example.materialdesignlab2;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String gender;
    private String[] languages;

    public User(String username, String password, String gender, String[] languages) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.languages = languages;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getGender() { return gender; }
    public String[] getLanguages() { return languages; }
}