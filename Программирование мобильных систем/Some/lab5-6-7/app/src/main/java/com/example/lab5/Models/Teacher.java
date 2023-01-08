package com.example.lab5.Models;

import java.io.Serializable;

public class Teacher implements Serializable {
    public int Id = 0;
    public String firstName;
    public String lastName;
    public String patronymic;

    public String pathImage;

    public Teacher(){}

    public Teacher(String firstName, String lastName, String patronymic, String pathImage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.pathImage = pathImage;
    }

    public String GetSurnameWithInitials(){
        return this.lastName.trim() + ' ' + this.firstName.trim().charAt(0) + ' ' + this.patronymic.trim().charAt(0);
    }

}
