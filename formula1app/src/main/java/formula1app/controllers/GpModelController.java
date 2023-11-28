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

    public TableColumn[] GetAll() {
        return new TableColumn[]{dateCol, nameCol, placeCol};
    }

    public String GetIdQuery() {
        return "SELECT id FROM formula1app.models.GpModel";
    }
    public String GetReadQuery() {
        return "FROM formula1app.models.GpModel";
    }
}
