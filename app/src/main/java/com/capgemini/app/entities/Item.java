package com.capgemini.app.entities;

public class Item {
	
	private int itemId;
	private int productId;
	private int quantity;
	private double total;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int itemId, int productId, int quantity, double total) {
		super();
		this.itemId = itemId;
		this.productId = productId;
		this.quantity = quantity;
		this.total = total;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	

}
