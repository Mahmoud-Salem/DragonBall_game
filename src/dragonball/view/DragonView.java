package dragonball.view;

import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DragonView extends JFrame {
	
	public JLabel f ;

	public DragonView()  {
		
		super();
		setVisible(true);
		WindowDestroyer myListener = new WindowDestroyer();
		super.addWindowListener(myListener);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new GridBagLayout());
		ImageIcon bew = new ImageIcon(getClass().getResource("nos7y.jpg"));
		f= new JLabel(bew);
		add(f);
		
		
	}


}
