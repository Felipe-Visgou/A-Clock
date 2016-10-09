import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AnalogInterface extends JFrame{
	
	private int startX, startY;
	private int endX, endY;
	private double hoursAngle, minutesAngle,secondsAngle;
	private int  hour, minute, second;
	
	public AnalogInterface() {
		initUI();
		hour = 0;
		minute = 0;
		second = 0;
		startX = 224; startY = 224;
		hoursAngle = ((hour%12)*5*6);
		minutesAngle = minute*6;
		secondsAngle = second*6;
		
	}

	class Relogio extends JPanel{
	    @Override
	    public void paintComponent(Graphics g) {
	    	
	        super.paintComponent(g);

	        doDrawing(g);
	    }

		private void doDrawing(Graphics g) {
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			ImageIcon img = new ImageIcon("analogico.jpg");
			Image clock = img.getImage();
			
			g2d.drawImage(clock, 0, 0, this);
			
			
			System.out.println(hoursAngle);
			System.out.println(minutesAngle);
			
			g2d.setStroke(new BasicStroke(2));
			g2d.setColor(Color.RED);
			endX = (int) (224 + 145*Math.sin(Math.toRadians(-secondsAngle - 180)));
			endY = (int) (224 + 145*Math.cos(Math.toRadians(-secondsAngle - 180)));
			g2d.drawLine(startX, startY, endX, endY);
			
			g2d.setStroke(new BasicStroke(3));
			g2d.setColor(Color.BLUE);
			endX = (int) (224 + 120*Math.sin(Math.toRadians(-minutesAngle - 180)));
			endY = (int) (224 + 120*Math.cos(Math.toRadians(-minutesAngle - 180)));
			g2d.drawLine(startX, startY, endX, endY);

			g2d.setStroke(new BasicStroke(5));
			g2d.setColor(Color.ORANGE);
			endX = (int) (224 + 95*Math.sin(Math.toRadians(-hoursAngle - 180)));
			endY = (int) (224 + 95*Math.cos(Math.toRadians(-hoursAngle - 180)));
			g2d.drawLine(startX, startY, endX, endY);		
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
