package simulator.graphics;

import javax.swing.*;
import java.awt.*;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Simulator sim = new Simulator();
    JFrame frame = new JFrame("Physics Simulator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(sim, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
    while (true) {
      sim.update();
      frame.repaint();
      Thread.sleep(17);
    }
  }

}
