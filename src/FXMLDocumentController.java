/* 
 * File:   main.java
 * Author: a.skiadopoulos
 *
 * Created on 08 Μαρτίου 2018, 16:54 μμ
 *
 *
 * JavaFX app: getPercentage
 * JavaFX scene graph: Scene Builder
 *
 * This is a simple program that calculates the net percentage of a
 * given number plus the total number (net percentage + initial number).
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


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnCalc;
    @FXML
    private Button btnClear;
    @FXML
    private TextField txtInit;
    @FXML
    private TextField txtPct;
    @FXML
    private TextField txtResult;
    @FXML
    private TextField txtNetPct;
    @FXML
    private Label lblInit;
    @FXML
    private Label lblPct;
    @FXML
    private Label lblNetPct;
    @FXML
    private Label lblResult;
    @FXML
    private AnchorPane apMain;
    
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
