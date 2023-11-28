package formula1app.controllers;

import formula1app.models.FormModel;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MainController {
    enum eCRUDstate {
        read, read2, write, update, delete, initOrNotUsed
    }

    private SessionFactory factory;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    private eCRUDstate currentState;

    @FXML private Label lbVisszajelzes, lbName, lbUzenet;
    @FXML private GridPane gp;
    @FXML private GridPane gpRead2;
    @FXML private TextField tfName, tfMessage;
    @FXML private TableView tV;
    @FXML private ComboBox cbUpdate;
    @FXML private Button btKuldes;

    private IEntityController modelController;

    private void SetVisiblity(eCRUDstate state) {
        gp.setVisible( state != eCRUDstate.initOrNotUsed);
        tV.setVisible(state == eCRUDstate.read);

        boolean btBool = (state == eCRUDstate.delete || state == eCRUDstate.update || state == eCRUDstate.write);
        btKuldes.setVisible(btBool);
        tfName.setVisible(btBool);
        tfMessage.setVisible(btBool);
        lbName.setVisible(btBool);
        lbUzenet.setVisible(btBool);

        boolean cbBool = (state == eCRUDstate.delete || state == eCRUDstate.update);
        cbUpdate.setVisible(cbBool);

        currentState = state;
    }

    @FXML void initialize(){
        modelController = new FormModelController();
        SetVisiblity(eCRUDstate.initOrNotUsed);

        try {
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            cfg.addAnnotatedClass(FormModel.class);
            factory = cfg.buildSessionFactory();
            lbVisszajelzes.setText("Adatbázis hasznalatra kesz.");
        }catch (Exception e) {
            System.out.println("e: " + e.getMessage());
            lbVisszajelzes.setText("Adatbázis inicializalasa sikertelen.");
        }
    }

    @FXML protected void menuCreateClick() {
        SetVisiblity(eCRUDstate.write);
    }

    @FXML protected void menuReadClick() {
        SetVisiblity(eCRUDstate.read);

        tV.getColumns().removeAll(tV.getColumns());
        tV.getColumns().addAll(modelController.GetAll());

        try {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            List<FormModel> list = session.createQuery(modelController.GetReadQuery()).list();
            tV.getItems().setAll(list);
            t.commit();
        } catch (Exception e) {
            lbVisszajelzes.setText(e.getMessage());
        }
    }

    private void handleDeleteUpdateCombobox() {
        try {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            List<Integer> list = session.createQuery(modelController.GetIdQuery(), Integer.class).list();
            cbUpdate.setItems(FXCollections.observableList(list));
            t.commit();
        } catch (Exception e) {
            lbVisszajelzes.setText(e.getMessage());
        }
    }

    @FXML protected void menuUpdateClick() {
        SetVisiblity(eCRUDstate.update);
        lbVisszajelzes.setText("Valaszon egy elemet.");
        handleDeleteUpdateCombobox();
        lbVisszajelzes.setText("Modositsa a kivalasztott elemet a kuldes gombbal.");
    }

    @FXML protected void menuDeleteClick() {
        SetVisiblity(eCRUDstate.delete);
        lbVisszajelzes.setText("Valaszon egy elemet.");
        handleDeleteUpdateCombobox();
        lbVisszajelzes.setText("Torolje a kivalasztott elemet a kuldes gombbal.");
    }

    private void HandleDelete(Integer selectedId) {
        try {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();

            int convertedId = (int) selectedId;
            Query q = session.createQuery("delete FormModel where id = :convertedId")
                    .setParameter("convertedId", convertedId);
            q.executeUpdate();

            t.commit();
            lbVisszajelzes.setText("Torolve az adatbázisbol.");
            tfName.setText("");
            tfMessage.setText("");
        } catch (Exception e) {
            lbVisszajelzes.setText("Hiba lepett fel.");
        }
    }

    public void btKuldes(ActionEvent actionEvent) {
        Integer selectedId = (Integer) cbUpdate.getValue();

        if ( currentState == eCRUDstate.delete) {
            HandleDelete(selectedId);
            return;
        }

        try {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();

            String timeStamp = dateFormat.format(Calendar.getInstance().getTime());
            FormModel form = new FormModel(tfName.getText(), tfMessage.getText(), timeStamp);

            if (currentState == eCRUDstate.update) {
                int id = (int) selectedId;
                form.setId(id);
                session.update(form);
            } else {
                session.save(form);
            }

            t.commit();
            lbVisszajelzes.setText("Adatok beírva az adatbázisba");
        } catch (Exception e) {
            lbVisszajelzes.setText("Hiba lepett fel.");
        }
    }

    public void menuFilterReadClick(ActionEvent actionEvent) {
    }

    public void handleCbSelection(ActionEvent actionEvent) {
        Integer selectedId = (Integer) cbUpdate.getValue();

        if (selectedId == null) {
            return;
        }

        try {
            Session session = factory.openSession();
            FormModel form = session.get(FormModel.class, selectedId);

            tfName.setText(form.getName());
            tfMessage.setText(form.getMessage());
        } catch (Exception e) {
            lbVisszajelzes.setText("Hiba lepett fel.");
        }
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
    }

}
