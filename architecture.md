# System Architecture of getPercentage

## Overview
The getPercentage application is structured around JavaFX with a Model-View-Controller (MVC) design pattern. It consists of three main components:

- **Model:** Represents the backend calculations (in this case, handled directly within the controller).
- **View:** The user interface is defined in an FXML file (`FXMLDocument.fxml`), which separates the UI design from the business logic.
- **Controller:** The `FXMLDocumentController.java` file manages user input and updates the view accordingly.

## Components
- **main.java**
  - Initializes the application and creates the primary stage.
  - Contains event handling for window events (like closing the application).

- **FXMLDocumentController.java**
  - Handles user interactions.
  - Contains methods to perform calculations and update the UI.
  - Listens for changes in text fields to enable/disable buttons dynamically.

- **FXMLDocument.fxml**
  - Defines the layout and components of the application using JavaFX's FXML syntax.

## Interaction
The flow of the application is initiated from the main class, which loads the FXML UI. User actions (like button clicks and typing) are handled in the controller, where calculations are performed and results are displayed back in the FXML.

