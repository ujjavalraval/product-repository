package app.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.product.custome.execption.ProductNotFoundException;
import app.product.entity.Product;
import app.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add-product")
	public Product addProduct(@RequestBody Product product ) {
		log.info("product adding...");
		return productService.addProduct(product);
	}
	
	@GetMapping("/products-list")
	public  List<Product> getProducts() {
		log.info("getting all product...");
		return productService.getProducts();
	}
	
	@GetMapping("/{id}")
	public  Product getProductById(@PathVariable(value = "id") long id) throws ProductNotFoundException {
		log.info("getting by id");
		return productService.getProductById(id);
	}
	
}	

