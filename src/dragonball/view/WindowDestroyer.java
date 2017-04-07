package dragonball.view;

import javax.swing.*;
import java.awt.event.*;
public class WindowDestroyer extends WindowAdapter {
public void windowClosing(WindowEvent e) {
	
JOptionPane.showMessageDialog(null, "The Game Will Close");
System.exit(0); } }