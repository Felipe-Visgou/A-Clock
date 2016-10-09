import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonInterface extends JFrame{
	
	
	public ButtonInterface() {
		initUI();
	}

	private void initUI() {
		
		Dimension size;
        JButton b1,b2,b3;
        JPanel p = new JPanel();
        getContentPane().add(p);
        
        p.setLayout(null);
        
        b1 = new JButton("A");
        b2 = new JButton("B");
        
        p.add(b1);
        p.add(b2);
        
        Insets in = p.getInsets();
        size = b1.getPreferredSize();
        b1.setBounds(in.left,in.top, size.width + 100, size.height + 100);
        
        size = b2.getPreferredSize();
        b2.setBounds(150+in.left,  in.top, size.width + 100, size.height + 100);
        
        setSize(300, 150);
        setResizable(false);
        
        setTitle("Relógio Digital");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}