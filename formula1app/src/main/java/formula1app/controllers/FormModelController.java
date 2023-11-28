package formula1app.controllers;

import formula1app.models.FormModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class FormModelController implements IEntityController {
    @FXML public TableColumn<FormModel, String> IDCol;
    @FXML public TableColumn<FormModel, String> NameCol;
    @FXML public TableColumn<FormModel, String> MessageCol;
    @FXML public TableColumn<FormModel, String> SentCol;

    FormModelController() {
        IDCol = new TableColumn<>("Id");
        NameCol = new TableColumn<>("Név");
        MessageCol = new TableColumn<>("Uzenet");
        SentCol = new TableColumn<>("Kuldes ideje");

        IDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        MessageCol.setCellValueFactory(new PropertyValueFactory<>("message"));
        SentCol.setCellValueFactory(new PropertyValueFactory<>("sent"));
    }

    public String[] GetColumnNames() {
        return new String[] {"Id", "Név", "Uzenet", "Kuldes ideje"};
    }

    public String GetPropertyName(String columnName) {
        if (columnName.equals("Id")) {
            return "id";
        } else if (columnName.equals("Név")) {
            return "name";
        } else if (columnName.equals("Uzenet")) {
            return "message";
        } else if (columnName.equals("Kuldes ideje")) {
            return "sent";
        }

        return "";
    }

    public TableColumn[] GetAllTables() {
        return new TableColumn[]{IDCol, NameCol, MessageCol, SentCol};
    }


    public String GetReadQuery () {
        return "FROM formula1app.models.FormModel";
    }

    public String GetIdQuery() {
        return "SELECT id FROM formula1app.models.FormModel";
    }

    public String GetDeleteQuery() {
        return "delete formula1app.models.FormModel where id = :convertedId";
    }

    public String GetRead2Query(String column, String searched) {
        return "FROM formula1app.models.FormModel where " + column + " = " + searched;
    }

    public TableColumn<FormModel, String> getIDCol() {
        return IDCol;
    }

    public void setIDCol(TableColumn<FormModel, String> IDCol) {
        this.IDCol = IDCol;
    }

    public TableColumn<FormModel, String> getNameCol() {
        return NameCol;
    }

    public void setNameCol(TableColumn<FormModel, String> nameCol) {
        NameCol = nameCol;
    }

    public TableColumn<FormModel, String> getMessageCol() {
        return MessageCol;
    }

    public void setMessageCol(TableColumn<FormModel, String> messageCol) {
        MessageCol = messageCol;
    }

    public TableColumn<FormModel, String> getSentCol() {
        return SentCol;
    }

    public void setSentCol(TableColumn<FormModel, String> sentCol) {
        SentCol = sentCol;
    }
}
