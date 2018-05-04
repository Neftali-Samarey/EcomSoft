package edu.csi.csc330.finalLab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import edu.csi.csc330.classes.Item;
import edu.csi.csc330.classes.connection.MySQLConnection;
import edu.csi.csc330.classes.utilities.ItemDialog;
import edu.csi.csc330.classes.views.AddItemController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.*;


public class DashboardControllerView extends JFrame {
	
	
	// Test
	private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String CONNECTION = "jdbc:mysql://localhost:3306/demo";
	
	
	// temporary array of all the products
    private Object[][] productData;

    private static List<Item> list = new ArrayList<>();
    private static Item item = new Item();
    static DefaultTableModel model = new DefaultTableModel();
    
  

	private JPanel contentPane;
	JPanel dashboard = new JPanel();
	JPanel connectionLight = new JPanel();
	private final JButton btnNewItem = new JButton("New Item");
	private JTable table;
	private JScrollPane scrollPane;
//	DefaultTableModel model;
	
	 	

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
	
	// Connection
	Connection connection = null;
	private JLabel lblAdminPanel;
	
	
	 public void initiateConnection() throws SQLException {
		 
		connection = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
		System.out.println("Connection Successful");
	}
	 
	 // Secondary connection
	 private void connectDb() {
		 try {
			   //connection to database
			   Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/demo", "root", "root");
			  // String connectionString = "jdbc:mysql://localhost:3306/my_database?user=root&root=Pass&useUnicode=true&characterEncoding=UTF-8";
			   
			   //create statement 
			   Statement myStmt = myConn.createStatement();
			   
			   //execute sql query
			   ResultSet myRs = myStmt.executeQuery("SELECT * FROM `Person`");
			   
			   //results set
			   while (myRs.next()) {
			  //  System.out.println(myRs.getString("Name")+ " , "+myRs.getString("email")+ " , "+myRs.getString("address"));
			   }
			  }
			  catch (Exception exc) {
			   exc.printStackTrace();
			  }
	 }
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DashboardControllerView()  {
		
		// Table Model
		
		
		
		//this.initiateConnection();
	    //this.connectDb();
		
		//MySQLConnection connect = new MySQLConnection();
		
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
		panel.setLayout(null);
		
		lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdminPanel.setForeground(new Color(255, 255, 255));
		lblAdminPanel.setBounds(18, 6, 115, 48);
		panel.add(lblAdminPanel);
		sl_overlayPanel.putConstraint(SpringLayout.WEST, connectionLight, 6, SpringLayout.EAST, lblNewLabel);
		sl_overlayPanel.putConstraint(SpringLayout.SOUTH, connectionLight, 0, SpringLayout.SOUTH, lblNewLabel);
		sl_overlayPanel.putConstraint(SpringLayout.EAST, connectionLight, 16, SpringLayout.EAST, lblNewLabel);
		dashboard.add(connectionLight);
		btnNewItem.setForeground(new Color(0, 0, 0));
		btnNewItem.addActionListener(new ActionListener(){
			
		  public void actionPerformed(ActionEvent e){

			//  ItemDialog newItem = new ItemDialog("New Item");
			
			  AddItemController itemControllerView = new AddItemController();
			 
			  itemControllerView.setVisible(true);
			  itemControllerView.setLocationRelativeTo(null);
			  DashboardControllerView.this.isChildControllerCurrentlyVisible(true);
		  }
		});
		
		dashboard.add(btnNewItem);
		
		// Initializing Table
		 Object[][] cellData = {
				 	{"BH12345", "Beanie Hat", "$12.99", true, ""}
				 	
			        };

			   
			    
			   
		// scene1 	    
		Object[][] productData = {
				{"BH12345", "Beanie Hat", "$12.99", true, ""},
		};
		
		// scene 2
		
		 String[] columnNames = {"SKU", "Product Name", "Price", "In Stock", "Edit"};
			
			
		

		table = new JTable();
		table.setRowHeight( 50);
		table.setFont(new Font("avenir", Font.BOLD, 18));
		table.getTableHeader().setFont(new Font("avenir", Font.BOLD, 22));
		
		
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		
		scrollPane = new JScrollPane( table );
		sl_overlayPanel.putConstraint(SpringLayout.NORTH, scrollPane, -516, SpringLayout.SOUTH, dashboard);
		sl_overlayPanel.putConstraint(SpringLayout.WEST, scrollPane, 25, SpringLayout.WEST, dashboard);
		sl_overlayPanel.putConstraint(SpringLayout.SOUTH, scrollPane, -56, SpringLayout.SOUTH, dashboard);
		sl_overlayPanel.putConstraint(SpringLayout.EAST, scrollPane, 924, SpringLayout.WEST, dashboard);
		dashboard.add( scrollPane, BorderLayout.CENTER );
			sl_overlayPanel.putConstraint(SpringLayout.NORTH, table, 52, SpringLayout.SOUTH, btnNewItem);
			
			JLabel lblNewLabel_1 = new JLabel("Item Count");
			sl_overlayPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 25, SpringLayout.WEST, dashboard);
			sl_overlayPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -14, SpringLayout.NORTH, scrollPane);
			sl_overlayPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 196, SpringLayout.WEST, dashboard);
			dashboard.add(lblNewLabel_1);
		
		
	    

		
		JTableHeader anHeader = table.getTableHeader();
	    anHeader.setForeground(new Color(0).black);
	    anHeader.setBackground(new Color(0).white);
	    anHeader.setPreferredSize(new Dimension(30, 30));
		
		
	

	}
	
	private boolean isChildControllerCurrentlyVisible(boolean isVisible) {
		if (isVisible) {
			System.out.println("Currently visible");
			return true;
		}
		System.out.println("Currently Not visible");
		return false;
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
	
	
	
	private void enableDashboardComponents() {
		
		dashboard.setBackground(Color.CYAN);
		SpringLayout sl_overlayPanel = new SpringLayout();
		dashboard.setLayout(sl_overlayPanel);
		
		contentPane.add(dashboard);
	}
	
	
//	private void testArray() {
//		
//		Item one = new Item();
//		one.setItemName("Pencil");;
//		productList = new ArrayList<>();
//		productList.add(one);
//		for (int i = 0; i <= productList.size(); i++) {
//			System.out.println(productList);
//		}
//		
//	}
	
	private boolean didRecieveDataUpdate() {
		System.out.println("Data recieved");
		return true;
	}
	
	private boolean isStatusOnline() {
		int status = 1;
		if (status == 1) {
			return true;
		} else 
			return false;
	}
	
	
	// Public methods
	
	
	
	
	// Add the items to the Database
	public static void addItem(String prodName, String prodSku,  String prodPrice, boolean isAvail) {
		
		//System.out.println("Listed item: " + prodName + "\n" + prodPrice + "\n" + prodSku); // reload to the JTable

//		list = new ArrayList<>();
//		item = new Item();
		
	
//		item.setItemName(prodName);
//		item.setItemPrice(prodPrice);
		item.setItemParametersWith(prodName, prodSku, prodPrice, isAvail);
		
		
		list.add(item);
		
		Object[] row = new Object[4];
		// Printing purposes
		for (Item item : list) {
			System.out.println(item.getProductDetails());
			row[0] = item.getItemName();
			row[1] = item.getItemSKU();
			row[2] = item.getItemPrice();
			row[3] = item.isAvailable();
			
			
		}
		
		System.out.println(list.size());
		
		
		model.addRow(row);
	
	}
	
	
	
}
