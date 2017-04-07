package dragonball.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.dragon.Dragon;
import dragonball.model.dragon.DragonWish;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.view.DragonView;

public class DragonGUI implements ActionListener {
	DragonView dragon ;
	Game g;
	Dragon d ;
	DragonWish []  da ;
	WorldGUI ben ;

	public DragonGUI(Game gg,Dragon dd , WorldGUI kek) {
		dragon = new DragonView();
		g=gg;
		d=dd;
		ben = kek ;
		
		da= d.getWishes();
		JButton j= new JButton();
		j.setText("Choose Wish");
		j.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		j.setBorder(null);
		
		j.setBackground(Color.GRAY);
		j.setBounds(800, 400, 500, 100);
		int jj = 500 ;
		
		dragon.f.add(j);
		
		
		for (int i = 0; i < da.length; i++) {
			JButton bb = new JButton(da[i].toString());
			jj = jj+80 ;
			bb.setBorder(null);
			
			bb.setBackground(Color.GRAY);
			bb.setBounds(800,jj,500,50);

			dragon.f.add(bb);
			bb.addActionListener(this);
		}
		
		
		
	}


	

	public void actionPerformed(ActionEvent e) {
		for (int j = 0; j < da.length; j++) {
			
		
		if(e.getActionCommand().equals(da[j].toString()))
		{
			g.getPlayer().chooseWish(da[j]);
			break ;
		}
	}
		JOptionPane.showMessageDialog(null, "You Have Choosed A Wish");
		dragon.dispose();
		ben.world.setVisible(true);
		ben.world.updateLevel(ben);
		
	}
}
