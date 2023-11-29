module com.example.formula1app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.naming;
    requires java.sql;
    requires org.hibernate.orm.core;

    opens com.example.formula1app.models;
    exports com.example.formula1app.models;

    exports com.example.formula1app.controllers;
    opens com.example.formula1app.controllers to javafx.fxml;

    exports com.example.formula1app;
    opens com.example.formula1app to javafx.fxml;
}
