package simulator.physics;

public class Vector2D {

  private double x, y, direction, magnitude;

  public Vector2D (double dir, double mag) {
    direction = Math.toRadians(dir); magnitude = mag;
    x = mag*Math.cos(dir); y = mag*Math.sin(dir);
  }

  public Vector2D (double x, double y) {
    this.x = x; this.y = y;
    direction = Math.arctan(y/x); magnitude = Math.sqrt(x*x + y*y);
  }

  public static double find_direction (int xs, int ys) {
    if (xs < 0 && ys < 0) {
      return Math.pi
    }
  }

  public double get_x () {return x;} public double get_y () {return y;}
  public double get_dir () {return direction;} public double get_mag () {return magnitude;}

  public Point2D transp (Point2D p) {return new Point2D (p.get_x()+(int)x, p.get_y()+(int)y);}
}
