package net.skhu.dto;

public class Product {
	String name;
	int uniCost;

	public Product(String name, int uniCost) {
		super();
		this.name = name;
		this.uniCost = uniCost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUniCost() {
		return uniCost;
	}

	public void setUniCost(int uniCost) {
		this.uniCost = uniCost;
	}

}
