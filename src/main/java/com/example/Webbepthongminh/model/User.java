package com.example.Webbepthongminh.model;

// Model đại diện cho một người dùng
public class User {
    private String username;
    private String password;
    private String role; // "ADMIN" hoặc "USER"

    // Constructor mặc định
    public User() {}

    // Constructor đầy đủ
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters và Setters
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
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}