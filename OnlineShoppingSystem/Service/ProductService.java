package com.online.service;
import java.util.List;

import com.online.entity.Product;
//ProductService interface defines CRUD operations for Product entities.

public interface ProductService {
	Product createProduct(Product product);	
	Product getProduct(String productID);
	List<Product> getAllProduct();
	Product updateProduct(String pdId, Product product);
	String deleteProduct(String id);

}
