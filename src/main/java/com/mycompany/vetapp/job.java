package com.mycompany.vetapp;
import java.io.*;

public class job implements Serializable {
    private double salary ;
    private String nameofjob ;
    
    public job(double salary, String nameofjob) {
        this.salary = salary;
        this.nameofjob = nameofjob;
    }
    
    public boolean  equals(job job1)
    {
         return (this.salary == job1.salary && this.nameofjob.equals(job1.nameofjob));
        
         
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getNameofjob() {
        return nameofjob;
    }

    public void setNameofjob(String nameofjob) {
        this.nameofjob = nameofjob;
    }
    
}
