

import java.util.LinkedList;
import java.util.List;

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

    public Snake(int x, int y, World world) {
        super(x, y);
        this.world = world;
    }

    public void move() {
        int newX = getX() + direction.getDX();
        int newY = getY() + direction.getDY();
        // TODO: Implement movement
        if(newX >= world.getSize() || newY >= world.getSize() || newX <= 0 || newY <= 0){
            world.endGame();
            return;
        }
        if(world.getFood().getX() == newX && world.getFood().getY() == newY){
            Segment segment_2 = new Segment(newX, newY);
            for(SnakeSegmentListener listener: listeners){
                listener.onNewSegment(segment_2);
            }
            body.add(segment_2);
        }
        else{
            
            for(Segment segment: body){
                int x = segment.getX();
                int y = segment.getY();
                segment.setPosition(newX, newY); 
                newX = x;
                newY = y;
            }
            this.setPosition(newX, newY);
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
