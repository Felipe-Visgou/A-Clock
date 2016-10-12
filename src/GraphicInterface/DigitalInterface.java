package GraphicInterface;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Fachada.*;
import ObserverPackage.*;

public class DigitalInterface extends JFrame implements Observer{
	
	private String state;
	private Integer hour;
	private Integer minute;
	private Integer second;
	
	public DigitalInterface() {
		ClockFacade cf = new ClockFacade();
		cf.registerObserver(this);
		initUI();
		hour = new Integer(15);
		minute = new Integer(9);
		second = new Integer(0);
		state = (((int)(hour/10) == 0)? "0"+hour.toString() : hour.toString()) + ":" +
				(((int)(minute/10)==0)? "0"+minute.toString(): minute.toString()); 
	}
	class Horas extends JPanel{
		public Horas(){
			initBoard();
		}
		private void initBoard(){
			setFocusable(true);
	        setBackground(Color.BLACK);  
		}
	    @Override
	    public void paintComponent(Graphics g) {
	    	
	        super.paintComponent(g);
	        
	        doDrawing(g);
	    }
		private void doDrawing(Graphics g) {
			ClockFacade cf = new ClockFacade();
			String hour;
			String[] split = state.split(":");
			hour = split[0];
			Graphics2D g2d = (Graphics2D) g;
			g2d.setBackground(Color.BLACK);
			
			/* Check State to change color */
			if(cf.getState()==1){
				g2d.setColor(Color.RED);
			}
			else{
				g2d.setColor(Color.WHITE);
			}
			
			g.setFont(g.getFont().deriveFont(150.0f));
			g2d.drawString(hour, 40, 130);
			g2d.setColor(Color.WHITE);
			g2d.drawString(":", 220, 130);
		}  
	}
	class Minutos extends JPanel{
		public Minutos(){
			initBoard();
		}
		private void initBoard(){
			setFocusable(true);
	        setBackground(Color.BLACK);  
		}
	    @Override
	    public void paintComponent(Graphics g) {
	    	
	        super.paintComponent(g);
	        
	        doDrawing(g);
	    }
		private void doDrawing(Graphics g) {
			ClockFacade cf = new ClockFacade();
			String minutes;
			String[] split = state.split(":");
			minutes = split[1];
			Graphics2D g2d = (Graphics2D) g;
			g2d.setBackground(Color.BLACK);
			
			/* Check State to change color */
			if(cf.getState()==2){
				g2d.setColor(Color.RED);
			}
			else{
				g2d.setColor(Color.WHITE);
			}
			g.setFont(g.getFont().deriveFont(150.0f));
			g2d.drawString(minutes, 280, 130);
		}  
	}
	private void initUI() {

    	Horas H = new Horas();
    	Minutos M = new Minutos();
    	this.getContentPane().setBackground(Color.BLACK);
    	H.setBounds(0, 0, 250, 200);
    	M.setBounds(250, 0, 250, 200);
        add(H);
        add(M);
        
        setSize(500, 200);
        setResizable(false);
        
        setTitle("Relógio Digital");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void update(int newHour, int newMinute, int newSecond) {
		hour = newHour;
		minute = newMinute;
		second = newSecond;
		state = (((int)(hour/10) == 0)? "0"+hour.toString() : hour.toString()) + ":" +
				(((int)(minute/10)==0)? "0"+minute.toString(): minute.toString()); 
		repaint();
	}
}