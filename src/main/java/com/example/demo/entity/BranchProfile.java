package com.example.demo.entity;

import java.time.LocalDate;

public class BrachProfile {
    private  Long id;
    private  String breanchCode;
    private  String BreanchName;
    private  String contactEmail;
    private LocalDataTime lastSyncAT;
    private Boolean active;

    public BrachProfile(float cgpa, LocalDate dob, int id, String name) {
        this.cgpa = cgpa;
        this.dob = dob;
        this.id = id;
        this.name = name;
    }

    public BrachProfile() {
    }
    
     public void setId(Long id) {
        this.id = id;
    }

    public void setbreanchCode(String breanchCode) {
        this.breanchCode = breanchCode;
    }


   


    public void setBreanchName(String BreanchName) {
        this.BreanchName = BreanchName;
    }


    public void setcontactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public void setlastSyncAT(LocalDataTime lastSyncAT) {
        this.lastSyncAT = contactEmail;
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
