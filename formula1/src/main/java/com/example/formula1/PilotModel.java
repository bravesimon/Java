package com.example.formula1;

import jakarta.persistence.*;

@Entity
@Table(name = "pilota")
public class PilotModel {
    @Id
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
