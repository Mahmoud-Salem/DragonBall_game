package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import dragonball.model.attack.Attack;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.dragon.Dragon;
import dragonball.model.exceptions.DuplicateAttackException;
import dragonball.model.exceptions.MaximumAttacksLearnedException;
import dragonball.model.exceptions.NotASaiyanException;
import dragonball.model.exceptions.NotEnoughAbilityPointsException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.view.BattleView;
import dragonball.view.WorldView;
import jdk.nashorn.internal.scripts.JO;

public class WorldGUI implements ActionListener ,GameListener {
	public Game game ;
	WorldView world ;
	

	public WorldGUI(Game g, WorldView v) {
		world =v ;
		game= g;
//		g.getPlayer().setDragonBalls(6);
		game.setListener(this);
	//	System.out.println(game.getWorld());
		
		ImageIcon f = new ImageIcon(getClass().getResource("ssa.jpg"));
		world.updateLevel(this);
		
	for (int i = 0; i < 10; i++) {
			
			for (int j1 = 0; j1 < 10; j1++) {
				
				world.a[i][j1] = new JButton();
				//System.out.println(12);

				world.a[i][j1].setIcon(f);
			//	a[i][j1].setBackground(Color.green);
				world.a[i][j1].setBorder(null);
				world.jpanel.add(world.a[i][j1]);
				world.a[i][j1].addActionListener(this); 
				if(i==0 && j1 ==0)
				{
					world.a[i][j1].setIcon(new ImageIcon(getClass().getResource("vegeta.gif")));
					world.a[i][j1].setBorder(null);
				}
				
				if(i==world.y &&j1== world.x)
				{
					world.a[i][j1].setIcon(new ImageIcon(getClass().getResource("gokuss.png")));
					
					
					
					world.x =i ;
					world.y = j1 ;
					world.a[i][j1].setBorder(null);
					world.a[i][j1].add(world.level);
				
					world.jpanel.add(world.a[i][j1]);
				}
				
				
				
				
				
			}
		}
	// world.a[0][9].add(world.jlevel);
		
	

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		int f =0 ;
		int k =0 ;
		

		for (int i = 0; i < world.a.length; i++) {
			for (int j = 0; j < world.a.length; j++) {
				if(world.a[i][j]==((JButton)e.getSource()))
				{
					f=i;
					k=j;
				}
			}
		}
		
		if((f!=world.x && k!=world.y)){
			
			
		//	JOptionPane.showMessageDialog(null, "You Cannot make This Move");
		
		
		}
		else if( f==world.x && k ==world.y)
		{
String x[]= {"Create new Fighter","Upgrade active fighter","switch to another active fighter","Assign Attack to this Fighter","Save"};
			
			int ddd= JOptionPane.showOptionDialog(world, "Options", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, x, null);
			 if(ddd==0)
			{
				String lll= JOptionPane.showInputDialog("Enter your new Fighter name");
				String [] a = {"Saiyan","Frieza","Namekian","Earthling","Majin"};
				
			
				int bb= JOptionPane.showOptionDialog(null, "What Race do you want ?!", "Choose Race" , JOptionPane.DEFAULT_OPTION , JOptionPane.INFORMATION_MESSAGE, null, a, null);
				if(bb==0)
				{
					game.getPlayer().createFighter('s', lll);
				}
				else if(bb==1)
				{
					game.getPlayer().createFighter('f', lll);
				}else if(bb==2)
				{
					game.getPlayer().createFighter('n', lll);
				}else if(bb==3)
				{
					game.getPlayer().createFighter('e', lll);
				}
				else {
					game.getPlayer().createFighter('m', lll);
				}
				
			} else if(ddd==1)
			{
				String [] ppp = {"Health by 50 ","Blast Damage  by 50","Physical Damage  by 50","Ki by 1","Stamina by 1"};
int ff = JOptionPane.showOptionDialog(world, "What attributes you want ?!", "", JOptionPane.DEFAULT_OPTION , JOptionPane.INFORMATION_MESSAGE, null, ppp, null);
				
						if(ff==0)
						{
							try {
								game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'H');
							} catch (NotEnoughAbilityPointsException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "You don't have enough Ability Points");
							}
						}
						if(ff==1)
						{
							try {
								game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(),'B' );
							} catch (NotEnoughAbilityPointsException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, "You don't have enough Ability Points");							}
						}
						if(ff==2)
						{
							try {
								game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(),'P' );
							} catch (NotEnoughAbilityPointsException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, "You don't have enough Ability Points");							}
						}
						if(ff==3)
						{try {
							game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(),'K' );
						} catch (NotEnoughAbilityPointsException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "You don't have enough Ability Points");						}
							
						}
						if(ff==4)
						{try {
							game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(),'S' );
						} catch (NotEnoughAbilityPointsException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "You don't have enough Ability Points");						}
							
						}
						world.updateLevel(this);
						
			}
			else if(ddd==2){
				
				ArrayList<PlayableFighter> sss= game.getPlayer().getFighters();
				int s = sss.size();
				String ffff []= new String[s];

				PlayableFighter [] pppp = new PlayableFighter[s];
				for (int i = 0; i <s; i++) {
					pppp[i]=sss.get(i);
					ffff[i]=pppp[i].getName();
				}
			
				
int fff = JOptionPane.showOptionDialog(null, "Which Fighter you want ?!", "", JOptionPane.DEFAULT_OPTION , JOptionPane.INFORMATION_MESSAGE, null, ffff, null);
			game.getPlayer().setActiveFighter(pppp[fff]);	
			world.updateLevel(this);
				
			}
			else if(ddd==3)
			{      
			String[]pew = {"Super","Ultimate"};	
			int type = JOptionPane.showOptionDialog(world, "Super or Ultimate", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,pew,null);
			
			
				if(type ==0)
				{
					ArrayList<SuperAttack> xx= game.getPlayer().getSuperAttacks();
					if(xx.size()==0)
					{
						JOptionPane.showMessageDialog(null, "There is No Super Attacks");
					}
				//	xx.addAll(game.getPlayer().getUltimateAttacks());
					
				//	int ffff= (int) (Math.random()*xx.size());
					else {
					SuperAttack [] fff = new SuperAttack[xx.size()];
					String [] sss= new String [xx.size()];
					for (int i = 0; i < fff.length; i++) {
						fff[i]=xx.get(i);
						sss[i] = fff[i].getName();  }
						int xxx=JOptionPane.showOptionDialog(world, "Which Attack", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sss, null);
					int salem =	JOptionPane.showOptionDialog(null, "Do you want to Remove another one ?", null, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
						if(salem==JOptionPane.YES_OPTION){
							ArrayList<SuperAttack> bes= game.getPlayer().getActiveFighter().getSuperAttacks();
							if(bes.size()==0)
							{
								JOptionPane.showMessageDialog(null, "Do Not Have Any Super Attacks");
							}else {
							SuperAttack [] bess = new SuperAttack[bes.size()];
							String [] besss= new String [bes.size()];
							for (int i = 0; i < bess.length; i++) {
								bess[i]=bes.get(i);
								besss[i] = bess[i].getName();  }
				int bomb = JOptionPane.showOptionDialog(world, "Which Attack", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, besss, null);
				try {
					game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), fff[xxx], bess[bomb]);
				} catch (MaximumAttacksLearnedException | DuplicateAttackException | NotASaiyanException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}}
			
							
						}else {
						try {
							game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), fff[xxx], null);
						} catch (MaximumAttacksLearnedException | DuplicateAttackException | NotASaiyanException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
							e1.printStackTrace();
						}}}}
					else 
					{
						ArrayList<UltimateAttack> xx= game.getPlayer().getUltimateAttacks();
						if(xx.size()==0)
						{
							JOptionPane.showMessageDialog(null, "There is No Ultimate Attacks");
						}
						//	xx.addAll(game.getPlayer().getUltimateAttacks());
							
						//	int ffff= (int) (Math.random()*xx.size());
						else {
							UltimateAttack [] fff = new UltimateAttack[xx.size()];
							String [] sss= new String [xx.size()];
							for (int i = 0; i < fff.length; i++) {
								fff[i]=xx.get(i);
								sss[i] = fff[i].getName(); }
								int xxx=JOptionPane.showOptionDialog(null, "Which Attack", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sss, null);
								int salem =	JOptionPane.showOptionDialog(null, "Do you want to Remove another one ?", null, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
								
								if(salem==JOptionPane.YES_OPTION)
								{ 
									ArrayList<UltimateAttack> bes= game.getPlayer().getActiveFighter().getUltimateAttacks();
									if(bes.size()==0)
									{
								JOptionPane.showMessageDialog(null, "Do Not Have Any Ultimate Attacks");	
									}else {
									UltimateAttack [] bess = new UltimateAttack[bes.size()];
									String [] besss= new String [bes.size()];
									for (int i = 0; i < bess.length; i++) {
										bess[i]=bes.get(i);
										besss[i] = bess[i].getName();  }
						int bomb = JOptionPane.showOptionDialog(world, "Which Attack", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, besss, null);
						try {
							game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), fff[xxx], bess[bomb]);
						} catch (MaximumAttacksLearnedException | DuplicateAttackException | NotASaiyanException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
							e1.printStackTrace();}
						
									}
								}
								else {try {
									game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), fff[xxx], null);
								} catch (MaximumAttacksLearnedException | DuplicateAttackException | NotASaiyanException e1) {
									JOptionPane.showMessageDialog(null, e1.getMessage());
									e1.printStackTrace();
								}}}}
					}
			else if(ddd==4) {
				String pop =JOptionPane.showInputDialog("Enter save name ");
				try {
					game.save(pop);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						world.a[i][j].setBorder(null);
					}
				}
			}
						
					
		}
		
		else if(f==world.x+1 ||f==world.x-1 || k==world.y-1 || k==world.y+1){
			if(f==world.x-1)
			{
			//	System.out.println(0);
				game.getWorld().moveUp();
			}
			else if(f==world.x+1)
			{
			//	System.out.println(2);
				game.getWorld().moveDown();
			}
			else if(k==world.y-1)
			{
				//System.out.println(3);
				game.getWorld().moveLeft();
			}
			else if(k==world.y+1)
			{
			//	System.out.println(4);
				game.getWorld().moveRight();
			}
			world.updateLevel(this);

			
			
		//	System.out.println(game.getWorld().getMap()[game.getWorld().getPlayerRow()][game.getWorld().getPlayerColumn()]);
			world.a[world.x][world.y].setIcon(new ImageIcon(getClass().getResource("ssa.jpg")));
			world.a[world.x][world.y].remove(world.level);
			
			world.x=f ;
			world.y=k ;
		
		
			world.a[world.x][world.y].setIcon(new ImageIcon(getClass().getResource("gokuss.png")));
			world.a[world.x][world.y].add(world.level);
			
		
		
		

		
	}
		
		
		
	}


	@Override
	public void onDragonCalled(Dragon dragon) {
		
		DragonGUI ff = new DragonGUI(game,dragon,this);
		world.setVisible(false);
		
		
		
	}


	@Override
	public void onCollectibleFound(Collectible collectible) {
		
		if(collectible.equals(Collectible.DRAGON_BALL)){
		JOptionPane.showMessageDialog(null, "You have found a Dragon Ball !!");
		
		if(game.getPlayer().getDragonBalls()==7)
		{
			JOptionPane.showMessageDialog(null, "You Have Collected 7 Dragon Balls , A Dragon Will appear to grant your wish");
							
			
			
		}
		
		
		}
		else 
			JOptionPane.showMessageDialog(null, "You have Found a Senzu Beans !!");
	}


	@Override
	public void onBattleEvent(BattleEvent e) {
		
		if(e.getType().equals(e.getType().STARTED))
		{
			JOptionPane.showMessageDialog(null, "You Have Encountered A Foe");
			BattleView h = new BattleView();
		//	System.out.println(e.getBattle().getAttacker());
		//	System.out.println(e.getBattle().getDefender());
			//System.out.println(((Fighter) e.getBattle().getFoe()).getHealthPoints());
			BattleGUI g = new BattleGUI(h,this,game, e.getBattle());
			world.setVisible(false);
			
			g.update("My Turn");
		}
		
	}

}
