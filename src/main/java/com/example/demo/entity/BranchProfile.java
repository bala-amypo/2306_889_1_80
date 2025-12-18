package com.example.demo.entity;

import java.time.LocalDate;

public class Studententity {
    private  int id;
    private  String name;
    private  LocalDate dob;
    private  float cgpa;

    public Studententity(float cgpa, LocalDate dob, int id, String name) {
        this.cgpa = cgpa;
        this.dob = dob;
        this.id = id;
        this.name = name;
    }

    public Studententity() {
    }
    

    public void setName(String name) {
        this.name = name;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setDob(LocalDate dob) {
        this.dob = dob;
    }


    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public float getCgpa() {
        return cgpa;
    }
}
