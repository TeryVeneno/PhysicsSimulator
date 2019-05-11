package simulator.physics;

public class Point2D {

  private int x, y;

  public Point2D (int x, int y) {
    this.x = x; this.y = y;
  }

  public int get_x () {return x;} public int get_y () {return y;}

  //public void translate_point (Vector2D v) {x+=(int)v.get_x(); y+=(int)v.get_y();}
}
