package com.example.tableviewprueba;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public static class Person {
        private final String nombre;
        private final String apellidos;
        private final String email;

        public Person(String nombre, String apellidos, String email) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.email = email;
        }

        public String getNombre() { return nombre; }
        public String getApellidos() { return apellidos; }
        public String getEmail() { return email; }
    }

    @Override
    public void start(Stage stage) {

        TableView<Person> table = new TableView<>();
        table.setEditable(true);

        // Columnas enlazadas correctamente con los getters
        TableColumn<Person, String> firstNameCol = new TableColumn<>("Nombre");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Person, String> lastNameCol = new TableColumn<>("Apellidos");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("apellidos"));

        TableColumn<Person, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Datos de ejemplo
        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("Paco", "Fernandez", "PaquitoFdez@gmail.com"),
                new Person("Isabel", "Musk", "isabeMus@gmail.com"),
                new Person("Concepcion", "Williams", "ConcepcionWill@gmail.com"),
                new Person("Soledad", "Garcia", "Soledad211@gmail.com"),
                new Person("Terreno", "Brown", "TerrenoBr@gmail.com")
        );

        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

        // Layout
        VBox vbox = new VBox(table);
        Scene scene = new Scene(vbox, 450, 300);

        stage.setTitle("Lista Alumnos DAM");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

