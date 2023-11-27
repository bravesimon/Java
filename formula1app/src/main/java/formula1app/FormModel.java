package formula1app;

import javax.persistence.*;
import org.hibernate.annotations.Entity;

@Entity
@Table(name = "form")
public class FormModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int id;

    @Column(name="name")
    public String name;

    @Column(name="message")
    public String message;

    @Column(name="sent")
    public String sent;

    public FormModel(String name, String message, String sent) {
        this.name = name;
        this.message = message;
        this.sent = sent;
    }

    public FormModel() {
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
    }
}
