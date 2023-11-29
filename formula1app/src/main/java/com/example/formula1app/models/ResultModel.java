package com.example.formula1app.models;

import javax.persistence.*;

@Entity
@Table(name = "eredmeny")
public class ResultModel {
    @Column(name="datum")
    public String Date;

    @Id
    @Column(name="pilotaaz")
    public int PilotId;

    @Column(name="helyezes")
    public String Place;

    @Column(name="hiba")
    public String Mistake;

    @Column(name="csapat")
    public String Team;

    @Column(name="tipus")
    public String Type;

    @Column(name="motor")
    public String Motor;

    public ResultModel() {
    }

    public ResultModel(String date, int pilotId, String place, String mistake, String team, String type, String motor) {
        Date = date;
        PilotId = pilotId;
        Place = place;
        Mistake = mistake;
        Team = team;
        Type = type;
        Motor = motor;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getPilotId() {
        return PilotId;
    }

    public void setPilotId(int pilotId) {
        PilotId = pilotId;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getMistake() {
        return Mistake;
    }

    public void setMistake(String mistake) {
        Mistake = mistake;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getMotor() {
        return Motor;
    }

    public void setMotor(String motor) {
        Motor = motor;
    }
}
