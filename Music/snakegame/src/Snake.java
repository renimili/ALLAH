

import java.util.LinkedList;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Snake consists of segments, where this head segment keeps track of the other body segments
 */
public class Snake extends Segment {

    public interface SnakeSegmentListener {
        public void onNewSegment(Segment segment);
    }

    private Direction direction = Direction.RIGHT;

    private final World world;

    private final List<Segment> body = new LinkedList<>();

    private final List<SnakeSegmentListener> listeners = new LinkedList<>();
    
    private final IntegerProperty score = new SimpleIntegerProperty(0);

    public Snake(int x, int y, World world) {
        super(x, y);
        this.world = world;
        world.getScoreProperty().bindBidirectional(this.score);
    }

    public void move() {
        int newX = getX() + direction.getDX();
        int newY = getY() + direction.getDY();
        if(newX >= world.getSize() || newY >= world.getSize() || newX < 0 || newY < 0){
            world.endGame();
            return;
        }
        for(Segment segment: body){
            int x = segment.getX();
            int y = segment.getY();
            if (newX == x && newY == y){
                world.endGame();
                return;
            }
        }

        int x = this.getX();
        int y = this.getY();
        this.setPosition(newX, newY);
        int newSegmentX = x;
        int newSegmentY = y;
        for(Segment segment: body){
            x = segment.getX();
            y = segment.getY();
            segment.setPosition(newSegmentX, newSegmentY); 
            newSegmentX = x;
            newSegmentY = y;
        }

        if(world.getFood().getX() == newX && world.getFood().getY() == newY){
            Segment segment_2 = new Segment(newSegmentX, newSegmentY);
            for(SnakeSegmentListener listener: listeners){
                listener.onNewSegment(segment_2);
            }
            body.add(segment_2);
            world.moveFoodRandomly();
            this.score.set(this.score.get()+100);
        }
    }

    public void addListener(SnakeSegmentListener listener) {
        listeners.add(listener);
    }

    public void setDirection(Direction newDirection) {
        direction = newDirection;
    }

    public boolean isAt(int x, int y) {
        for (Segment segment : body) {
            if (segment.getX() == x && segment.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public Direction getDirection() {
        return direction;
    }
}
