package com.example.formula1.db;

import jakarta.persistence.*;

@Entity
public class PilotModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="az")
    private int identifier;

    @Column(name="nev")
    private String name;

    @Column(name="nem")
    private String sex;

    @Column(name="szuldat")
    private String szuldat;

    @Column(name="nemzet")
    private String nation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSzuldat() {
        return szuldat;
    }

    public void setSzuldat(String szuldat) {
        this.szuldat = szuldat;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
