module com.example.fit {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.fit to javafx.fxml;
    exports com.example.fit;
}