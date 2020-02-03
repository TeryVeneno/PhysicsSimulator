package simulator.physics;

public class Point2D {

  private double x, y, cx, cy;

  public Point2D (double x, double y) {
    this.x = x; this.y = y;
    this.cx = 0; this.cy = 0;
  }

  public Point2D (double x, double y, double cx, double cy) {
    this.x = x; this.y = y;
    this.cx = cx; this.cy = cy;
  }

  public double get_x () {return x;} public double get_y () {return y;}

  public void translate_point (Vector2D v) {x+=v.get_x(); y+=v.get_y();}

  public void rotate_point (double angle) {
    double a = Math.toRadians(angle); double x1 = x; double y1 = y;
    x = cx+(x1-cx)*Math.cos(a)-(y1-cy)*Math.sin(a);
    y = cy+(x1-cx)*Math.sin(a)+(y1-cy)*Math.cos(a);
  }

  public void change_center (double cx, double cy) {
    this.cx = cx; this.cy = cy;
  }

  @Override
  public String toString() {
    return x+", "+y;
  }
}
