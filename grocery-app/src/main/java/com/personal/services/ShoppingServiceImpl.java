package com.personal.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.personal.model.Shopping;
import com.personal.repository.ShoppingRepository;

@Service
public class ShoppingServiceImpl implements ShoppingService {
	
	private final ShoppingRepository repository;
	
	public ShoppingServiceImpl(ShoppingRepository repository) {
		this.repository = repository;
	}

	@Override
	public Shopping save(Shopping shopping) {
		Shopping savedShopping = repository.save(shopping);
		return savedShopping;
	}

	@Override
	public Optional<Shopping> findById(Long id) {
		Optional<Shopping> shoppingOptional = repository.findById(id);
		return shoppingOptional;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
}
