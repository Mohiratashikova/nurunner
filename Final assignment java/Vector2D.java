public class Vector2D {

    public double x;
    public double y;
    public double speed = 3;
    public Vector2D (double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void set (Vector2D v) {
        this.x = v.x;
        this.y = v.y;
    }
    public double distanceTo (Vector2D other) {
        double distance = Math.sqrt( Math.pow((x - other.x ),2) + Math.pow((y - other.y),2));       
        return distance;
    }
    public Vector2D normalize() {
        double length = Math.sqrt( Math.pow((x),2) + Math.pow((y),2));
        Vector2D ret = new Vector2D(this.x/length*speed, this.y/length*speed);
        return ret;
    }
    public Vector2D plus (Vector2D other ) {
        Vector2D res = new Vector2D(other.x + this.x, other.y + this.y );
        return res;
    }
    public Vector2D minus (Vector2D other ) {
        Vector2D res = new Vector2D(this.x - other.x, this.y - other.y);
        return res;
    }

}