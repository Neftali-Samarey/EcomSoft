package edu.csi.csc330.finalLab;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.SystemColor;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 

public class MainInterface extends JFrame {

	private JPanel contentPane;
	static JFrame frame;
	private String username;
	private String password;
	JPanel overlayPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface frame = new MainInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 *
	 */
	
	public void alertMessage(String errorType, String errorDescription) {
		
		JDialog d = new JDialog(frame, errorType, true);
		d.getContentPane().setLayout(new FlowLayout());
		d.setSize(400, 200);
		d.getContentPane().add(new JLabel(errorDescription));
		//d.add(new JButton("Dismiss"));
		
	    d.setLocationRelativeTo(overlayPanel);
	    d.setVisible(true);
	}
	
	
	public MainInterface() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0)); /* top, right, bottom, left padding like effect*/
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// Overlay panel for the main program interface
		Panel panel = new Panel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setPreferredSize(new Dimension(400, 250));
		panel.setLayout(null);
		ImagePanel imageview = new ImagePanel();
		imageview.setBounds(173, 61, 450, 130);
		FlowLayout flowLayout = (FlowLayout) imageview.getLayout();
		imageview.setPreferredSize(new Dimension(450, 130));
		imageview.setOpaque(false); 
		panel.add(imageview);
		//panel.add(new JLabel("Test"));
		
		
		contentPane.add(panel, BorderLayout.NORTH);
		
		
		
		
	
		//Key: Creating a new view for the controls to be in place with. This will be the overlaying panel
		overlayPanel.setBackground(Color.WHITE);
		SpringLayout sl_overlayPanel = new SpringLayout();
		overlayPanel.setLayout(sl_overlayPanel);
		overlayPanel.setPreferredSize(new Dimension(150, 150));
		
		
		contentPane.add(overlayPanel, BorderLayout.CENTER);
		
		
		// UI Controls
		JLabel usernameLabel = new JLabel("Username");
		JTextField usernameField = new JTextField(20);
		sl_overlayPanel.putConstraint(SpringLayout.WEST, usernameField, 327, SpringLayout.WEST, overlayPanel);
		sl_overlayPanel.putConstraint(SpringLayout.EAST, usernameField, -238, SpringLayout.EAST, overlayPanel);
		sl_overlayPanel.putConstraint(SpringLayout.NORTH, usernameLabel, 5, SpringLayout.NORTH, usernameField);
		sl_overlayPanel.putConstraint(SpringLayout.EAST, usernameLabel, -21, SpringLayout.WEST, usernameField);
		sl_overlayPanel.putConstraint(SpringLayout.NORTH, usernameField, 49, SpringLayout.NORTH, overlayPanel);
		usernameLabel.setLabelFor(usernameField);
		
		JLabel passwordLabel = new JLabel("Password");
		sl_overlayPanel.putConstraint(SpringLayout.WEST, passwordLabel, 0, SpringLayout.WEST, usernameLabel);
		JPasswordField passwordField = new JPasswordField(20);
		sl_overlayPanel.putConstraint(SpringLayout.NORTH, passwordField, 8, SpringLayout.SOUTH, usernameField);
		sl_overlayPanel.putConstraint(SpringLayout.WEST, passwordField, 24, SpringLayout.EAST, passwordLabel);
		sl_overlayPanel.putConstraint(SpringLayout.EAST, passwordField, -238, SpringLayout.EAST, overlayPanel);
		sl_overlayPanel.putConstraint(SpringLayout.NORTH, passwordLabel, 5, SpringLayout.NORTH, passwordField);
		passwordLabel.setLabelFor(passwordField);
		
	
		overlayPanel.add(usernameLabel);
		overlayPanel.add(usernameField);
		overlayPanel.add(passwordLabel);
		overlayPanel.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		sl_overlayPanel.putConstraint(SpringLayout.NORTH, btnLogin, 31, SpringLayout.SOUTH, passwordField);
		sl_overlayPanel.putConstraint(SpringLayout.WEST, btnLogin, 248, SpringLayout.WEST, overlayPanel);
		btnLogin.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			username = usernameField.getText();
			password = passwordField.getText();
			login(username, password);
//		    JDialog d = new JDialog(frame, "Hello", true);
//		    d.setLocationRelativeTo(overlayPanel);
//		    d.setVisible(true);
		  }
		});
		overlayPanel.add(btnLogin);
		
		JButton button = new JButton("Register");
		sl_overlayPanel.putConstraint(SpringLayout.EAST, btnLogin, -12, SpringLayout.WEST, button);
		sl_overlayPanel.putConstraint(SpringLayout.WEST, button, -151, SpringLayout.EAST, usernameField);
		sl_overlayPanel.putConstraint(SpringLayout.NORTH, button, 31, SpringLayout.SOUTH, passwordField);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alertMessage("INVITE ONLY REGRISTATION", "Note: Your supervisor will send you a regirstration link here");
			}
		});
		sl_overlayPanel.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, usernameField);
		overlayPanel.add(button);
		
		JLabel lblNewLabel = new JLabel("Designed and Developed by Neftali Samarey");
		sl_overlayPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 35, SpringLayout.WEST, usernameLabel);
		sl_overlayPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -10, SpringLayout.SOUTH, overlayPanel);
		sl_overlayPanel.putConstraint(SpringLayout.EAST, lblNewLabel, -203, SpringLayout.EAST, overlayPanel);
		overlayPanel.add(lblNewLabel);

	}
	
	
	/* Needs access to a database for credential login */
	
	public void login(String username, String password) {
		
		// Temp login credentials for now
		final String usr = "Anthony";
		final String pw = "csc330";
		
		this.username = username;
		this.password = password;
		
		if (this.username.equals(usr) && this.password.equals(pw)) {
			// Access granted
			System.out.println("ACCESS GRANTED: Recieved both username with: " + username + "and password with " + password );
			this.didCallMainInterface();
			MainInterface.this.dispose(); 
		} else  {
			System.out.print("Please check your login credentials");
			this.alertMessage("Login Error", "Please check login credentials and try again");
		}
	
	}
	
	
	// Call the secondary interface
	public boolean didCallMainInterface() {
		DashboardControllerView dashboard = new DashboardControllerView();
		dashboard.setVisible(true);
		return true;
	}
}
