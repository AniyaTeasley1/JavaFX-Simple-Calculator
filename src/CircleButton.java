import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;


public class CircleButton extends StackPane {
    private Circle circle;
    private Label lblValue;

    public CircleButton(String label) {
        // Create a circle and label
        circle = new Circle(45); // Circle radius of 45
        circle.setStroke(Color.BLACK); // Set the circle outline color
        circle.setFill(Color.WHITE); // Set the circle fill color

        lblValue = new Label(label); // Create a label with the provided text

        // Add the circle and label to the StackPane
        this.getChildren().addAll(circle, lblValue);

        this.setOnMousePressed(this::handleMousePressed);
        this.setOnMouseReleased(this::handleMouseReleased);
    }

    // Method to get the label value
    public String getLabel() {
        return lblValue.getText();
    }
    // Change color when pressed
    private void handleMousePressed(MouseEvent event) {
        circle.setFill(Color.LIGHTGRAY); // when pressed its light gray
    }

    // Reset color when released
    private void handleMouseReleased(MouseEvent event) {
        circle.setFill(Color.WHITE); // Changes to white when released
    }







}
