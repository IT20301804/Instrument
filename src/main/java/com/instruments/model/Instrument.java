package com.instruments.model;

public class Instrument {
	
	private int id;
	private String name;
	private String price;
	private String des;
	private String category;
	private String warrenty;
	
	public Instrument(int id, String name, String price, String des, String category, String warrenty) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.des = des;
		this.category = category;
		this.warrenty = warrenty;
	}
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getWarrenty() {
		return warrenty;
	}
	public void setWarrenty(String warrenty) {
		this.warrenty = warrenty;
	}
	
	

}
