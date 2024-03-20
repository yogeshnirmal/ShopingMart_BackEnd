package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neosoft.service.ProductService;
import com.neosoft.model.Product;

@RestController
@RequestMapping(value="/product")
@CrossOrigin("*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/addproduct")
	private Product saveProduct(@RequestBody Product product) {
		Product productResp=productService.addProduct(product);
		return productResp;
	}
	@GetMapping(value = "/getproduct/{id}")
	private Product getProduct(@PathVariable int id) {
		Product productResp=productService.getProductById(id);
		return productResp;
	}
	@GetMapping(value = "/getallproduct")
	private List<Product> getAllProduct() {
		List<Product> productResp=productService.allProduct();
		return productResp;
	}
	@DeleteMapping(value = "/delete/{id}")
	private void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}
	@PutMapping(value="/update/{id}")
	private Product updateProduct(@PathVariable int id,@RequestBody Product product) {
		product.setProductId(id);
		return productService.updateProduct(product);
	}	
}
