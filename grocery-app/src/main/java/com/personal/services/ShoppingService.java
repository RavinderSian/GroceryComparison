package com.personal.services;

import java.util.Optional;

import com.personal.model.Shopping;

public interface ShoppingService {
	
	Shopping save(Shopping shopping);
	Optional<Shopping> findById(Long id);
	void deleteById(Long id);
	
}
