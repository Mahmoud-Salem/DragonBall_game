package dragonball.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import dragonball.model.attack.Attack;
import dragonball.model.attack.PhysicalAttack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.cell.Collectible;
import dragonball.model.character.NonPlayableCharacter;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.dragon.Dragon;
import dragonball.model.exceptions.AlreadyTransformedException;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.exceptions.NotEnoughSenzuBeansException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.view.BattleView;
import dragonball.view.WorldView;
import jdk.nashorn.internal.scripts.JO;

public class BattleGUI implements GameListener, ActionListener {
	
	BattleView v ;
	WorldGUI x ;
	Game g ;
	Battle battle ;
	JTextArea text ;
	JTextArea textF ;
	JTextArea textH ;
	JTextArea TT ; 
	public BattleGUI(BattleView v , WorldGUI x ,Game g , Battle battle) {
		this.v =v ;
		this.x = x;
		this.g =g ;
		this.battle = battle ;
		g.setListener(this);
		if(((NonPlayableFighter) battle.getFoe()).isStrong())
		{
			JLabel ii= new JLabel(new ImageIcon(getClass().getResource("00.gif")));
			ii.setBounds(1400,600,250,250);

			
			v.w.add(ii);
			
		}
		else
		{
			JLabel ii= new JLabel(new ImageIcon(getClass().getResource("ssb.gif")));
			ii.setBounds(1400,600,250,250);

			
			v.w.add(ii);
			
		}
		
		
		 text = new JTextArea();
		 TT = new JTextArea(); 
		 textF = new JTextArea();
		 textH = new JTextArea() ;
		text.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		text.setEditable(false);
		TT.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		TT.setEditable(false);
		TT.setOpaque(false);
		TT.setBounds(850,500,400,400);
		v.w.add(TT);
		textF.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		textH.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		textF.setEditable(false);
		
		textH.setEditable(false);

		text.setOpaque(false);
		textF.setOpaque(false);
		textH.setOpaque(false);
		text.setBounds(0,0,400,200);
		v.w.add(text);
		textF.setBounds(1500,0,400,200);
		textH.setBounds(850,0,400,200);
		v.w.add(textF);
		v.w.add(textH);
		
		JButton b=  new JButton("Attack");
		b.setBackground(Color.GRAY);
		JButton c= new JButton("Block");
		c.setBackground(Color.GRAY);
		JButton d= new JButton("USE");
		d.setBackground(Color.GRAY);
		b.setBounds(0, 400, 200, 100);
		c.setBounds(0,500,200,100);
		d.setBounds(0,600,200,100);
		v.w.add(b);
		v.w.add(c);
		v.w.add(d);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		

		
		
	//	System.out.println(battle.getAttacker());
	//	System.out.println(battle.getDefender());
		
		
		
		
		
		
	}
	public void updateState (String f)
	{
		TT.setText(f);
		
	}
	
	public void update (String e)
	{
	if(g.getPlayer().getActiveFighter() instanceof Saiyan){
	text.setText(g.getPlayer().getActiveFighter().getName()+" :"+g.getPlayer().getActiveFighter().getHealthPoints()+"/"+g.getPlayer().getActiveFighter().getMaxHealthPoints()+" \n"+"Stamina :"+g.getPlayer().getActiveFighter().getStamina()+"/"+g.getPlayer().getActiveFighter().getMaxStamina()+"\nKi :"+g.getPlayer().getActiveFighter().getKi()+"/"+g.getPlayer().getActiveFighter().getMaxKi()+"\nSuper Saiyan : "+((Saiyan) g.getPlayer().getActiveFighter()).isTransformed()+"\nLevel : "+g.getPlayer().getActiveFighter().getLevel());
	}
	else {
		text.setText(g.getPlayer().getActiveFighter().getName()+" :"+g.getPlayer().getActiveFighter().getHealthPoints()+"/"+g.getPlayer().getActiveFighter().getMaxHealthPoints()+" \n"+"Stamina :"+g.getPlayer().getActiveFighter().getStamina()+"/"+g.getPlayer().getActiveFighter().getMaxStamina()+"\nKi :"+g.getPlayer().getActiveFighter().getKi()+"/"+g.getPlayer().getActiveFighter().getMaxKi()+"\nLevel : "+g.getPlayer().getActiveFighter().getLevel());	
	}
	if(battle.getFoe() instanceof Saiyan){
	textF.setText(((Fighter) battle.getFoe()).getName()+" :"+((Fighter) battle.getFoe()).getHealthPoints()+"/"+((Fighter) battle.getFoe()).getMaxHealthPoints()+" \n"+"Stamina :"+((Fighter) battle.getFoe()).getStamina()+"/"+((Fighter) battle.getFoe()).getMaxStamina()+"\nKi :"+((Fighter) battle.getFoe()).getKi()+"/"+((Fighter) battle.getFoe()).getMaxKi()+"\nSuper Saiyan : "+((Saiyan) battle.getFoe()).isTransformed()+"\nLevel : "+((Fighter) battle.getFoe()).getLevel());	
	}
	else 
	{
		textF.setText(((Fighter) battle.getFoe()).getName()+" :"+((Fighter) battle.getFoe()).getHealthPoints()+"/"+((Fighter) battle.getFoe()).getMaxHealthPoints()+" \n"+"Stamina :"+((Fighter) battle.getFoe()).getStamina()+"/"+((Fighter) battle.getFoe()).getMaxStamina()+"\nKi :"+((Fighter) battle.getFoe()).getKi()+"/"+((Fighter) battle.getFoe()).getMaxKi()+"\nLevel : "+((Fighter) battle.getFoe()).getLevel());	

	}
	if(battle.getAttacker()==battle.getMe())
	textH.setText(e);
	else textH.setText(e);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateState("");

		
		
		if(battle.getAttacker().equals(battle.getMe()))
		{
		
		if(e.getActionCommand().equals("Block"))
		{
			updateState("Block");
			
			battle.block();
			
			
		}
		else if(e.getActionCommand().equals("Attack"))
		{
			try {
				
			ArrayList<Attack> xx= 	battle.getAssignedAttacks();
		//	System.out.println(battle.getAssignedAttacks().get(0).getName());
		//	int x= (int) (Math.random()*xx.size());
			Attack [] fff = new Attack[xx.size()];
			String [] sss= new String [xx.size()];
			for (int i = 0; i < fff.length; i++) {
				fff[i]=xx.get(i);
				sss[i] = fff[i].getName();
			}
int xxx=JOptionPane.showOptionDialog(null, "Which Attack", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sss, null);
			
			
			
				updateState("Attack");
				battle.attack(fff[xxx]);
				
			} catch (NotEnoughKiException e1) {
				// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "No Enough Ki");
			} catch (AlreadyTransformedException e1) {
				JOptionPane.showMessageDialog(null, "Already Transformed");
			//	e1.printStackTrace();
			}
			
		}
		else if(e.getActionCommand().equals("USE")) {
			try {
				updateState("Use");
				battle.use(g.getPlayer(), Collectible.SENZU_BEAN);
				
			} catch (NotEnoughSenzuBeansException e1) {
				JOptionPane.showMessageDialog(null, "No Enough Senzu Beans");
				//e1.printStackTrace();
			}
			 
			
		}}
		
		
		
		
	}

	@Override
	public void onDragonCalled(Dragon dragon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCollectibleFound(Collectible collectible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBattleEvent(BattleEvent e)  {
		
	
		if(e.getType().equals(e.getType().NEW_TURN) && battle.getAttacker().equals(battle.getMe()))
		{
			
						

				 		} 
		if(e.getType().equals(e.getType().NEW_TURN) && battle.getAttacker().equals(battle.getFoe()))
		{
			
			//	update();
			Timer t = new Timer();
			
			
					  
					  t.schedule(new TimerTask() {
					  @Override
						  public void run() {
							  update("Foe Turn");
							updateState("");

						  }
						}, 1000);
					
					  battle.play();
					  if(((Fighter) battle.getMe()).getHealthPoints() != 0){
					  t.schedule(new TimerTask() {
						  @Override
						  public void run() {
							  
							  update("Foe Turn");
								updateState(battle.vv);


						  }
						}, 1500);
				
					t.schedule(new TimerTask() {
						  @Override
						  public void run() {
							  
								update("My Turn");

								updateState("");

						  }
						}, 2000);

				  }}
	
			
			
			
		
		//	battle.play();
			
			

		//	update();
			
		
		if(e.getType().equals(e.getType().ENDED))
		{
			Timer t = new Timer();
			x.world.updateLevel(x);
			if(e.getWinner().equals(e.getBattle().getMe())){
				
		//	JOptionPane.showMessageDialog(null, "You have Won");
			
			TT.setText("WINNER");
			  update(" ");

			 t.schedule(new TimerTask() {
				  @Override
				  public void run() {
					  
					  v.dispose();
						x.world.setVisible(true);
						g.setListener(x);
						JOptionPane.showMessageDialog(null, "Your Xp is "+g.getPlayer().getActiveFighter().getXp()+"  Your Level "+g.getPlayer().getActiveFighter().getLevel());
						if(((NonPlayableFighter) e.getBattle().getFoe()).isStrong())
						{
							x.world.a[x.world.x][x.world.y].setIcon(new ImageIcon(getClass().getResource("ssa.jpg")));
							x.world.a[x.world.x][x.world.y].remove(x.world.level);
							
							x.world.x=9 ;
							x.world.y=9 ;
						
						
							x.world.a[x.world.x][x.world.y].setIcon(new ImageIcon(getClass().getResource("gokuss.png")));
							x.world.a[x.world.x][x.world.y].add(x.world.level);
							JOptionPane.showMessageDialog(null, "You have Opened a New Map");
							x.world.a[0][0].setIcon(new ImageIcon(getClass().getResource("vegeta.gif")));
							
							
						}


				  }
				}, 3000);
			
			}
			else {
			//	JOptionPane.showMessageDialog(null, "You have Lost");
				
				
				 t.schedule(new TimerTask() {
					  @Override
						  public void run() {
						  TT.setText("LOSER");
						  update(" ");

						  }
						}, 1100);
						 
					
				t.schedule(new TimerTask() {
					  @Override
					  public void run() {
							v.dispose();
							x.world.setVisible(true);
							g.setListener(x);
							
							if(((NonPlayableFighter) e.getBattle().getFoe()).isStrong())
							{
							
								x.world.a[x.world.x][x.world.y].setIcon(new ImageIcon(getClass().getResource("vegeta.gif")));
								x.world.a[x.world.x][x.world.y].remove(x.world.level);
							}
							else {
							x.world.a[x.world.x][x.world.y].setIcon(new ImageIcon(getClass().getResource("ssa.jpg")));
							x.world.a[x.world.x][x.world.y].remove(x.world.level); }
							
							x.world.x = g.getWorld().getPlayerColumn();
							x.world.y = g.getWorld().getPlayerRow();
						
						
							x.world.a[x.world.x][x.world.y].setIcon(new ImageIcon(getClass().getResource("gokuss.png")));
							x.world.a[x.world.x][x.world.y].add(x.world.level);
							
							
							
					  }
					}, 3000); }

				
				
				
				
				
			}
		}}
	
		
		
		
	


