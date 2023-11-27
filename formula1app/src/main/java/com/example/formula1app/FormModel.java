package com.example.formula1app;

import javax.persistence.*;

@Entity
@Table(name = "form")
public class FormModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FormModel() {
    }
    public FormModel(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "FormModel{" +
                "id=" + id +
                '}';
    }

  /*  @Column(name="name")
    private String name;

    @Column(name="message")
    private String message;

    @Column(name="sent")
    private String sent;

    public FormModel() {
    }

    public FormModel(int id, String name, String message, String sent) {
       this.id = id;
        this.name = name;
        this.message = message;
        this.sent = sent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }*/
}
