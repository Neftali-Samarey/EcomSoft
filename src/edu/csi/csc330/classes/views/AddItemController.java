package edu.csi.csc330.classes.views;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.csi.csc330.classes.Item;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;

public class AddItemController extends JFrame {

	private JPanel contentPane;
	private JTextField productNameField;
	private JTextField productSKUField;
	private JTextField productPriceField;
	private JTextField productQtyField;
	//private Item item = new Item();
	private Item itemObject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItemController frame = new AddItemController();
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
	public AddItemController() {
		
		// Create the object as this view is presented
		itemObject = new Item();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddItem = new JLabel("Add Item");
		lblAddItem.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAddItem.setBounds(222, 6, 100, 34);
		contentPane.add(lblAddItem);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblProductName.setBounds(6, 50, 123, 16);
		contentPane.add(lblProductName);
		
		productNameField = new JTextField();
		productNameField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		productNameField.setBounds(6, 78, 538, 37);
		contentPane.add(productNameField);
		productNameField.setColumns(10);
		
		JLabel label = new JLabel("Product SKU");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label.setBounds(6, 131, 123, 16);
		contentPane.add(label);
		
		productSKUField = new JTextField();
		productSKUField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		productSKUField.setColumns(10);
		productSKUField.setBounds(6, 159, 538, 37);
		contentPane.add(productSKUField);
		
		JLabel label_1 = new JLabel("Price ($)");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_1.setBounds(6, 208, 123, 16);
		contentPane.add(label_1);
		
		productPriceField = new JTextField();
		productPriceField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		productPriceField.setColumns(10);
		productPriceField.setBounds(6, 236, 143, 37);
		contentPane.add(productPriceField);
		
		JButton btnAddItem = new JButton("Save");
		btnAddItem.setBounds(217, 359, 117, 29);
		btnAddItem.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e){

			  itemObject.setItemName(productNameField.getText());
			  itemObject.setItemPrice(productPriceField.getText());
			  
			  System.out.println("Added Item with " + itemObject.getProductDetails());
			  
		  }
		});
		contentPane.add(btnAddItem);
		
		JLabel label_2 = new JLabel("Quanity");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_2.setBounds(175, 209, 123, 16);
		contentPane.add(label_2);
		
		JCheckBox chckbxAvailable = new JCheckBox("Available");
		chckbxAvailable.setBounds(416, 242, 128, 23);
		contentPane.add(chckbxAvailable);
		
		JLabel label_3 = new JLabel("In Stock");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_3.setBounds(421, 209, 123, 16);
		contentPane.add(label_3);
		
		productQtyField = new JTextField();
		productQtyField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		productQtyField.setColumns(10);
		productQtyField.setBounds(179, 236, 143, 37);
		contentPane.add(productQtyField);
	}
	
	
	// Addiontal methods
	public boolean didDeleteItemFromRow () {
		String itemDeleted = "indexItem";
		return true;
	}
	
}
