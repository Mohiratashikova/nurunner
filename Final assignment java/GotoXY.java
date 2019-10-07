public class GotoXY extends State {
    public Vector2D direction;
    public GotoXY (Vector2D direction, Common c) {
        super(c, "GotoXY");
        isOver = false;
        isVisible = true;
        this.direction = direction;
    }
    @Override 
    public void step (Entity e) {
        if (e.position.distanceTo(direction) <= 2) {
            e.position.set(direction);
        } else {
            e.position = e.position.plus((direction.minus(e.position)).normalize());
        }

        if ((e.position.x-direction.x < 0.01) && (e.position.y - direction.y < 0.01)) {
            isOver = true;
        }
    }
}