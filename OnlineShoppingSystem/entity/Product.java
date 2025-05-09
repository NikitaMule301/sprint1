package com.online.entity;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity// JPA entity
@Table(name = "Product_details") // Maps to 'Product_details' table
public class Product {
	@Id
	@Column(name = "product_id", length = 10)//'product_id' column
	private String product_id;
	@Column(name = "product_name", length = 50)//'name' column with max 50 characters
	private String product_name;
	@Column(name = "specification", length = 50)//'cart' column
	private String specification;
	@Column(name = "category_name", length = 50)//'category_name' column
	private String category_name;
	@Column(name = "cart_id", length = 50)//'cart_id' column
	private String cart_id;
	@Column(length = 50)//'quantity' column
	private String quantity;
	@Column(length = 30)//'price' column
	private String price;
	@Column(length = 50)//'dimension' column
	private String dimension;
	@Column(length = 50)//'color' column
	private String color;

	// Constructors
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCart_id() {
		return cart_id;
	}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Product(String product_id, String product_name, String specification, String category_name, String cart_id,
			String quantity, String price, String dimension, String color) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.specification = specification;
		this.category_name = category_name;
		this.cart_id = cart_id;
		this.quantity = quantity;
		this.price = price;
		this.dimension = dimension;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", specification="
				+ specification + ", category_name=" + category_name + ", cart_id=" + cart_id + ", quantity=" + quantity
				+ ", price=" + price + ", dimension=" + dimension + ", color=" + color + "]";
	}

}
