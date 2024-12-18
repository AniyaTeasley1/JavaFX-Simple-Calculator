/** Aniya Teasley, 10/31/24, Comp section 3
 * creating a calculator
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SimpleCalc extends Application {
 
    public void start(Stage primaryStage) {
        // instance of CalcPane
        CalcPane calcPane = new CalcPane();

        // Create a Scene and set the CalcPane as the root node
        Scene scene = new Scene(calcPane, 300, 400); // Adjust size as needed

        // Set the title and scene for the primary stage
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

