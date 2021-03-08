package com.example.demo.models;


public class Product {
	
	private int id;
	private String name;
	private float price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public static Product getProductDetail(int id) {
		Product c1 = new Product();
		c1.setId(id);
		c1.setName("PRODUCT ABC");
		c1.setPrice(1000f);
		return c1;
	}
	
	
}
