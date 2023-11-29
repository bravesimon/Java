package com.example.formula1app.controllers;

import javafx.scene.control.TableColumn;

public interface IEntityController {
    public String[] GetColumnNames();

    public String GetPropertyName(String columnName);

    public TableColumn[] GetAllTables();

    public String GetIdQuery();

    public String GetReadQuery();

    public String GetDeleteQuery();

    public String GetRead2Query(String column, String searched);
}
