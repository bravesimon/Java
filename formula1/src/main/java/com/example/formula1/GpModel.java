package com.example.formula1;

import jakarta.persistence.*;

@Entity
@Table(name = "gp")
public class GpModel {
    @Column(name="datum")
    private int  date;

    @Id
    @Column(name="nev")
    private String name;

    @Column(name="helyszin")
    private String place;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
