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

import com.personal.mappers.ShoppingRowMapper;
import com.personal.model.Shopping;

public class ShoppingRepositoryImpl implements ShoppingRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	public ShoppingRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Shopping save(Shopping shopping) {
		KeyHolder holder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement("INSERT INTO shopping (total_price) "
							+ "VALUES (?)",
							Statement.RETURN_GENERATED_KEYS);
				
				ps.setBigDecimal(1, shopping.getTotalPrice());

				return ps;
			}
		}, holder);
		
		Number newId = (Long) holder.getKeys().get("id");
		
		shopping.setId(newId.longValue());
		return shopping;
	}

	@Override
	public Optional<Shopping> findById(Long id) {
		try {
			return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM shopping WHERE id=?", 
					new ShoppingRowMapper(), id));
			}
			catch (EmptyResultDataAccessException e) {
				return Optional.empty();
			}
	}

	@Override
	public void deleteById(Long id) {

		String sql = "DELETE FROM shopping WHERE id = " + id;
		
		jdbcTemplate.execute(sql);
		
	}

}
