package com.personal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
