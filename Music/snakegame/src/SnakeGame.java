

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * A JavaFX Pane that displays the snake game represented by the given world
 */
public class SnakeGame extends Pane {

    public static final int SCALE = 16;

    public SnakeGame(World world) {
        setPrefSize(world.getSize() * SCALE, world.getSize() * SCALE);

        // TODO: Implement graphics
        Circle circle = new Circle(SCALE/2);
        circle.setFill(Color.RED);
        Rectangle square = new Rectangle(SCALE, SCALE);
        
        square.setFill(Color.BLUE);
        this.getChildren().addAll(circle, square);
        circle.centerXProperty().bind(world.getFood().getXProperty().multiply(SCALE));
        circle.centerYProperty().bind(world.getFood().getYProperty().multiply(SCALE));
        square.xProperty().bind(world.getSnake().getXProperty().multiply(SCALE));
        square.yProperty().bind(world.getSnake().getYProperty().multiply(SCALE));
        world.getSnake().addListener(segment -> {
            Rectangle square_2 = new Rectangle(SCALE, SCALE);
            square_2.setFill(Color.GREEN);
            this.getChildren().addAll(square_2);
            square_2.xProperty().bind(segment.getXProperty().multiply(SCALE));
            square_2.yProperty().bind(segment.getYProperty().multiply(SCALE));
        });
    }

    public static Pane createUserInterface(World world) {
        VBox ui = new VBox();

        Label scoreText = new Label();
        Label runningText = new Label("Press 's' to start, jaap is very ");

        // TODO: Implement user interface

        ui.getChildren().addAll(scoreText, runningText);

        return ui;
    }
}
