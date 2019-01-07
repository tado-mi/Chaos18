// for the use of random function
import java.util.Random;

// for implementing the ActionListener
import java.awt.*;
import java.awt.event.*;

// for extending JFrame and using the Timer
import javax.swing.*;

public class Chaos extends JFrame implements ActionListener {
    
//    GUI
    ChaosGUI GUI;
//    timer
    Timer timer;

//    size of the balls
    int size;
    
//    number of balls added
	int n;
//    number of balls aligned that blow
    int m;
    
//    the underlying grid and its dimensions
    int grid[][];
    int w, h;
    
    public Chaos (int size, int w, int h) {
    
        this.size = size;

        this.w = w;
        this.h = h;
        
        int adj = 20;
        if (size > 15) adj = size / 2;
        
        setSize (size * w, size * h + adj);
        setTitle("ChaosContained");
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        grid = new int[w][h];
        
//        initialise to -1
        for (int i = 0; i < w; i = i + 1) {
            
            for (int j = 0; j < h; j = j + 1) grid[i][j] = -1;
            
        }
        
        int ref = w;
        if (ref > h) ref = h;
        
//        how many balls need to be aligned to disappear
        m = 2 * ref / 3 - 2;
        if (m < 2) m = 2;
        
//        cover up ~3% of the area
        n =  h * w / 50;
        if (n < 1) n = 1;
        
        System.out.println("adding  " + n + " balls at each move.");
        System.out.println("need    " + m + " balls aligned to score.");
        
        GUI = new ChaosGUI();    
        add(GUI);
        GUI.setGrid(grid, size);
        
        repaint();
        
        timer = new Timer(100, this);
        timer.start();
        
    }
    
//    a method to set random balls to be added to the grid in next move
    public void add() {
        
        Random rand = new Random();
        boolean colorChange = false;
        boolean stop = true;
        
        for (int i = 0; i < n; i = i + 1) {
            
//            random coordinates
            int x = rand.nextInt() % w;
            if (x < 0) x = x + w;
            
            int y = rand.nextInt() % h;
            if (y < 0) y = y + h;
            
//            if there is a ball in the cell
//            or the cell is already designated
            if ((grid[x][y] != -1)) {
                
//                try again
                i = i - 1;
                continue;
                
            }
            
//            assign
            grid[x][y] = 0;
            
            boolean temp = update(x, y);
            
            colorChange = temp;
            
            stop        = stop && temp;
            
        }
        
        if (colorChange) GUI.setColor();
        if (stop)        timer.stop();
                
    }
    
//    '_'
    public boolean horizontal (int x, int y) {
		
		int c = grid[x][y];

        int st = x;
        if (st > 0) {
        
            while (grid[st - 1][y] == c) {
                
                st = st - 1;
                if (st == 0) break;
                
            }
            
        }
        
        int end = x;
        if (end < w - 1) {
            
            while (grid[end + 1][y] == c) {
                
                end = end + 1;
                if (end == w - 1) break;
                
            }
            
        }
                
        if (end - st > m) {
            
            int temp = end - st + 1;
        
//			  remove the balls
			for (int i = 0; i < temp; i = i + 1) {
				
				grid[st + i][y] = -1;
                
			}
    
//            return the current ball       
            grid[x][y] = c;
            return true;
        
        }
        
        return false;
		
	}

//    '|'	
	public boolean vertical (int x, int y) {
		
		int c = grid[x][y];
        
        int st = y;
        if (st > 0) {
        
            while (grid[x][st - 1] == c) {
                
                st  = st - 1;
                if (st == 0) break;
                
            }
            
        }
        
        int end = y;
        if (end < h - 1) {
            
            while (grid[x][end + 1] == c) {
                
                end = end + 1;
                if (end == h - 1) break;
                
            }
            
        }
         
        if (end - st > m) {
            
            int temp = end - st + 1;
            
//			  remove the balls
			for (int i = 0; i < temp; i = i + 1) {
				
				grid[x][st + i] = -1;
            	
			}

//            return the current ball    
            grid[x][y] = c;
            return true;
        
        }
        
        return false;
		
	}
    	
//    '\' or '/'
    public boolean diagonal(int x, int y) {
        
        boolean D = diagonalDown(x, y);
        boolean U = diagonalUp(x, y); 
        
        return D || U;
        
    }
    
//    '\'
    public boolean diagonalDown (int x, int y) {
        
        int c = grid[x][y];
        
        int xSt = x;
        int ySt = y;
        
        if (xSt > 0  && ySt > 0) {
        
            while (grid[xSt - 1][ySt - 1] == c) {
                
                xSt = xSt - 1;
                ySt = ySt - 1;
        
                if (xSt == 0 || ySt == 0) break;
                
            }
            
        }
        
        int xEnd = x;
        int yEnd = y;
        
        if (xEnd < w - 1 && yEnd < h - 1) {
            
            while (grid[xEnd + 1][yEnd + 1] == c) {
                
                xEnd = xEnd + 1;
                yEnd = yEnd + 1;
                
                if (xEnd == w - 1 || yEnd == h - 1) break;
                
            }
            
        }
        
        if (xEnd - xSt > m) {
            
            int temp = xEnd - xSt + 1;

//			  remove the balls
			for (int i = 0; i < temp; i = i + 1) {
				
				grid[xSt + i][ySt + i] = -1;
				
            }
            
//            return the current ball        
            grid[x][y] = c;
            
            return true;
        
        }
        
        return false;
		
	}

//    '/'   
    public boolean diagonalUp(int x, int y) {
        
        int c = grid[x][y];
        
        int xSt = x;
        int ySt = y;
        
        if (xSt < w - 1  && ySt > 0) {
        
            while (grid[xSt + 1][ySt - 1] == c) {
                
                xSt = xSt + 1;
                ySt = ySt - 1;
        
                if (xSt == w - 1 || ySt == 0) break;
                
            }
            
        }
        
        int xEnd = x;
        int yEnd = y;
        
        if (xEnd > 0 && yEnd < h - 1) {
            
            while (grid[xEnd - 1][yEnd + 1] == c) {
                
                xEnd = xEnd - 1;
                yEnd = yEnd + 1;
                
                if (xEnd == 0 || yEnd == h - 1) break;
                
            }
            
        }
        
        if (yEnd - ySt > m) {
            
            int temp = yEnd - ySt + 1;
            
//			  remove the balls
			for (int i = 0; i < temp; i = i + 1) {
				
				grid[xSt - i][ySt + i] = -1;
            	
			}     
            
//            return the current ball        
            grid[x][y] = c;
            return true;
        
        }
        
        return false;
        
    }
    
    public boolean update(int x, int y) {
        
        boolean h = horizontal(x, y);
        
        boolean v = vertical(x, y);
        
        boolean d = diagonal(x, y);
        
        if ( h || v || d ) {
            
            grid[x][y] = -1;
            return true;
        
        }
        
        return false;
        
    }
    
    public void actionPerformed(ActionEvent e) {
    
        add();
        GUI.repaint();
    }
    
}
