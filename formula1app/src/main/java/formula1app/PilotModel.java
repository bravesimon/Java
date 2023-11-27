package formula1app;

import javax.persistence.*;
import org.hibernate.annotations.Entity;
@Entity
@Table(name = "pilota")
public class PilotModel {
    @Id
    @Column(name = "az")
    private int Identifier;

    @Column(name = "nev")
    private String Name;

    @Column(name = "nem")
    private String Sex;

    @Column(name = "szuldat")
    private String BirthDate;

    @Column(name = "nemzet")
    private String Nation;

    public PilotModel() {
    }

    public PilotModel(String name, String sex, String birthDate, String nation) {
     //   Identifier = identifier;
        Name = name;
        Sex = sex;
        BirthDate = birthDate;
        Nation = nation;
    }

    public int getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(int identifier) {
        Identifier = identifier;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getNation() {
        return Nation;
    }

    public void setNation(String nation) {
        Nation = nation;
    }
}