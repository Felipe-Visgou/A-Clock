import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DigitalInterface extends JFrame{
	
	private String state;
	
	public DigitalInterface() {
		initUI();
		state = "15:00";
	}

	class Relogio extends JPanel{
		
	    public Relogio() {

	        initBoard();
	    }
	    
	    private void initBoard() {
	        
	        setFocusable(true);
	        setBackground(Color.BLACK);     
	        
	    }
	    @Override
	    public void paintComponent(Graphics g) {
	    	
	        super.paintComponent(g);

	        doDrawing(g);
	    }

		private void doDrawing(Graphics g) {
			
			String minutes;
			String hour;
			String[] split = state.split(":");
			hour = split[0];
			minutes = split[1];
			Graphics2D g2d = (Graphics2D) g;
			g2d.setBackground(Color.BLACK);
			g2d.setColor(Color.WHITE);
			g.setFont(g.getFont().deriveFont(150.0f));
			
			g2d.drawString(":", 220, 130);
			g2d.drawString(hour, 40, 130);
			g2d.drawString(minutes, 280, 130);
			
			
			
		}
	}
	private void initUI() {

    	Relogio I = new Relogio();
    	this.getContentPane().setBackground(Color.BLACK);
        add(I);
        
        setSize(500, 200);
        setResizable(false);
        
        setTitle("Relógio Digital");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}