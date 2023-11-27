package formula1app;

import javafx.event.ActionEvent;
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

    @FXML private TableColumn<FormModel, String> IDCol = new TableColumn("Id");;
    @FXML private TableColumn<FormModel, String> nameCol= new TableColumn("Név");
    @FXML private TableColumn<FormModel, String> messageCol = new TableColumn("Uzenet");
    @FXML private TableColumn<FormModel, String> sentCol = new TableColumn("Kuldes ideje");

    @FXML void initialize(){
        IDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        messageCol.setCellValueFactory(new PropertyValueFactory<>("message"));
        sentCol.setCellValueFactory(new PropertyValueFactory<>("sent"));

        //ElemekTörlése();
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        try {
            cfg.addAnnotatedClass(formula1app.FormModel.class);
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
        FormModel form = new FormModel(tfName.getText(), tfMessage.getText(), tfSentTime.getText());
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
        tv1.getColumns().addAll(IDCol, nameCol, messageCol, sentCol);

        tv1.getItems().clear();

        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        // FormModel fm = (FormModel) session.get(FormModel.class, 2);
        List<FormModel> list2 = session.createQuery("from formula1app.FormModel").getResultList();
        List<FormModel> list = session.createQuery("FROM formula1app.FormModel").list();

        System.out.println("list: " + list.size());
        System.out.println("list2: " + list2.size());

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

    public void menSoapDownload(ActionEvent actionEvent) {
    }

    public void menSoapDownload2(ActionEvent actionEvent) {
    }

    public void menSoapGrafikon(ActionEvent actionEvent) {
    }

    public void menuAdatbanyaszat(ActionEvent actionEvent) {
    }

    public void menuOthersStream(ActionEvent actionEvent) {
    }

    public void menuOthersParalell(ActionEvent actionEvent) {
        //

    }
}
