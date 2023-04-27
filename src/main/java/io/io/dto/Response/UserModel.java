package io.io.dto.Response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


public class UserModel {
    private long id;

    private String username;

    private String email;

    private String name;


    public UserModel() {
    }

    public UserModel(long id, String username, String email, String name) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
