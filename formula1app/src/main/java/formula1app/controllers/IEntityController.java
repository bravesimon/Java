package formula1app.controllers;

import javafx.scene.control.TableColumn;

public interface IEntityController {
    public TableColumn[] GetAll();

    public String GetIdQuery();

    public String GetReadQuery();
}
