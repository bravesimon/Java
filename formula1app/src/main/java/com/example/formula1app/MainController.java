package com.example.formula1app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainController {
    private SessionFactory factory;

    @FXML private Label lb1;
    @FXML private GridPane gp1;
    @FXML private TextField tfName, tfMessage, tfSentTime;
    @FXML private TableView tv1;

    @FXML private TableColumn<FormModel, String> IDCol;
    @FXML private TableColumn<FormModel, String> nameCol;
    @FXML private TableColumn<FormModel, String> messageCol;
    @FXML private TableColumn<FormModel, String> sentCol;


    @FXML void initialize(){
        //ElemekTörlése();
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        try {
            factory = cfg.buildSessionFactory();

            lb1.setText("Adatbázis hasznalatra kesz.");
        }catch (Exception e) {
            System.out.println("e: " + e.getMessage());
            lb1.setText("Adatbázis inicializalasa sikertelen.");

        }
    }

    @FXML protected void menuCreateClick() {
        //ElemekTörlése();
        gp1.setVisible(true);
        gp1.setManaged(true);
    }
    void Create(){
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        FormModel form =new FormModel();

//        FormModel form =new FormModel(14, tfName.getText(), tfMessage.getText(), tfSentTime.getText());
     /*   FormModel form =new FormModel();
    form.setName(tfName.getText());
    form.setMessage( tfMessage.getText());
    form.setSent(tfSentTime.getText());*/

        session.save(form);
        t.commit();
    }
    @FXML void bt1Click(){
        Create();
       // ElemekTörlése();
        lb1.setVisible(true);
        lb1.setManaged(true);
        lb1.setText("Adatok beírva az adatbázisba");
    }

    @FXML protected void menuReadClick() {
       // ElemekTörlése();
        tv1.setVisible(true);
        tv1.setManaged(true);
        tv1.getColumns().removeAll(tv1.getColumns());

        IDCol = new TableColumn("Id");
        nameCol = new TableColumn("Név");
        messageCol = new TableColumn("Uzenet");
        sentCol = new TableColumn("Kuldes ideje");

        tv1.getColumns().addAll(IDCol, nameCol, messageCol, sentCol);

        IDCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Név"));
        messageCol.setCellValueFactory(new PropertyValueFactory<>("Uzenet"));
        sentCol.setCellValueFactory(new PropertyValueFactory<>("Kuldes ideje"));
        tv1.getItems().clear();

        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List<FormModel> list = session.createQuery("FROM com.example.formula1app.FormModel").list();

        for(FormModel form : list) {
            tv1.getItems().add(form);
        }

        System.out.println();
        t.commit();
    }

    @FXML protected void menuUpdateClick() {
        /*hasonló mint a Create
        pl. az ID-t, aminek az adatait meg akarjuk változtatni lenyíló listából (ComboBox) válasszuk ki.
        Az alatta levő TextField-ek közül, amit kitölt a felhasználó, azokkal módosítani az adott rekordot.*/
    }
    @FXML protected void menuDeleteClick() {
        /* pl. az ID-t, amit törölni akarunk lenyíló listából (ComboBox) válasszuk ki.
Minden esetben a művelet után kiírni, hogy sikeres volt-e, különben hibaüzenet */
    }
}
