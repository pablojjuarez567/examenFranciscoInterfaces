package com.example.examenfranciscointerfaces;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Ejercicio1 implements Initializable {

        @FXML
        private ComboBox<String> actividadField;

        @FXML
        private Spinner<Integer> alturaField;

        @FXML
        private Button boton;

        @FXML
        private TableColumn<Persona, String> columnaActividad;

        @FXML
        private TableColumn<Persona, Integer> columnaAltura;

        @FXML
        private TableColumn<Persona, Integer> columnaEdad;

        @FXML
        private TableColumn<Persona, Integer> columnaGER;

        @FXML
        private TableColumn<Persona, Integer> columnaGET;

        @FXML
        private TableColumn<Persona, String> columnaNombre;

        @FXML
        private TableColumn<Persona, Double> columnaPeso;

        @FXML
        private TableColumn<Persona, String> columnaSexo;

        @FXML
        private Spinner<Integer> edadField;

        @FXML
        private TextField nombreField;

        @FXML
        private Spinner<Double> pesoField;

        @FXML
        private ComboBox<String> sexoField;

        @FXML
        private TableView<Persona> tabla;


        @FXML
        private Text textoEditable;

        @FXML
        void añadirTabla(ActionEvent event) {

                if(nombreField.getText().isEmpty() || sexoField.getValue() == null || actividadField.getValue() == null){
                        textoEditable.setText("Rellene todos los campos");
                } else {
                        String nombre = nombreField.getText();
                        Integer edad = edadField.getValue().intValue();
                        double peso = pesoField.getValue();
                        Integer altura = alturaField.getValue();
                        String sexo = sexoField.getValue();
                        String actividad = actividadField.getValue();

                        int ger = 0;
                        int get = 0;

                        if(sexo.equals("Hombre")) {
                                ger = (int) (66.4730 + (13.7516 * peso) + (5.0033 * altura) - (6.755 * edad));

                                switch (actividad){
                                        case "Muy ligera":
                                                get = (int) (ger * 1.3);
                                                break;
                                        case "Ligera":
                                                get = (int) (ger * 1.6);
                                                break;
                                        case "Moderada":
                                                get = (int) (ger * 1.7);
                                                break;
                                        case "Intensa":
                                                get = (int) (ger * 2.1);
                                                break;
                                }
                        } else if(sexo.equals("Mujer")) {
                                ger = (int) (655.0955 + (9.5634 * peso) + (1.8496 * altura) - (4.6756 * edad));

                                switch (actividad){
                                        case "Muy ligera":
                                                get = (int) (ger * 1.3);
                                                break;
                                        case "Ligera":
                                                get = (int) (ger * 1.5);
                                                break;
                                        case "Moderada":
                                                get = (int) (ger * 1.6);
                                                break;
                                        case "Intensa":
                                                get = (int) (ger * 1.9);
                                                break;
                                }
                        }


                        Persona persona = new Persona(nombre, edad, sexo, peso, altura, actividad, ger, get);

                        ObservableList<Persona> personas = FXCollections.observableArrayList();
                        tabla.setItems(data);
                        tabla.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                        tabla.getColumns().addAll(fileNameCol, pathCol, sizeCol, dateCol);

                        tabla.setEditable(true);
                        tabla.getItems().add(persona);







                        nombreField.clear();
                        sexoField.setValue(null);
                        actividadField.setValue(null);

                }

        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                sexoField.getItems().addAll("Hombre", "Mujer");
                actividadField.getItems().addAll("Muy ligera", "Ligera", "Moderada", "Intensa");
                edadField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
                pesoField.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 200, 0));
                alturaField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 250, 0));

                TableView<Persona> table = new TableView<Persona>();
                final ObservableList<Persona> data = FXCollections.observableArrayList(
                        new Persona("Pablo", 5, "Hombre", 5, 5, "Muy ligera", 5, 5)
                );

        }


}


