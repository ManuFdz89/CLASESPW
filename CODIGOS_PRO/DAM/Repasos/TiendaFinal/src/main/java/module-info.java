module org.example.tiendafinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.tiendafinal to javafx.fxml;
    exports org.example.tiendafinal;
    exports org.example.tiendafinal.controller;
    opens org.example.tiendafinal.controller to javafx.fxml;

    exports org.example.tiendafinal.database;
    opens org.example.tiendafinal.database to java.sql;

    exports org.example.tiendafinal.dao;
    opens org.example.tiendafinal.dao to java.sql;
}