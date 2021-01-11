package com.example.demo.pojo;

import java.math.BigDecimal;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",",skipFirstLine= true)
public class MyProduct {
	
	@DataField(pos=1)
	private String productId;
	
	@DataField(pos=2)
	private String description;
	
	@DataField(pos=3)
	private String brand;
	
	@DataField(pos=4)
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
		return "MyProduct [productId=" + productId + ", description=" + description + ", brand=" + brand + ", price="
				+ price + "]";
	}

	
	
	
}
