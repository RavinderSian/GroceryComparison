package com.personal.repository;

import java.util.Optional;

import com.personal.model.Product;

public interface ProductRepository {

	Product save(Product product);
	Optional<Product> findById(Long id);
	void deleteById(Long id);
	
}
