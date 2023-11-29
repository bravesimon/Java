package com.example.formula1app.controllers;

import com.example.formula1app.models.FormModel;
import javafx.application.Platform;
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
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MainController {
    enum eCRUDstate {
        read, read2, write, update, delete, initOrNotUsed
    }

    private SessionFactory factory;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    private eCRUDstate currentState;
    private List<Thread> threads;

    @FXML private Label lbVisszajelzes, lbName, lbUzenet;
    @FXML private GridPane gp;
    @FXML private TextField tfName, tfMessage;
    @FXML private TableView tV;
    @FXML private ComboBox cbUpdate;
    @FXML private Button btKuldes;

    @FXML private GridPane gpRead2;
    @FXML private TextField tfRead2;
    @FXML private CheckBox chbRead2a;
    @FXML private RadioButton radio1Read2;
    @FXML private RadioButton radio2Read2;
    @FXML private RadioButton radio3Read2;
    @FXML private RadioButton radio4Read2;
    @FXML private List<RadioButton> radioButtons;
    @FXML private ComboBox cbRead2;

    @FXML private GridPane gpOthers;
    @FXML private Label label1;
    @FXML private Label label2;
    @FXML private Button btnStart;
    @FXML private Button btnStop;

    @FXML private ComboBox cmbAlgorithms;

    private IEntityController modelController;

    private void SetOthersMenu(Boolean isVisible) {
        gpOthers.setVisible(isVisible);
        label1.setVisible(isVisible);
        label2.setVisible(isVisible);
        btnStart.setVisible(isVisible);
        btnStop.setVisible(isVisible);
    }

    private void SetVisiblity(eCRUDstate state) {
        currentState = state;

        SetOthersMenu(false);

        gp.setVisible(state != eCRUDstate.initOrNotUsed);
        tV.setVisible(state == eCRUDstate.read || state == eCRUDstate.read2);

        boolean btBool = (state == eCRUDstate.delete || state == eCRUDstate.update || state == eCRUDstate.write);
        btKuldes.setVisible(btBool);
        tfName.setVisible(btBool);
        tfMessage.setVisible(btBool);
        lbName.setVisible(btBool);
        lbUzenet.setVisible(btBool);

        boolean cbBool = (state == eCRUDstate.delete || state == eCRUDstate.update);
        cbUpdate.setVisible(cbBool);

        gpRead2.setVisible(state == eCRUDstate.read2);
        tfRead2.setVisible(state == eCRUDstate.read2);
        chbRead2a.setVisible(state == eCRUDstate.read2);

        for (RadioButton radioButton : Arrays.asList(radio1Read2, radio2Read2, radio3Read2, radio4Read2)) {
            radioButton.setVisible(state == eCRUDstate.read2);
        }

        cbRead2.setVisible(state == eCRUDstate.read2);

        cmbAlgorithms.setVisible(false);
    }

    public MainController() {

    }

    @FXML public void initialize(){
        modelController = new FormModelController();
        SetVisiblity(eCRUDstate.initOrNotUsed);

        ToggleGroup group = new ToggleGroup();
        String[] strings = modelController.GetColumnNames();
        int index = 0;

        radioButtons = Arrays.asList(radio1Read2, radio2Read2, radio3Read2, radio4Read2);

        for (RadioButton radioButton : radioButtons) {
            radioButton.setToggleGroup(group);
            radioButton.setText(strings[index++]);
        }

        cbRead2.getItems().addAll("Normál rendezés", "Fordított rendezés");

        try {
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            cfg.addAnnotatedClass(FormModel.class);
            factory = cfg.buildSessionFactory();
            lbVisszajelzes.setText("Adatbázis hasznalatra kész.");
        }catch (Exception e) {
            System.out.println("e: " + e.getMessage());
            lbVisszajelzes.setText("Adatbázis inicializálása sikertelen.");
        }
    }

    @FXML protected void menuCreateClick() {
        SetVisiblity(eCRUDstate.write);
        lbVisszajelzes.setText("Adja meg a nevét és üzenetét.");
    }

    private void UpdateTableView(String query, Boolean reverse) {
        tV.getColumns().removeAll(tV.getColumns());
        tV.getColumns().addAll(modelController.GetAllTables());

        try {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();
            List<FormModel> list = session.createQuery(query).list();
                    // .stream().toList();

            if (reverse) {
                Collections.reverse(list);
            }

            tV.getItems().setAll(list);
            t.commit();
            lbVisszajelzes.setText("Adatok kiolvasva.");
        } catch (Exception e) {
            lbVisszajelzes.setText("Hiba az adatok kiolvasasa közben.");
        }
    }

    @FXML protected void menuReadClick() {
        SetVisiblity(eCRUDstate.read);
        UpdateTableView(modelController.GetReadQuery(), false);
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
        tfName.setText("");
        tfMessage.setText("");
        lbVisszajelzes.setText("Válasszon egy elemet.");
        handleDeleteUpdateCombobox();
        lbVisszajelzes.setText("Módosítsa a kiválasztott elemet a küldés gombbal.");
    }

    @FXML protected void menuDeleteClick() {
        SetVisiblity(eCRUDstate.delete);
        lbVisszajelzes.setText("Válasszon egy elemet.");
        handleDeleteUpdateCombobox();
        lbVisszajelzes.setText("Törölje a kiválasztott elemet a küldés gombbal.");
    }

    private void HandleDelete(Integer selectedId) {
        try {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();

            int convertedId = (int) selectedId;
            Query q = session.createQuery(modelController.GetDeleteQuery())
                                .setParameter("convertedId", convertedId);
            q.executeUpdate();

            t.commit();
            lbVisszajelzes.setText("Törölve az adatbázisból.");
            tfName.setText("");
            tfMessage.setText("");
        } catch (Exception e) {
            lbVisszajelzes.setText("Hiba lépett fel.");
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
            tfName.setText("");
            tfMessage.setText("");
            lbVisszajelzes.setText("Adatok beírva az adatbázisba.");
        } catch (Exception e) {
            lbVisszajelzes.setText("Hiba lépett fel.");
        }
    }

    @FXML protected void menuFilterReadClick(ActionEvent actionEvent) {
        SetVisiblity(eCRUDstate.read2);
        UpdateTableView(modelController.GetReadQuery(), false);
        lbVisszajelzes.setText("Keressen az adatbázisban a következő filterekkel:");
    }

    @FXML protected void btRead2Kereses() {
        String searched = tfRead2.getText();

        if (searched.isEmpty() || searched.equals("Keresett szöveg")) {
            lbVisszajelzes.setText("Próbálja meg valid kereséssel.");
            return;
        }

        if (chbRead2a.isSelected()) {
            searched = searched.toLowerCase();
        }

        String column = "";
        for (RadioButton radioButton : radioButtons) {
            if ( radioButton.isSelected() ) {
                column = radioButton.getText();
            }
        }

        String propertName = modelController.GetPropertyName(column);
        Boolean reverseNeeded = (cbRead2.getValue() != null && !cbRead2.getValue().equals("Normál rendezés"));
        UpdateTableView(modelController.GetRead2Query(propertName, searched), reverseNeeded);
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
            lbVisszajelzes.setText("Hiba lépett fel.");
        }
    }

    public void menSoapDownload(ActionEvent actionEvent) {
    }

    public void menSoapDownload2(ActionEvent actionEvent) {
    }

    public void menSoapGrafikon(ActionEvent actionEvent) {
    }

    private void MakeAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void menuDecisionTree(ActionEvent actionEvent) {
    }
    public void menuAlgorithms() {

    }

    public void menuMoreAlgorithm() {
        cmbAlgorithms.setVisible(true);

    }

    public void menuOthersStream(ActionEvent actionEvent) {
        SetVisiblity(eCRUDstate.read2);
        lbVisszajelzes.setText("Keressen az adatázisban a következő filterekkel:");
        SetOthersMenu(false);
    }

    private Thread makeThread(Label lbl, String txt, int sleep) {
        Thread thread = new Thread(() -> {
            AtomicInteger count = new AtomicInteger(0);
            while (true) {
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                }

                Platform.runLater(() -> lbl.setText(txt + count.incrementAndGet()));
            }
        });

        return thread;
    }

    public void menuOthersParalell(ActionEvent actionEvent) {
        SetVisiblity(eCRUDstate.initOrNotUsed);
        lbVisszajelzes.setText("");
        SetOthersMenu(true);
    }

    public void startThread() {
        stopThread();

        threads = new ArrayList<>();
        threads.add(makeThread(label1,"thread1: ", 1000));
        threads.add(makeThread(label2,"thread2: ", 2000));

        for (Thread th : threads) {
            th.setDaemon(true);
            th.start();
        }
    }

    public void stopThread() {
        if (threads == null) {
            return;
        }

        for (Thread th : threads) {
            th.stop();

            try {
                th.join();
            } catch (InterruptedException e) {
            }
        }
    }


    public void handleSelectAlgorithm() {
        Integer selectedId = (Integer) cbUpdate.getValue();

        if (selectedId == null) {
            return;
        }
    }
}
