package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

import dragonball.controller.WorldGUI;

public class WorldView extends JFrame  {
	
	public JButton [] [] a ;
	public int x ;
	public int y ;
	public JLabel level; 
	public JTextArea jlevel ;
	public JPanel jpanel ;
	
	public WorldView(String salem )
	{
		super();
		
		WindowDestroyer myListener = new WindowDestroyer();
		super.addWindowListener(myListener);
		setExtendedState(this.MAXIMIZED_BOTH);
		setVisible(true);
	//	setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout());
		
		level = new JLabel();
		level.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		level.setText("");
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(10,10));
		
		
		jlevel = new JTextArea();
		jlevel.setPreferredSize(new Dimension(300, getHeight()));
		add(jlevel,BorderLayout.EAST);
		add(jpanel,BorderLayout.CENTER);
		jlevel.setBackground(Color.BLACK);
		
		x=9 ;
		y=9;
	//	jlevel.setText(salem);
		//jlevel.setOpaque(false);
		jlevel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		jlevel.setForeground(Color.BLUE);
		
		jlevel.setEditable(false);
		//jlevel.setSelectedTextColor(Color.WHITE);

		//jlevel.setBounds(0, 1000, 250, 250);
		a = new JButton[10][10];
	
}
	public void updateLevel(WorldGUI ff)
	{
		jlevel.setText(" Active Fighter's Info \n\n Fighter :"+ff.game.getPlayer().getActiveFighter().getName()+"\n Level :"+ff.game.getPlayer().getActiveFighter().getLevel()+"\n Ability Points :"+ff.game.getPlayer().getActiveFighter().getAbilityPoints()+"\n Health Points :"+ff.game.getPlayer().getActiveFighter().getMaxHealthPoints()+"\n Blast Damage :"+ff.game.getPlayer().getActiveFighter().getBlastDamage()+"\n Physical Damage :"+ff.game.getPlayer().getActiveFighter().getPhysicalDamage()+"\n Ki :"+ff.game.getPlayer().getActiveFighter().getMaxKi()+"\n Stamina :"+ff.game.getPlayer().getActiveFighter().getMaxStamina()+"\n\n\n\n\n\n Player's Info \n\n Player :"+ff.game.getPlayer().getName()+"\n Senzu Beans :"+ff.game.getPlayer().getSenzuBeans()+"\n Dragon Balls :"+ff.game.getPlayer().getDragonBalls());
		
	//	jlevel.setSelectedTextColor(Color.WHITE);
		

	}
	


	
}
