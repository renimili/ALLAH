
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.awt.event.InputMethodListener;
import javafx.scene.Scene;
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
import java.awt.event.KeyListener;


/**
 * Handles controls of a snake game, where the 'a' and 'd' keys can be used to move and 's' (un)pauses the game
 */
public class InputHandler {

    private final EventHandler<KeyEvent> keyHandler;
    private final EventHandler<MouseEvent> mouseHandler;
    public InputHandler(World world) {
        Snake snake = world.getSnake();
        keyHandler = keyEvent -> {
            // TODO: Implement controls
            KeyCode keyCode = keyEvent.getCode();

        if (keyCode.equals(KeyCode.A)) {
            snake.setDirection(Direction.LEFT);
        };
        if (keyCode.equals(KeyCode.D)) {
            snake.setDirection(Direction.RIGHT);
        };
        if (keyCode.equals(KeyCode.W)) {
            snake.setDirection(Direction.UP);
        };
        if (keyCode.equals(KeyCode.S)) {
            snake.setDirection(Direction.DOWN);
        };
        };
        mouseHandler = mouseEvent -> {
            // TODO: Implement mouse

        };
    };

    public EventHandler<KeyEvent> getKeyHandler() {
        return keyHandler;
    }

    public EventHandler<MouseEvent> getMouseHandler() {
        return mouseHandler;
    }
    
    
}
