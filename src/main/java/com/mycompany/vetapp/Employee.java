package com.mycompany.vetapp;

import  java.io.*;

public class Employee implements Serializable {
 
    private String name;
    private String surname;
    private job job1;
    private int idnumber;

    public Employee(String name, String surname, job job1, int idnumber) {
        this.name = name;
        this.surname = surname;
        this.job1 = job1;
        this.idnumber = idnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public job getJob1() {
        return job1;
    }

    public void setJob1(job job1) {
        this.job1 = job1;
    }

    public int getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(int idnumber) {
        this.idnumber = idnumber;
    }
    
}
