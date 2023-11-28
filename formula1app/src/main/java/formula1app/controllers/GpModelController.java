package formula1app.controllers;

import formula1app.models.GpModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class GpModelController implements IEntityController{
    @FXML private TableColumn<GpModel, String> dateCol;
    @FXML private TableColumn<GpModel, String> nameCol;
    @FXML private TableColumn<GpModel, String> placeCol;

    GpModelController() {
        dateCol = new TableColumn<>("Datum");
        nameCol = new TableColumn<>("Név");
        placeCol = new TableColumn<>("Helyszin");

        dateCol.setCellValueFactory(new PropertyValueFactory<>("datum"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nev"));
        placeCol.setCellValueFactory(new PropertyValueFactory<>("helyszin"));
    }

    public String[] GetColumnNames() {
        return new String[] {"Datum", "Név", "Helyszin"};
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
        return new TableColumn[]{dateCol, nameCol, placeCol};
    }

    public String GetIdQuery() {
        return "SELECT id FROM formula1app.models.GpModel";
    }
    public String GetReadQuery() {
        return "FROM formula1app.models.GpModel";
    }

    public String GetDeleteQuery() {
        return "delete formula1app.models.GpModel where id = :convertedId";
    }


    public String GetRead2Query(String column, String searched) {
        return "SELECT " + column + " FROM formula1app.models.GpModel where " + column + " = :searched";
    }
}
