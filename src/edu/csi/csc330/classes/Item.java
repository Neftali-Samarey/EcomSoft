package edu.csi.csc330.classes;

import java.text.NumberFormat;

public class Item {
	
	private String itemImagePath;
	private String itemName;
	private String itemSKU;
	private double itemPrice;
	private int quantity;
	private boolean outOfStock;
	
	
	public Item() {
		
		
		System.out.println("Item being created");
	}
	
	// Constructor
	public Item(String productName, String productSku, double productPrice, int productQty) {
		
		// Handle empty fields
		if (productName == null) {
			this.itemName = "untitled";
		} else {
			this.itemName = productName;
		}
		
		this.itemSKU = productSku;
		this.itemPrice = productPrice;
		this.quantity = productQty;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Methods
	
	public void setItemName(String productName) {
		
		if (productName.isEmpty()) {
			this.itemName = "untitled item";
		} else {
			this.itemName = productName;
		}
	}
	
	public void setItemPrice(String productPrice) {
		//String fomrattedString = formatInputItemCost(productPrice);
		double finalres = Double.parseDouble(productPrice);
		this.itemPrice = finalres;
	}
	
	
	// getters (testing)
	public  String getProductDetails() {
		String itemData = "Item: " + this.itemName + ", Price: $" + this.itemPrice;
		return itemData;
	}
	
	
	// Format the input double string
	private String formatInputItemCost(String inputMoney) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String conversion = formatter.format(inputMoney);
		return conversion;
	}
	
	
	

}
