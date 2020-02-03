package simulator.physics;

import java.awt.Graphics2D;

public class Line2D {
  private Point2D p1, p2;

  public Line2D (Point2D p1, Point2D p2) {
    this.p1 = p1; this.p2 = p2;
  }

  public Point2D get_p1 () {return p1;} public Point2D get_p2 () {return p2;}

  public void translate_line (Vector2D v) {p1.translate_point(v); p2.translate_point(v);}

  public void rotate_line (double angle) {
    p1.rotate_point(-angle); p2.rotate_point(-angle);
  }

  public void draw (Graphics2D g2d) {
    g2d.drawLine((int)p1.get_x(), (int)p1.get_y(), (int)p2.get_x(), (int)p2.get_y());
  }

  public void change_center (double cx, double cy) {
    p1.change_center(cx, cy); p2.change_center(cx, cy);
  }

  public void change_p1 (Point2D p) {
    p1 = p;
  }

  public void change_p2 (Point2D p) {
    p2 = p;
  }

  public boolean line_cross (Line2D l) {
    return java.awt.geom.Line2D.linesIntersect(p1.get_x(), p1.get_y(), p2.get_x(), p2.get_y(), 
    l.get_p1().get_x(), l.get_p1().get_y(), l.get_p2().get_x(), l.get_p2().get_y());
  }
}
