package app.product.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.product.custome.execption.ProductNotFoundException;
import app.product.entity.Product;
import app.product.entity.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public  List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public Product getProductById(long id) throws ProductNotFoundException {
		Optional<Product> product =  productRepository.findById(id);
		if(!product.isPresent())
			throw new ProductNotFoundException("Product with id " + id + " not found.");
		else	 
			return product.get();
	}
	

}
