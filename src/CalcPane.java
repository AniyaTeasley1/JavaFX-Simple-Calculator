import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class CalcPane extends BorderPane {
    private TextField textDisplay;

    public CalcPane() {
        // Create GridPane for CircleButtons
        GridPane gridPane = new GridPane();

        // Create CircleButtonHandler instance
        CircleButtonHandler handler = new CircleButtonHandler();

        // Create CircleButtons and add to GridPane
        for (int i = 1; i <= 9; i++) {
            CircleButton circleButton = new CircleButton(Integer.toString(i));
            circleButton.setPrefSize(100, 100);
            circleButton.setOnMousePressed(handler); // Add event handler
            // Add event handler
            gridPane.add(circleButton, (i - 1) % 3, (i - 1) / 3); // Add CircleButton to grid
        }

        // Add the GridPane to the center of the BorderPane
        this.setCenter(gridPane);

        // Create TextField and add to the top of the BorderPane
        textDisplay = new TextField();
        this.setTop(textDisplay);

        // Create HBox for function buttons
        HBox functionPane = new HBox();
        functionPane.setSpacing(10);
        functionPane.setAlignment(Pos.CENTER);

        // Create function buttons
        Button btnSquareRoot = new Button("√");
        Button btnSquare = new Button("x²");
        Button btnClear = new Button("C");

        // Set minimum width for function buttons
        btnSquareRoot.setMinWidth(75);
        btnSquare.setMinWidth(75);
        btnClear.setMinWidth(75);

        // Add buttons to HBox
        functionPane.getChildren().addAll(btnSquareRoot, btnSquare, btnClear);
        this.setBottom(functionPane);

        // Set action for function buttons using simplified lambda expressions
        btnSquareRoot.setOnAction(event ->
                textDisplay.setText(Math.sqrt(Double.parseDouble(textDisplay.getText())) + "")
        );
        btnSquare.setOnAction(event ->
                textDisplay.setText(Math.pow(Double.parseDouble(textDisplay.getText()), 2) + "")
        );
        btnClear.setOnAction(event ->
                textDisplay.setText("")
        );
    }

    // Inner class for CircleButton event handling
    private class CircleButtonHandler implements EventHandler<MouseEvent> {
        public void handle(MouseEvent event) {
            CircleButton circleButton = (CircleButton) event.getSource();
            String value = circleButton.getLabel();
            // Avoid appending the value multiple times unintentionally
            String currentText = textDisplay.getText();

            // If there's no text in the display yet, simply add the value
            if (currentText.isEmpty()) {
                textDisplay.setText(value);
            } else {
                textDisplay.setText(currentText + value);
            }

        }
    }
}
