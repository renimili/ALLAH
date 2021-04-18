

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Food {

    private final IntegerProperty x = new SimpleIntegerProperty(), y = new SimpleIntegerProperty();

    public void moveTo(int x, int y) {
        this.x.set(x);
        this.y.set(y);
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
