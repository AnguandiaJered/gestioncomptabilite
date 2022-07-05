package com.example.comptabilite.models;

import javax.persistence.*;

@Entity
public class Users {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 300 , name = "username")
    private String username;
    @Column(nullable = false, length = 300 , name = "password")
    private String password;
    @Column(nullable = false, length = 300 , name = "email")
    private String email;
    @Column(nullable = false, length = 300 , name = "role")
    private String role;
}
