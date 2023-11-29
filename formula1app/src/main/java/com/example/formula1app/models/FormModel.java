package com.example.formula1app.models;

import javax.persistence.*;

@Entity
@Table(name = "form")
public class FormModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int Id;

    @Column(name="name")
    public String Name;

    @Column(name="message")
    public String Message;

    @Column(name="sent")
    public String Sent;

    public FormModel(String name, String message, String sent) {
        Name = name;
        Message = message;
        Sent = sent;
    }

    public FormModel() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getSent() {
        return Sent;
    }

    public void setSent(String sent) {
        Sent = sent;
    }
}
