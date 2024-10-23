/* 
 * File:   main.java
 * Author: a.skiadopoulos
 *
 * Created on 08 Μαρτίου 2018, 16:54 μμ
 *
 * JavaFX app: getPercentage
 * JavaFX scene graph: Scene Builder
 *
 * This is the Layout container and can be used to allow for flexible and dynamic
 * arrangements of the UI controls within a scene graph of a JavaFX application.
 */

/* library import */
import java.util.Optional;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/* main class */
public class main extends Application implements EventHandler<WindowEvent> {
    
    /* method start():
     *
     * A Stage in JavaFX is a top-level container that hosts a Scene, which consists
     * of visual elements.
     * The Stage class in the javafx.stage package represents a stage in a JavaFX application.
     * The primary stage is created by the platform and passed to the start
     * (Stage stage) method of the Application class.
     *
     * You can create additional stages as needed. */
    @Override
    public void start(Stage stage) throws Exception {
        
        /* Parent: A simple Node that can hold other Nodes as children. 
         * Every Scene needs exactly one Parent as the root.
         * FXMLLoader.load(): Loads an object hierarchy from an XML document
         * getClass(): Returns the runtime class of this Object
         * getResource(): Returns the resources used to resolve resource
         * key attribute values */
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        /* StageStyle enum constant UTILITY:
         *
         * Defines a Stage style with a solid white background and minimal platform
         * decorations used for a utility window */
        
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false); //sets the form state as fixed
        stage.setTitle("Percentage Calculator"); //sets the title of the form
        
        stage.setOnCloseRequest(this);
        stage.show(); //shows the main form
    }
 
    /* Handling the key typed event(s):
     *
     * You can create and register your event handler in a single step by defining 
     * the handler as an anonymous class in the call to the convenience method.
     * The event handler must implement the handle() method to provide the code
     * needed to process the event. */
    
  @Override
  public void handle(WindowEvent e) {
      
      /* The Alert (class) Dialogs:
       *
       * When creating an alert instance, users must pass in an Alert.AlertType
       * enumeration value.
       * It is by passing in this value that the Alert instance will configure
       * itself appropriately (by setting default values for many of the Dialog
       * properties, including title, header and graphic, as well as the default
       * buttons that are expected in a dialog of the given type).
       *
       * The CONFIRMATION alert type configures the Alert dialog to appear in a
       * way that suggests the content of the dialog is seeking confirmation
       * from the user. */
      
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Percentage Calculator"); //sets the dialog title
      alert.setHeaderText("Confirmation Message"); //sets the dialog header
      alert.setContentText("Are you sure you want to quit ?"); //sets the dialog content
      
      /* The ButtonType class:
       *
       * It is used as part of the JavaFX Dialog API (more specifically,
       * the DialogPane API) to specify which buttons should be shown to users in the dialogs.
       *
       * showAndWait() method:
       * Shows the dialog and waits for the user response (in other words, 
       * brings up a blocking dialog, with the returned value the users input). */
      
      Optional<ButtonType> confirm = alert.showAndWait();
      
      if(confirm.get() == ButtonType.OK)
      {
          System.exit(0);
      }
      else
      {
          /* consume() method:
           *
           * An event can be consumed by an event filter or an event handler at
           * any point in the event dispatch chain by calling the consume() method.
           * This method signals that processing of the event is complete and
           * traversal of the event dispatch chain ends. */
          
          alert.close();
          e.consume();
      }
  }    
}
