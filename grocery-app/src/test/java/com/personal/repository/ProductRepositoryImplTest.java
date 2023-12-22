 package com.personal.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

@JdbcTest
class ProductRepositoryImplTest {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private ProductRepository productRepository;

	@BeforeEach
	void setUp() throws Exception {
		productRepository = new ProductRepositoryImpl(jdbcTemplate);
	
    	jdbcTemplate.execute("""
    			CREATE TABLE product ( id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    			tesco_url varchar(50),
    			sainsbury_url varchar(50),
    			lidl_url varchar(50),
    			home_bargains_url varchar(50),
    			asda_url varchar(50),
    			morissons_url varchar(50),
    			aldi_url varchar(50),
    			);
    			""");
    }
    
    @AfterEach
	void deleteTable() {
		
    		jdbcTemplate.execute("DROP TABLE IF EXISTS product");
    	
    }

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	

}
