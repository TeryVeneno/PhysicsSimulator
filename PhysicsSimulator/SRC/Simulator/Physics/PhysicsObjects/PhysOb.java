package simulator.physics.physicsobjects;

import simulator.physics.*;
import java.awt.Graphics2D;

public abstract class PhysOb {

  protected double x, y, cx, cy;
  protected double mass;
  protected Vector2D velocity, sum_forces;

  public double get_centerx () {return cx;}

  public double get_centery () {return cy;}

  public double get_x () {return x;}

  public double get_y () {return y;}

  public void change_center (double cx, double cy) {
    this.cx = cx; this.cy = cy;
  }

  public abstract void rotate (double angle);
  public abstract void draw (Graphics2D g2d);

  public abstract boolean colliding (double xc, double yc, Line2D[] ls);

  public abstract void update ();

  public void apply_gravity () {
    forces.add(Vector2D.multiply(Vector2D.gravity, mass));
  }

  public void add_v1 (Line2D[] ls) {
    velocity.add(Vector2D.divide(forces, mass));
    for (int s = 0; s < ls.length; s++) {
      ls[s].change_p1(velocity.transp(ls[s].get_p1()));
      ls[s].change_p2(velocity.transp(ls[s].get_p2()));
    }
    add_v2();
  }

  public void add_v2 () {
    Point2D p_temp = new Point2D(cx, cy);
    p_temp.translate_point(velocity);
    change_center(p_temp.get_x(), p_temp.get_y());
    p_temp = null;
  }

  public void apply_force (Vector2D v) {

  }
}
