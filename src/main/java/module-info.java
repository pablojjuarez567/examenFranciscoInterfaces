module com.example.examenfranciscointerfaces {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.examenfranciscointerfaces to javafx.fxml;
    exports com.example.examenfranciscointerfaces;
}