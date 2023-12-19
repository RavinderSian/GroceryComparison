package com.personal.repository;

import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;

import com.personal.model.Shopping;

public class ShoppingRepositoryImpl implements ShoppingRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	public ShoppingRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Shopping save(Shopping shopping) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Shopping> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
