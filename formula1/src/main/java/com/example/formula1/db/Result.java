package com.example.formula1.db;

import jakarta.persistence.*;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="datum")
    private int  date;

    @Column(name="pilotaaz")
    private int pilotId;

    @Column(name="helyezes")
    private String place;

    @Column(name="hiba")
    private String mistake;

    @Column(name="csapat")
    private String team;

    @Column(name="tipus")
    private String type;

    @Column(name="motor")
    private String motor;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMistake() {
        return mistake;
    }

    public void setMistake(String mistake) {
        this.mistake = mistake;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }
}
