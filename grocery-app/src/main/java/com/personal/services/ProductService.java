package com.personal.services;

import java.util.Optional;

import com.personal.model.Product;

public interface ProductService {

	Product save(Product product);
	Optional<Product> findById(Long id);
	void deleteById(Long id);
	
}
