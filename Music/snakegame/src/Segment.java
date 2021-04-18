

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Represents one body part of a snake
 */
public class Segment {

    private final IntegerProperty x, y;

    public Segment(int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

    public void setPosition(int x, int y) {
        this.x.setValue(x);
        this.y.setValue(y);
    }

    public int getX() {
        return x.get();
    }

    public int getY() {
        return y.get();
    }

    public IntegerProperty getXProperty() {
        return x;
    }

    public IntegerProperty getYProperty() {
        return y;
    }
}
