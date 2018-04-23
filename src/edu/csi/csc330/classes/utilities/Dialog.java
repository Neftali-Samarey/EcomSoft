package edu.csi.csc330.classes.utilities;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Dialog {
	
	static JFrame frame;
	
	public Dialog(String dialogTypeString) {
		
		JDialog d = new JDialog(frame, dialogTypeString, true);
		d.getContentPane().setLayout(new FlowLayout());
		d.setSize(400, 200);
		//d.getContentPane().add(new JLabel(errorDescription));
		//d.add(new JButton("Dismiss"));
		
	    d.setLocationRelativeTo(null);
	    d.setVisible(true);
	}
	
	// Look for a way to add the panel to a given position of the window
	
}
