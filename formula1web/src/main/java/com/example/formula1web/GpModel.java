package com.example.formula1web;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.xml.crypto.Data;
import java.sql.Date;

@Entity
@Table(name = "gp")
public class GpModel {
    @Column(name="datum")
    private String date;

    @Id
    @Column(name="nev")
    private String name;

    @Column(name="helyszin")
    private String place;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
