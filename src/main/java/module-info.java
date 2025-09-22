module com.example.tableviewprueba {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tableviewprueba to javafx.fxml;
    exports com.example.tableviewprueba;
}