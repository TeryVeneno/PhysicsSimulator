package simulator.physics.physicsobjects;

import simulator.physics.*;
import java.awt.Rectangle;
import java.awt.Graphics2D;

public class Box2D extends PhysOb {

  private Rectangle hitbox;
  private double width, height;
  private Line2D[] lines;

  public Box2D (double x, double y, int width, int height) {
    lines = new Line2D[4]; hitbox = new Rectangle((int)x, (int)y, width, height);
    this.x = x; this.y = y; this.width = width; this.height = height;
    cx = average_x(x, width); cy = average_y(y, height);
    lines[0] = new Line2D(new Point2D(x, y), new Point2D(x+width, y));
    lines[1] = new Line2D(new Point2D(x, y), new Point2D(x, y+height));
    lines[2] = new Line2D(new Point2D(x+width, y), new Point2D(x+width, y+height));
    lines[3] = new Line2D(new Point2D(x, y+height), new Point2D(x+width, y+height));
    for (int s = 0; s < 4; s++) {
      lines[s].change_center(cx, cy);
    }
    velocity = new Vector2D(0.0, 0.0);
    forces = new Vector2D(0.0, 0.0);
  }

  private double average_y (double y, double height) {
    double val = (y+y+height)/2;
    return val;
  }

  private double average_x (double x, double width) {
    double val = (x+x+width)/2;
    return val;
  }

  public Rectangle get_hitbox () {return hitbox;}

  public boolean colliding (double xc, double ys, Line2D[] ls) {
    if (ls == null) {
      if (cx - xc < Math.abs(hitbox.width) || cy - yc < Math.abs(hitbox.height)) {
        return true;
      }
      return false;
    } else {
      for (int s = 0; s < lines.length; s++) {
        for (int i = 0; i < ls.length; i++) {
          if (lines[s].line_cross(ls[i])) {
            return true;
          }
        }
      }
      return false;
    }
  }

  public double get_centerx() {return cx;}

  public double get_centery() {return cy;}

  public void draw (Graphics2D g2d) {
    for (int s = 0; s < 4; s++) {
      lines[s].draw(g2d);
    }
  }

  public void update () {
    apply_gravity();
    add_v1(lines);
    rotate(5);
  }

  public void rotate (double angle) {
    for (int s = 0; s < 4; s++) {
      lines[s].rotate_line(angle);
    }
  }

  public void change_center (double cx, double cy) {
    this.cx = cx; this.cy = cy;
    for (int s = 0; s < 4; s++) {
      lines[s].change_center(cx, cy);
    }
  }

  public double get_x () {return x;}

  public double get_y () {return y;}

  public double get_width () {return width;}

  public double get_heigth () {return height;}
}
