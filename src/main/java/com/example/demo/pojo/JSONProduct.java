package com.example.demo.pojo;

import java.math.BigDecimal;

public class JSONProduct {

	private String productId;
	private String description;
	private String brand;
	private BigDecimal price;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "JSONProduct [productId=" + productId + ", description=" + description + ", brand=" + brand + ", price="
				+ price + "]";
	}
	
	
}
