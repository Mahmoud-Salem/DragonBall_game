package dragonball.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import dragonball.controller.*;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;

public class StartView extends JFrame implements ActionListener {


	GameGUI GG ;


		public StartView(GameGUI x) {
			
			super();
			WindowDestroyer myListener = new WindowDestroyer();
			super.addWindowListener(myListener);
			setFocusable(true);
			setFocusableWindowState(true);
			setFocusTraversalKeysEnabled(true);
			
			this.GG= x;
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			
			setVisible(true);
		//	setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			ImageIcon o = new ImageIcon(getClass().getResource("aa.jpg"));
			
			JLabel w= new JLabel(o);
			
			add(w);
			
			JButton j= new JButton("Start");
			
			j.addActionListener(this);
			j.setBounds(850, 500,200,20 );
			w.add(j);
			
			JButton f= new JButton("Continue");
			JButton d= new JButton("Exit");
		
			j.setBackground(Color.GRAY);
			f.setBackground(Color.GRAY);
			d.setBackground(Color.GRAY);

			f.addActionListener(this);
			d.addActionListener(this);

			f.setBounds(850, 540, 200, 20);
			d.setBounds(850, 580, 200, 20);
			w.add(f);
			w.add(d);
			
			
			
			
			
			
			
			
		}
	
		@Override
		public void actionPerformed(ActionEvent e) {

			
			if(e.getActionCommand().equals("Exit"))
			{
				this.dispose();
			}
			else if(e.getActionCommand().equals("Start"))
			{
			
		 	GG.start();
		 	
				
			}
			else {
				
				String ffff= JOptionPane.showInputDialog("What is the file name ?!");
				try {
					GG.load(ffff);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
			
		}
	
}
	


