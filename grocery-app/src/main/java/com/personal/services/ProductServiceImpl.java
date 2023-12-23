package com.personal.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.personal.model.Product;
import com.personal.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public Product save(Product product) {
		Product savedProduct = repository.save(product);
		return savedProduct;
	}

	@Override
	public Optional<Product> findById(Long id) {
		Optional<Product> productOptional = repository.findById(id);
		return productOptional;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
