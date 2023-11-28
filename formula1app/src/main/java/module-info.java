module com.example.formula1app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.naming;
    requires java.sql;
    requires org.hibernate.orm.core;

    opens formula1app.models;
    exports formula1app.models;

    exports formula1app.controllers;
    opens formula1app.controllers to javafx.fxml;

    exports formula1app;
    opens formula1app to javafx.fxml;
}
