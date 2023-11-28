package formula1app.controllers;

import formula1app.models.FormModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class FormModelController implements IEntityController {
    @FXML private TableColumn<FormModel, String> IDCol;
    @FXML private TableColumn<FormModel, String> nameCol;
    @FXML private TableColumn<FormModel, String> messageCol;
    @FXML private TableColumn<FormModel, String> sentCol;

    FormModelController() {
        IDCol = new TableColumn<>("Id");
        nameCol = new TableColumn<>("Név");
        messageCol = new TableColumn<>("Uzenet");
        sentCol = new TableColumn<>("Kuldes ideje");

        IDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        messageCol.setCellValueFactory(new PropertyValueFactory<>("message"));
        sentCol.setCellValueFactory(new PropertyValueFactory<>("sent"));
    }

    public TableColumn[] GetAll() {
        return new TableColumn[]{IDCol, nameCol, messageCol, sentCol};
    }


    public String GetReadQuery () {
        return "FROM formula1app.models.FormModel";
    }

    public String GetIdQuery() {
        return "SELECT id FROM formula1app.models.FormModel";
    }
}
