package formula1app;

import javax.persistence.*;
import org.hibernate.annotations.Entity;

@Entity
@Table(name = "gp")
public class GpModel {
    @Column(name = "datum")
    public String Date;

    @Id
    @Column(name = "nev")
    public String Name;

    @Column(name = "helyszin")
    public String Place;

    public GpModel() {
    }

    public GpModel(String date, String name, String place) {
        Date = date;
        Name = name;
        Place = place;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
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