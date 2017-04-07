package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.sun.javafx.collections.MappingChange.Map;

import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Cell;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.dragon.Dragon;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.view.StartView;
import dragonball.view.WorldView;

public class GameGUI  {
	StartView v ;
	Game x ;
	WorldView w ;
	
	

	public GameGUI() {
		v= new StartView(this);
		SwingUtilities.updateComponentTreeUI(v);
		
	}
	
	public  void start() {
		
		String LL= JOptionPane.showInputDialog("Enter The Player Name ?");
		if(LL.equals("") || LL==null)
		{
			JOptionPane.showMessageDialog(null, "You Must Enter Player's Name");
		}
		else {
		String y = JOptionPane.showInputDialog("What will be your first Figter name ?!");
		if(y.equals("") || y==null)
		{
			JOptionPane.showMessageDialog(null, "You Must Enter Figter's Name");

		}
		else {
		String [] a = {"Saiyan","Frieza","Namekian","Earthling","Majin"};
		String dd ="";
		char c ;
 int bb= JOptionPane.showOptionDialog(null, "What Race do you want ?!", "Choose Race" , JOptionPane.DEFAULT_OPTION , JOptionPane.INFORMATION_MESSAGE, null, a, dd);
 //System.out.println(bb);
		if(bb==0)
		{
			c = 's';
		}
		else if(bb==1)
		{
			c= 'f';
		}
		else if(bb==2)
		{
		c='n';
		}
		else if(bb==3)
		{
		c='e';
		}
		else {
			c='m';
		}
		
		try {
			x = new Game(LL ,c,y);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		//Cell[][] pp = x.getWorld().getMap();
		v.dispose();
	
		w= new WorldView(LL);
		//int qq= w.x;
		//int cc= w.y ;
		//System.out.println(qq);
		WorldGUI i= new WorldGUI(x,w);
		}}
	}
	 public void load(String aa) throws ClassNotFoundException 
	 {
		 try {
			x= new Game();
		} catch (MissingFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownAttackTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try{
		 x.load(aa);
		 v.dispose();
			
		w= new WorldView(x.getPlayer().getName());
		w.x=x.getWorld().getPlayerColumn();
		w.y=x.getWorld().getPlayerRow();
		WorldGUI gg = new WorldGUI(x, w);
		 
		 
		 
		 
		 
		 
		 }
		 catch(FileNotFoundException e)
		 {
			 JOptionPane.showMessageDialog(null, "No Such Save Exists");
		 }
		 catch (Exception exp) {
				// do nothing
			}
		
	 }
	

	
	
	
	public static void main(String []args)
	{
		GameGUI g= new GameGUI();
	}

	
	

}
