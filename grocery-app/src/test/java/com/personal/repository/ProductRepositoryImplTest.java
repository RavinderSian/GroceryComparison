 package com.personal.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.personal.model.Product;

@JdbcTest
class ProductRepositoryImplTest {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private ProductRepository repository;

	@BeforeEach
	void setUp() throws Exception {
		repository = new ProductRepositoryImpl(jdbcTemplate);
	
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
	void test_Save_SavesCorrectly_WhenGivenValidProduct() {
		
		Product product = new Product();
		product.setTescoUrl("test tesco");
		product.setSainsburyUrl("test sainsbury");
		product.setLidlUrl("test lidl");
		product.setHomeBargainsUrl("test home bargains");
		product.setAsdaUrl("test asda");
		product.setMorrissonsUrl("test morrissons");
		product.setAldiUrl("test aldi");

		Product savedProduct = repository.save(product);
		
		assertThat(product.getId(), equalTo(1L));
		assertThat(product.getTescoUrl(), equalTo(savedProduct.getTescoUrl()));
		assertThat(product.getSainsburyUrl(), equalTo(savedProduct.getSainsburyUrl()));
		assertThat(product.getLidlUrl(), equalTo(savedProduct.getLidlUrl()));
		assertThat(product.getHomeBargainsUrl(), equalTo(savedProduct.getHomeBargainsUrl()));
		assertThat(product.getMorrissonsUrl(), equalTo(savedProduct.getTescoUrl()));
		assertThat(product.getAsdaUrl(), equalTo(savedProduct.getMorrissonsUrl()));
		assertThat(product.getAldiUrl(), equalTo(savedProduct.getAldiUrl()));

		
	}
	

}
