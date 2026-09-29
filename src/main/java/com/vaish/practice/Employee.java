package com.vaish.practice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Employee {

    private int id;
    @NotBlank(message = "Employee must not be Null or Empty")
    private String name;
    @Positive(message = "Salary must be Greater than Zero")
    private long salary;

    public void setID(int id){
        this.id= id;
    }
    public  void setName(String name){
        this.name= name;
    }
    public void setSalary(long salary){
        this.salary= salary;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public long getSalary(){
        return salary;
    }

    public Employee(){

    }
    public  Employee (int id, String name, long salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }
}

