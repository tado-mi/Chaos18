// for the use of Random, ArrayList
import java.util.*;

// for the use of font, Color, Graphics
import java.awt.*;

// for extending JComponent
import javax.swing.*;

public class ChaosGUI extends JComponent {
    
//    the underlying grid, size, score
    int grid[][];
    int size;
//    colors
    Color   color;

    public ChaosGUI() {

        setColor();
          
    }

    public void paintComponent(Graphics g) {
        
        if (grid == null || size == 0) return;
        
        int radius = 4 * size / 5;
        
        for (int i = 0; i < grid.length; i = i + 1) {
            
            for (int j = 0; j < grid[i].length; j = j + 1) {
                
                if (grid[i][j] < 0) continue;
                
                int x = i * size;
                int y = j * size;
                
                g.setColor(color);
                g.fillOval(x + ((size - radius) / 2), y + ((size - radius) / 2), radius, radius);
                
            }
            
        }
        
    }
   
//    setters        
    public void setGrid(int g[][], int gS) {
        
        grid = g;
        size = gS;
        
    }
    
    public void setColor() {
        
        Color[] colorSet = {new Color(255, 255, 255),  new Color(255, 255, 155), new Color(255, 255, 55), new Color(255, 255, 0), new Color(255, 155, 0), new Color(255, 105, 0), new Color(255, 55, 0), new Color(255, 0, 0), new Color(128, 0, 0), new Color(139, 0, 0), new Color(173,255,47),  new Color(124, 252, 0), new Color(154, 205, 50), new Color(0, 128, 50), new Color (60,179,113), new Color(102,205,170), new Color (0,128,128), new Color(95,158,160),   new Color(70,130,180), new Color(100,149,237), new Color(30,144,255), new Color(72,61,139), new Color(100, 20, 255), new Color(90, 200, 140), new Color(90, 140, 200), new Color(140, 90, 200), new Color(140, 200, 90), new Color(200, 90, 140), new Color(200, 140, 90), new Color(100, 100, 100), new Color(60, 60, 60)};
        Random rand = new Random();
        int c = rand.nextInt() % colorSet.length;
        while (c < 0) c = c + colorSet.length;
        color = colorSet[c];
        
        
    }
   
}