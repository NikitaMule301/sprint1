package com.online.Dao;

import java.util.List;

import com.online.entity.Product;

public interface ProductDao {
	Product createProduct(Product product);	//Create a new record of product.
	Product getProduct(String productID);//Retrieves an products by their unique ID.
	List<Product> getAllProduct();
	Product updateProduct(String pdId, Product product);//Updates an existing product record.
	String deleteProduct(String id);//Deletes product record by ID.
}
