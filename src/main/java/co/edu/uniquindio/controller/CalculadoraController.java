package co.edu.uniquindio.controller;

import co.edu.uniquindio.model.Operaciones;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;


public class CalculadoraController {

    @FXML
    private Button btnOperar;

    @FXML
    private ImageView img1;

    @FXML
    private RadioButton rdbDiv;

    @FXML
    private RadioButton rdbMult;

    @FXML
    private RadioButton rdbRest;

    @FXML
    private RadioButton rdbSuma;

    @FXML
    private TextField txtOp1;

    @FXML
    private TextField txtOp2;

    @FXML
    private TextField txtResultado;

    @FXML
    public void initialize() {

        ToggleGroup tg = new ToggleGroup();
        this.rdbSuma.setToggleGroup(tg);
        this.rdbRest.setToggleGroup(tg);
        this.rdbMult.setToggleGroup(tg);
        this.rdbDiv.setToggleGroup(tg);
    }

    @FXML
    void hacerOperacion(ActionEvent event) {

        try{


        int op1 = Integer.parseInt(this.txtOp1.getText());
        int op2 = Integer.parseInt(this.txtOp2.getText());

        Operaciones op = new Operaciones(op1, op2);

        if(this.rdbSuma.isSelected()){
            this.txtResultado.setText(op.sumar() + "");
        }else if(this.rdbRest.isSelected()){
            this.txtResultado.setText(op.restar() + "");
        }else if(this.rdbMult.isSelected()){
            this.txtResultado.setText(op.multiplicar() + "");
        }else if(this.rdbDiv.isSelected()){
            if(op2 == 0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El operando 2 no puede ser cero");
                alert.showAndWait();

            }else{
                this.txtResultado.setText(op.dividir() + "");
            }

        }

        }catch (NumberFormatException e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato Incorrecto");
            alert.showAndWait();
        }
    }

}