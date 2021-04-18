

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

        Circle circle = new Circle(SCALE/2);
        circle.setFill(Color.RED);
        Rectangle square = new Rectangle(SCALE, SCALE);
        
        square.setFill(Color.BLUE);
        this.getChildren().addAll(circle, square);
        
        circle.centerXProperty().bind(world.getFood().getXProperty().multiply(SCALE).add(SCALE/2));
        circle.centerYProperty().bind(world.getFood().getYProperty().multiply(SCALE).add(SCALE/2));
        
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
                        scoreText.textProperty().bind(world.getScoreProperty().asString().concat(" points"));
                        
                        Label pausedText = new Label("Running, press s to pause");
                        Label runningText = new Label("Pause, press s to play");
                        world.getPausedProperty().addListener((observable, oldvalue, newvalue) ->{
                            if (newvalue){
                                pausedText.setOpacity(1.0);
                                runningText.setOpacity(0.0);
                            }else{
                                pausedText.setOpacity(0.0);
                                runningText.setOpacity(1.0);
                            }
                        });
                        pausedText.setOpacity(0.0);
                        ui.getChildren().addAll(scoreText, runningText,pausedText);

                        return ui;
            }
}
