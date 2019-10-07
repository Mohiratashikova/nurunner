public class Closest extends State {
    public Closest (Common c) {
        super(c, "Closest");
        isOver = false;
        isVisible = true;
    }
    @Override
    public void step (Entity e) {
        double dist = Double.MAX_VALUE;
        Vector2D direction = null;
        Assessment temp = null;
        for (Assessment a : common.assessments) {
            if (a.state.isVisible)  {
                double distance = e.position.distanceTo(a.position);
                if (dist >= distance) {
                    dist = distance;
                    direction = a.position;
                    temp = a;
                } 
            }
        }
        if (direction != null) {
            if (e.position.distanceTo(direction) <= 2) {
                e.position.set(direction);
            } else {
                e.position = e.position.plus(direction.minus(e.position).normalize());
            }
            if ((e.position.x-direction.x < 0.01) && (e.position.y - direction.y < 0.01)) {
                if (temp.state.isVisible)  {
                    e.grade += temp.points;
                    temp.state.isVisible = false;
                }
                isOver = true;
            }
        }
    }
}