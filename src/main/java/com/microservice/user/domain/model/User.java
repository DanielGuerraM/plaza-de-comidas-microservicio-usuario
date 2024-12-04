package com.microservice.user.domain.model;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class User {
    private long id;
    private String name;
    private String lastName;
    private int age;
    private long documentNumber;
    private String phone;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private Role role;

    public User(long id, String name, String lastName, int age, long documentNumber, String phone, LocalDate dateOfBirth, String email, String password, Role role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.documentNumber = documentNumber;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public boolean validateAge(int age) {
        return age > 18;
    }

    public boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }

    public boolean validatePhone(String phone) {
        return phone.length() <= 13;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public Role getRoleId() {
        return role;
    }

    public void setRoleId(Role role) {
        this.role = role;
    }
}