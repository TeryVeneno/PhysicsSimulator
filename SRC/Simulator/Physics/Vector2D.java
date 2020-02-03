package simulator.physics;

public class Vector2D {

  private double x, y, direction, magnitude;
  public static final Vector2D gravity = new Vector2D(270, .01, true);

  public Vector2D (double dir, double mag, boolean c) {
    direction = -Math.toRadians(dir); magnitude = mag;
    find_x_y();
  }

  public Vector2D (double x, double y) {
    this.x = x; this.y = y; find_mag_dir();
  }

  private void find_mag_dir () {
    direction = find_direction(x, y); magnitude = Math.sqrt(x*x + y*y);
  }

  public static double find_direction (double xs, double ys) {
    if (xs == 0) {
      return 0;
    } else if (xs < 0) {
      return -Math.atan(ys/xs)+Math.PI;
    } else if (ys < 0 && xs > 0) {
      return -Math.atan(ys/xs)+(2*Math.PI);
    } else {
      return -Math.atan(ys/xs);
    }
  }

  public void find_x_y () {
    if (direction == -Math.toRadians(270) || direction == -Math.toRadians(90)) {
      x = 0;
      y = magnitude*Math.sin(direction);
    } else if (direction == -Math.toRadians(0) || direction == -Math.toRadians(180)) {
      y = 0;
      x = magnitude*Math.cos(direction);
    } else {
      x = magnitude*Math.cos(direction);
      y = magnitude*Math.sin(direction);
    }
  }

  public double get_x () {return x;}
  public double get_y () {return y;}

  public double get_dir () {return direction;}
  public double get_mag () {return magnitude;}

  public Point2D transp (Point2D p) {
    return new Point2D (p.get_x()+x, p.get_y()+y);
  }

  public void set_dir (double dir) {
    direction = -Math.toRadians(dir);
  }
  public void set_mag (double mag) {magnitude = mag;}

  public void set_x_y (double x, double y) {
    this.x = x; this.y = y; find_mag_dir();
  }

  public void add (Vector2D v) {
    x += v.get_x(); y += v.get_y();
    find_mag_dir();
  }

  public void add (double val) {
    magnitude += val; find_x_y();
  }

  public void subtract (Vector2D v) {
    x -= v.get_x(); y -= v.get_y();
    find_mag_dir();
  }

  public void subtract (double val) {
    magnitude -= val; find_x_y();
  }

  public void multiply (double val) {
    x *= val; y*=val; find_mag_dir();
  }

  public void divide (double val) {
    x /= val; y /= val; find_mag_dir();
  }

  public static Vector2D add (Vector2D v1, Vector2D v2) {
    return new Vector2D ((int)(v1.get_x()+v2.get_x()),(int)(v1.get_y()+v2.get_y()));
  }

  public static Vector2D subtract (Vector2D v1, Vector2D v2) {
    return new Vector2D ((int)(v1.get_x()-v2.get_x()),(int)(v1.get_y()-v2.get_y()));
  }

  public static Vector2D multiply (Vector2D v, double val) {
    return new Vector2D(v.get_x()*val, v.get_y()*val);
  }

  public static Vector2D divide (Vector2D v, double val) {
    return new Vector2D(v.get_x()/val, v.get_y()/val);
  }

  public String toString () {
    return x+", "+y;
  }
}
