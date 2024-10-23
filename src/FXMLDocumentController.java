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
    /**
     * Initializes the controller class. This method is called after 
     * the FXML components have been loaded. It sets up the initial 
     * state of the GUI elements.
     *   
     * @param url The location used to resolve relative paths for 
     *            the root object, or null if the location is not 
     *            known.
     * @param rb  The resources used to localize the root object, 
     *            or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnCalc.setDisable(true);    // Disable the Calculate button initially
        btnClear.setDisable(true);    // Disable the Clear button initially
        txtPct.setDisable(true);       // Disable the Percentage input field initially
        txtNetPct.setEditable(false);    // Make the Net Percentage output field read-only
        txtNetPct.setDisable(true);       // Disable the Net Percentage output field initially
        txtResult.setEditable(false);      // Make the Result output field read-only
        txtResult.setDisable(true);       // Disable the Result output field initially
        // TODO
    }
/**
     * Handles the action of the Calculate button. This method is 
     * triggered when the Calculate button is clicked. It reads the 
     * initial number and percentage from the input fields, computes the 
     * net percentage, and displays both the net percentage and 
     * the total result in their respective output fields.
     *
     * @param event The ActionEvent triggered by clicking the Calculate button.
     */
    @FXML
    private void handleAction_btnCalc(ActionEvent event) {
        
        // Local variable(s) definition
        float init, pct, netPct, result;
        
        // Parse input text to float
        init = Float.parseFloat(txtInit.getText());
        pct = Float.parseFloat(txtPct.getText());

        // Calculate net percentage and total result
        netPct = (init * pct) / 100;
        result = init + netPct;
        
        // Update output fields and UI states
        txtNetPct.setDisable(false);
        txtNetPct.setText(Float.toString(netPct));
        txtResult.setDisable(false);
        txtResult.setText(Float.toString(result));
        btnCalc.setDisable(true); // Disable Calculate button after computation
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
 // Clear input and output fields
        txtInit.clear();
        txtPct.clear();
        txtPct.setDisable(true);
        txtNetPct.clear();
        txtNetPct.setDisable(true);
        txtResult.clear();
        txtResult.setDisable(true);
        btnClear.setDisable(true); // Disable Clear button after clearing
    }
     /**
     * Handles key events for the initial number input field. 
     * This method updates the state of the UI based on the input 
     * in the initial number field. It enables or disables buttons 
     * and fields based on user input.
     *
     * @param event The KeyEvent triggered on the initial number input.
     */
    @FXML
    private void handle_txtInit(KeyEvent event) {
        // Clear and disable output fields when input changes
        txtNetPct.clear();
        txtNetPct.setDisable(true);
        txtResult.clear();
        txtResult.setDisable(true);
        
         // Add a listener to input changes
        txtInit.textProperty().addListener((observable, oldValue, newValue) -> { 
        
         if(newValue.isEmpty())
         {  // Disable percentage field and Clear button if initial field is empty
             if(txtPct.getText().isEmpty()) 
             {
                 txtPct.setDisable(true);
                 btnClear.setDisable(true);
             }            
             txtNetPct.clear();
             txtResult.clear();
             btnCalc.setDisable(true);
         }  
         else if(newValue.length() != oldValue.length() && !txtPct.getText().isEmpty())
         { // Enable Calculate button if both fields have input
             btnCalc.setDisable(false);
         }
         else
         { // Enable percentage field and Clear button
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
