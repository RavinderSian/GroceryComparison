package com.personal.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.personal.model.Shopping;

@JdbcTest
class ShoppingRepositoryImplTest {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private ShoppingRepository repository;

	@BeforeEach
	void setUp() throws Exception {
		repository = new ShoppingRepositoryImpl(jdbcTemplate);
		
    	jdbcTemplate.execute("""
    			CREATE TABLE shopping ( 
    				id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    				total_price decimal (18,2)
    			);
    			""");
    }
    
    @AfterEach
	void deleteTable() {
		
    		jdbcTemplate.execute("DROP TABLE IF EXISTS shopping");
    	
    }

	@Test
	void test_Save_SavesCorrectly_WhenGivenValidProduct() {
		
		Shopping shopping = new Shopping();
		shopping.setTotalPrice(BigDecimal.valueOf(10.00));

		Shopping savedShopping = repository.save(shopping);
		
		assertThat(shopping.getId(), equalTo(1L));
		assertThat(shopping.getTotalPrice(), equalTo(savedShopping.getTotalPrice()));

	}
	
	@Test
	void test_findById_ReturnsOptional_WhenEntityExistsInDatabase() {
		
		Shopping shopping = new Shopping();
		shopping.setTotalPrice(BigDecimal.valueOf(10.00));

		repository.save(shopping);
		
		Shopping savedShopping = repository.findById(1L).get();
		
		assertThat(shopping.getId(), equalTo(1L));
		assertThat(shopping.getTotalPrice(), equalTo(savedShopping.getTotalPrice()));
		
	}

}
