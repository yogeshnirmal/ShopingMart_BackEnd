package com.neosoft.service;

import java.util.List;

import com.neosoft.model.Product;
public interface ProductService {
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public Product getProductById(Integer id);
	public void deleteProduct(Integer id);
	public List<Product> allProduct();
}
