package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BattleView extends JFrame {
	
	public JLabel w;

	public BattleView() {
		super();
		WindowDestroyer myListener = new WindowDestroyer();
		super.addWindowListener(myListener);
		
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JTextArea ff= new JTextArea() ;
		//ii.setOpaque(true);
		
		ImageIcon e = new ImageIcon(getClass().getResource("mam.jpg"));
		
		 w = new JLabel(e);
		ImageIcon u = new ImageIcon(getClass().getResource("pep.gif"));
		JLabel q = new JLabel(u);
		q.setBounds(300,600,250,250);
		

		add(w);
		
		w.add(q );

		
		

	}


}