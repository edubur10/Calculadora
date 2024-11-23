module co.edu.uniquindio.calculadora {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.controller to javafx.fxml;
    exports co.edu.uniquindio.controller;
}