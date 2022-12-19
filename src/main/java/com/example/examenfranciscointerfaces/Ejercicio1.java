package com.example.examenfranciscointerfaces;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
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

                        Persona persona = new Persona(nombre, edad, sexo, peso, altura, actividad);

                        tabla.getItems().add(persona);
                        textoEditable.setText("Persona añadida");

                        nombreField.clear();
                        sexoField.setValue(null);
                        actividadField.setValue(null);
                        edadField.getValueFactory().setValue(0);
                        pesoField.getValueFactory().setValue(0.0);
                        alturaField.getValueFactory().setValue(0);
                }
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                sexoField.getItems().addAll("Hombre", "Mujer");
                actividadField.getItems().addAll("Muy ligera", "Ligera", "Moderada", "Intensa");
                edadField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
                pesoField.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 200, 0));
                alturaField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 250, 0));


                ArrayList<Persona> personas = new ArrayList<>();
                personas.add(new Persona("Francisco", 39, "Hombre", 70, 180, "Moderada"));
                personas.add(new Persona("Paca", 25, "Mujer", 50, 150, "Moderada"));
                personas.add(new Persona("Pepe", 20, "Hombre", 100, 180, "Ligera"));
                personas.add(new Persona("Juan", 30, "Hombre", 90, 200, "Muy ligera"));

                ObservableList<Persona> listaPersonas = FXCollections.observableArrayList(personas);

                columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
                columnaEdad.setCellValueFactory(new PropertyValueFactory("edad"));
                columnaSexo.setCellValueFactory(new PropertyValueFactory("sexo"));
                columnaPeso.setCellValueFactory(new PropertyValueFactory("peso"));
                columnaAltura.setCellValueFactory(new PropertyValueFactory("altura"));
                columnaActividad.setCellValueFactory(new PropertyValueFactory("actividad"));
                columnaGER.setCellValueFactory(new PropertyValueFactory("ger"));
                columnaGET.setCellValueFactory(new PropertyValueFactory("get"));

                tabla.setItems(listaPersonas);
        }


}


