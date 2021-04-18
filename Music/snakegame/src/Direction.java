

public enum Direction {
    UP(0, -1),
    RIGHT(1, 0),
    DOWN(0, 1),
    LEFT(-1, 0);

    private final int dX, dY;

    private Direction(int dX, int dY) {
        this.dX = dX;
        this.dY = dY;
    }

    public int getDX() {
        return dX;
    }

    public int getDY() {
        return dY;
    }

    public Direction rotateLeft() {
        switch(this) {
            case UP: return LEFT;
            case LEFT: return DOWN;
            case DOWN: return RIGHT;
            default: return UP;
        }
    }

    public Direction rotateRight() {
        switch(this) {
            case UP: return RIGHT;
            case RIGHT: return DOWN;
            case DOWN: return LEFT;
            default: return UP;
        }
    }
}
