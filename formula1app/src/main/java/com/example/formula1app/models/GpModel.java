package com.example.formula1app.models;

import javax.persistence.*;

@Entity
@Table(name = "gp")
public class GpModel {
    @Column(name = "datum")
    public int Date;

    @Id
    @Column(name = "nev")
    public String Name;

    @Column(name = "helyszin")
    public String Place;

    public GpModel() {
    }

    public GpModel(int date, String name, String place) {
        this.Date = date;
        this.Name = name;
        this.Place = place;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        Date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }
}