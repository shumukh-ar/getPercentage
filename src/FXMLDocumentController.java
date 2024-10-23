/* 
 * File: FXMLDocumentController.java
 * Author: a.skiadopoulos
 *
 * Created on 08 Μαρτίου 2018, 16:54 μμ
 *
 * Description:
 * This file contains the implementation of the FXMLDocumentController class
 * for a JavaFX application that calculates the net percentage of a 
 * given initial number plus the total number (net percentage + initial number).
 * The application includes a graphical user interface built with 
 * JavaFX Scene Builder, allowing users to input numbers and 
 * calculate the desired results seamlessly.
 */

/* library import */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
/**
 * FXMLDocumentController represents the controller for the FXMLDocument.
 * It implements the Initializable interface, allowing it to initialize 
 * UI components after they have been loaded.
 */

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnCalc;   // Button for calculating the result
    @FXML
    private Button btnClear;    // Button for clearing the input fields
    @FXML
    private TextField txtInit;    // Input field for the initial number
    @FXML
    private TextField txtPct;     // Input field for the percentage
    @FXML
    private TextField txtResult;   // Output field for the result 
    @FXML
    private TextField txtNetPct;    // Output field for the net percentage
    @FXML
    private Label lblInit;     // Output field for the net percentage
    @FXML
    private Label lblPct;     // Label for percentage input
    @FXML
    private Label lblNetPct;    // Label for net percentage output
    @FXML
    private Label lblResult;      // Label for result output
    @FXML
    private AnchorPane apMain;     // Main layout of the application
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnCalc.setDisable(true);
        btnClear.setDisable(true);
        txtPct.setDisable(true);
        txtNetPct.setEditable(false);
        txtNetPct.setDisable(true);
        txtResult.setEditable(false);
        txtResult.setDisable(true);
        // TODO
    }

    @FXML
    private void handleAction_btnCalc(ActionEvent event) {
        
        /* local variable(s) definition */
        float init, pct, netPct, result;
        
        /* The Float.parseFloat(String s) method is used primarily in
         * parsing a String method argument into a Float object
         */
        init = Float.parseFloat(txtInit.getText());
        pct = Float.parseFloat(txtPct.getText());
        
        netPct = (init * pct) / 100;
        result = init + netPct;
        
        /* The Float.toString(Float f) method takes float value
         * and converts it into the string representation of it.
         */
        txtNetPct.setDisable(false);
        txtNetPct.setText(Float.toString(netPct));
        txtResult.setDisable(false);
        txtResult.setText(Float.toString(result));
        btnCalc.setDisable(true);
    }
      /**
     * Handles the action of the Clear button. This method is 
     * triggered when the Clear button is clicked. It clears all 
     * input fields and resets the states of the output fields 
     * and buttons.
     *
     * @param event The ActionEvent triggered by clicking the Clear button.
     */
    
    @FXML
    private void handleAction_btnClear(ActionEvent event) {

        txtInit.clear();
        txtPct.clear();
        txtPct.setDisable(true);
        txtNetPct.clear();
        txtNetPct.setDisable(true);
        txtResult.clear();
        txtResult.setDisable(true);
        btnClear.setDisable(true);
    }
    
    @FXML
    private void handle_txtInit(KeyEvent event) {
        
        txtNetPct.clear();
        txtNetPct.setDisable(true);
        txtResult.clear();
        txtResult.setDisable(true);
        
        /* addListener() method: lets you add event handlers that are called
         * whenever the value of a property changes.
         *
         * The change listener event handler is passed three arguments:
         * - observable (the property whose value has changed).
         * - oldValue (the previous value of the property).
         * - newValue: (the new value).
         *
         * The change listener is called whenever the value of the property
         * has been recalculated.
         */ 
        txtInit.textProperty().addListener((observable, oldValue, newValue) -> { 
        
         if(newValue.isEmpty())
         {
             if(txtPct.getText().isEmpty()) //checks if a text field is empty or not
             {
                 txtPct.setDisable(true);
                 btnClear.setDisable(true);
             }            
             txtNetPct.clear();
             txtResult.clear();
             btnCalc.setDisable(true);
         }
         else if(newValue.length() != oldValue.length() && !txtPct.getText().isEmpty())
         {
             btnCalc.setDisable(false);
         }
         else
         {
             btnClear.setDisable(false);
             txtPct.setDisable(false);
         }
        });
    }

    @FXML
    private void handle_txtPct(KeyEvent event) {
        
        txtNetPct.clear();
        txtNetPct.setDisable(true);
        txtResult.clear();
        txtResult.setDisable(true);
        
        txtPct.textProperty().addListener((observable, oldValue, newValue) -> { 
         
         if(newValue.isEmpty())
         {
             if(txtInit.getText().isEmpty())
             {
                 txtPct.setDisable(true);
                 btnClear.setDisable(true);
             }
             txtNetPct.clear();
             txtResult.clear();
             btnCalc.setDisable(true);
         }
         else if(newValue.length() != oldValue.length() && txtInit.getText().isEmpty())
         {
             btnCalc.setDisable(true);
         }
         else
         {
             btnCalc.setDisable(false);
             btnClear.setDisable(false);
         }
        });    
    }

    @FXML
    private void handle_txtResult(KeyEvent event) {
    }

    @FXML
    private void handle_txtNetPct(KeyEvent event) {
    }

}
