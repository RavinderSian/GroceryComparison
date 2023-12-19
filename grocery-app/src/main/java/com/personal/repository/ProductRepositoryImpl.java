package com.personal.repository;

import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;

import com.personal.model.Product;

public class ProductRepositoryImpl implements ProductRepository {
	
	private final JdbcTemplate jdbcTemplate;

	public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
