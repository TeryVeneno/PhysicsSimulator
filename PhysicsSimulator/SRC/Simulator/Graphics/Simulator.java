package simulator.graphics;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import simulator.physics.physicsobjects.*;
import simulator.physics.*;

public class Simulator extends JPanel {
  private static final long serialVersionUID = 42l;

  ArrayList<PhysOb> physics_objects = new ArrayList<PhysOb>();

  public Simulator() {
    setPreferredSize(new Dimension(500, 500));
    physics_objects.add(new Box2D(50, 50, 10, 10));
    physics_objects.add(new Box2D(65, 65, 10, 10));
    physics_objects.add(new Box2D(80, 80, 10, 10));
    physics_objects.add(new Box2D(95, 95, 10, 10));
    physics_objects.add(new Box2D(110, 110, 10, 10));
  }

  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D)g;
    g2d.setColor(Color.BLACK);
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    for (int s = 0; s < physics_objects.size(); s++) {
      physics_objects.get(s).draw(g2d);
    }
  }

  public void update () {
    for (int s = 0; s < physics_objects.size(); s++) {
      physics_objects.get(s).update();
    }
  }
}
