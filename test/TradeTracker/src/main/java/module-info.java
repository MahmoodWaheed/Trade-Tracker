module Pure.Hibernate {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.persistence;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires mysql.connector.j;

    exports org.example.controller;
    opens org.example.controller to javafx.fxml;
    opens org.example.model to org.hibernate.orm.core, javafx.base;

    opens org.example;
}