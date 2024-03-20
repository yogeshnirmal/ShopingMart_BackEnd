package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Product;
import com.neosoft.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
		
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepository.findById(id).get();
	}
	@Override
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> allProduct() {
		return productRepository.findAll();
	}

}
