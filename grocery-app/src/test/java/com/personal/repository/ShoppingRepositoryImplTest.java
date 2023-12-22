package com.personal.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

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
	void test() {
		fail("Not yet implemented");
	}

}
