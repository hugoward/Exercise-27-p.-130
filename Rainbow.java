// Chapter 5 Question 27

// ________________________________________________

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rainbow extends JPanel
{
  // Declare skyColor:
 Color skyColor= (Color.CYAN);

  public Rainbow()
  {
    setBackground(skyColor);
  }

  // Draws the rainbow.
  public void paintComponent(Graphics g)
  {
	  
    super.paintComponent(g);
    int width = getWidth();    
    int height = getHeight();

    // Declare and initialize local int variables xCenter, yCenter
    // that represent the center of the rainbow rings:
    int xCenter = (int)((1.0/2)*width);
    int yCenter = (int)((3.0/4)*height);
    
    
 
    // Declare and initialize the radius of the large semicircle:
    int largeRadius = width/2;
    
    g.setColor(Color.RED);

    // Draw the large semicircle:
    g.fillArc(xCenter - largeRadius/2,yCenter - largeRadius/2 + largeRadius/4 -height/4,largeRadius,largeRadius,0,180);

    // Declare and initialize the radii of the small and medium
    // semicircles and draw them:
    
    int smallRadius= width/4;
    
    int mediumRadius =(int) Math.sqrt(smallRadius * largeRadius);
    g.setColor(Color.GREEN);
    g.fillArc(xCenter- mediumRadius/2, yCenter-mediumRadius/2+ mediumRadius/4-height/4+20, mediumRadius, mediumRadius, 0, 180);
    
    
    
    g.setColor(Color.MAGENTA);
    g.fillArc(xCenter- smallRadius/2, yCenter/2+50+12, smallRadius, smallRadius, 0, 180);
    
    

    // Calculate the radius of the innermost (sky-color) semicircle
    // so that the width of the middle (green) ring is the
    // arithmetic mean of the widths of the red and magenta rings:
    // ________________________________________________

    // Draw the sky-color semicircle:
    g.setColor(skyColor);
    g.fillArc(xCenter- 20/2-12, yCenter-20/2+ 20/4-height/4+50, 40, 40, 0, 180);
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 500, 500);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}
