package com.lab01.psoft.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Subject {

    protected String name;
    protected Double grade;
    protected Integer id;

    public Subject(Integer id, String name, Double grade){
        this.name = name;
        this.grade = grade;
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public Double getGrade(){
        return this.grade;
    }

    public void setGrade(double grade){
        this.grade = grade;
    }

    public String toString(){
        return String.format( "id: %d, nome: %s, nota: %.2f", this.id, this.name, this.grade);
    }



}
