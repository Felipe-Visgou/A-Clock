package LogicalInterface;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ClockSet extends JFrame{
	
	private String state;
	
	public ClockSet() {
		initUI();
	}

	class Relogio extends JPanel{
	    @Override
	    public void paintComponent(Graphics g) {
	    	
	        super.paintComponent(g);

	        doDrawing(g);
	    }

		private void doDrawing(Graphics g) {
			
			JButton A = new JButton("A");
			JButton B = new JButton("A");
			
		}
	}
	private void initUI() {

    	Relogio I = new Relogio();
        add(I);
        
        setSize(456, 480);
        setResizable(false);
        
        setTitle("Relógio Analógico");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
