package com.personal.repository;

import java.util.Optional;

import com.personal.model.Shopping;

public interface ShoppingRepository {

	Shopping save(Shopping shopping);
	Optional<Shopping> findById(Long id);
	void deleteById(Long id);
	
}
