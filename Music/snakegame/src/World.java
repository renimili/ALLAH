

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.Random;
import javafx.scene.Scene;
import javafx.animation.KeyFrame;
import java.lang.Object;

import javafx.scene.input.KeyCode;

/**
 * World keeps track of the state of a snake game
 */
public class World {

    public final static int DELAY = 200;

    private final int size;

    private final Snake snake;
    private final Food food;

    private final Random random = new Random();

    private final BooleanProperty running = new SimpleBooleanProperty(false);

    private final BooleanProperty paused = new SimpleBooleanProperty(false);

    private final IntegerProperty score = new SimpleIntegerProperty(0);

    public World(int size) {
        this.size = size;

        snake = new Snake(size / 2, size / 2, this);
        food = new Food();

            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(DELAY), e -> {
                    snake.move();
            })); 
            timeline.setCycleCount(-1);
            timeline.play();
           this.paused.addListener( (observable, oldvalue, newvalue) ->{
                    if (newvalue){
                            timeline.play();
                    } else {
                            timeline.pause();
                    }
           });
            paused.set(true);
            
           this.running.addListener( (observable, oldvalue, newvalue) ->{
                    if (!newvalue){
                            timeline.stop();
                    }
           });
            running.set(true);

            moveFoodRandomly();
    }

    public void moveFoodRandomly() {
        do {
            food.moveTo(random.nextInt(size), random.nextInt(size));
        } while (snake.isAt(food.getX(), food.getY()));
    }

    public void endGame() {
        running.set(false);
    }

    public void setRunning(boolean running) {
        this.running.set(running);
    }
    
    public void flipPause() {
        this.paused.set(!this.paused.get());
    }

    public boolean isRunning() {
        return running.get();
    }

    public int getSize() {
        return size;
    }

    public int getScore() {
        return score.get();
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public BooleanProperty getRunningProperty() {
        return running;
    }
    
    public BooleanProperty getPausedProperty() {
        return paused;
    }

    public IntegerProperty getScoreProperty() {
        return score;
    }
}
