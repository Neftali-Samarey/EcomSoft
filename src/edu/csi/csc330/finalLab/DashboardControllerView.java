package edu.csi.csc330.finalLab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import edu.csi.csc330.classes.utilities.ItemDialog;
import edu.csi.csc330.classes.views.AddItemController;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;



public class DashboardControllerView extends JFrame {
	
	
	// temporary array of all the products
	
	
	
	
	String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian" };

	private JPanel contentPane;
	JPanel dashboard = new JPanel();
	JPanel connectionLight = new JPanel();
	private final JButton btnNewItem = new JButton("New Item");
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardControllerView frame = new DashboardControllerView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DashboardControllerView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//this.enableTopWindowComponents();
		
		
		dashboard.setBackground(Color.WHITE);
		SpringLayout sl_overlayPanel = new SpringLayout();
		sl_overlayPanel.putConstraint(SpringLayout.EAST, btnNewItem, 0, SpringLayout.EAST, connectionLight);
		dashboard.setLayout(sl_overlayPanel);
		dashboard.setPreferredSize(new Dimension(150, 150));
		
		
		contentPane.add(dashboard, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		
		sl_overlayPanel.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, dashboard);
		sl_overlayPanel.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, dashboard);
		sl_overlayPanel.putConstraint(SpringLayout.SOUTH, panel, 60, SpringLayout.NORTH, dashboard);
		sl_overlayPanel.putConstraint(SpringLayout.EAST, panel, 960, SpringLayout.WEST, dashboard);
		dashboard.add(panel);
		
		JLabel lblNewLabel = new JLabel("Connection Status");
		sl_overlayPanel.putConstraint(SpringLayout.NORTH, btnNewItem, 19, SpringLayout.SOUTH, lblNewLabel);
		sl_overlayPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 14, SpringLayout.SOUTH, panel);
		sl_overlayPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 765, SpringLayout.WEST, dashboard);
		sl_overlayPanel.putConstraint(SpringLayout.EAST, lblNewLabel, -75, SpringLayout.EAST, dashboard);
		dashboard.add(lblNewLabel);
		
		
		
		if (isStatusOnline()) {
			connectionLight.setBackground(new Color(50, 205, 50));
		} else {
			connectionLight.setBackground(new Color(204, 0, 0));
		}
		
		sl_overlayPanel.putConstraint(SpringLayout.NORTH, connectionLight, 20, SpringLayout.SOUTH, panel);
		sl_overlayPanel.putConstraint(SpringLayout.WEST, connectionLight, 6, SpringLayout.EAST, lblNewLabel);
		sl_overlayPanel.putConstraint(SpringLayout.SOUTH, connectionLight, 0, SpringLayout.SOUTH, lblNewLabel);
		sl_overlayPanel.putConstraint(SpringLayout.EAST, connectionLight, 16, SpringLayout.EAST, lblNewLabel);
		dashboard.add(connectionLight);
		btnNewItem.setForeground(new Color(0, 0, 0));
		btnNewItem.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e){

			//  ItemDialog newItem = new ItemDialog("New Item");
			  AddItemController itemControllerView = new AddItemController();
			  itemControllerView.setVisible(true);
			  itemControllerView.setLocationRelativeTo(null);
		  }
		});
		dashboard.add(btnNewItem);
		
		table = new JTable();
		sl_overlayPanel.putConstraint(SpringLayout.NORTH, table, 32, SpringLayout.SOUTH, btnNewItem);
		sl_overlayPanel.putConstraint(SpringLayout.WEST, table, 37, SpringLayout.WEST, dashboard);
		sl_overlayPanel.putConstraint(SpringLayout.SOUTH, table, -23, SpringLayout.SOUTH, dashboard);
		sl_overlayPanel.putConstraint(SpringLayout.EAST, table, -48, SpringLayout.EAST, dashboard);
		dashboard.add(table);
		
		this.enableTable();
		
	}
	
	private void enableTopWindowComponents() {
		
		JPanel overlayWindow = new JPanel();
		overlayWindow.setBackground(Color.white);
		
		getContentPane().add(overlayWindow);
		
		// Secondary
		 JPanel overlayTop = new JPanel();
		 overlayTop.setBackground(SystemColor.controlHighlight);
		 overlayTop.setPreferredSize(new Dimension(1000, 110));

		 overlayWindow.add(overlayTop);
	}
	
	private void enableTable() {
	}
	
	private void enableDashboardComponents() {
		
		dashboard.setBackground(Color.CYAN);
		SpringLayout sl_overlayPanel = new SpringLayout();
		dashboard.setLayout(sl_overlayPanel);
		
		contentPane.add(dashboard);
	}
	
	private boolean isStatusOnline() {
		int status = 0;
		if (status == 1) {
			return true;
		} else 
			return false;
	}
}
