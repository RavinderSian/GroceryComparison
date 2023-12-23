package com.personal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.personal.mappers.ProductRowMapper;
import com.personal.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	private final JdbcTemplate jdbcTemplate;

	public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Product save(Product product) {
		KeyHolder holder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement("INSERT INTO product (tesco_url, sainsbury_url, "
						+ "lidl_url, home_bargains_url, asda_url, morrissons_url, aldi_url) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?)",
							Statement.RETURN_GENERATED_KEYS);
				
				ps.setString(1, product.getTescoUrl());
				ps.setString(2, product.getSainsburyUrl());
				ps.setString(3, product.getLidlUrl());
				ps.setString(4, product.getHomeBargainsUrl());
				ps.setString(5, product.getAsdaUrl());
				ps.setString(6, product.getMorrissonsUrl());
				ps.setString(7, product.getAldiUrl());

				return ps;
			}
		}, holder);
		
		Number newId = (Long) holder.getKeys().get("id");
		
		product.setId(newId.longValue());
		return product;
	}

	@Override
	public Optional<Product> findById(Long id) {
		try {
			return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM product WHERE id=?", 
					new ProductRowMapper(), id));
			}
			catch (EmptyResultDataAccessException e) {
				return Optional.empty();
			}
	}

	@Override
	public void deleteById(Long id) {
		
		String sql = "DELETE FROM product WHERE id = " + id;
		
		jdbcTemplate.execute(sql);
	}


}
