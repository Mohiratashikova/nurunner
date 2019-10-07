public class ZigZag extends State {
    public Vector2D direction;
    public int duration;
    public ZigZag (Vector2D direction, int duration, Common c) {
        super(c, "ZigZag");
        isOver = false;
        isVisible = true;
        this.direction = direction;
        this.duration = duration;
    }
    @Override 
    public void step (Entity e) {
        e.position = e.position.plus(direction.normalize());
        if (e.position.x >= (e.common.windowWidth) || e.position.x < 0) {
            direction.x *= -1;
        }
        if (e.position.y >= (e.common.windowHeight) || e.position.y < 0) {
            direction.y *= -1;
        }
        --duration;
        if (duration <= 0) {
            isOver = true;
        }
    }
}