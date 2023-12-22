package com.personal.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.personal.model.Shopping;

public class ShoppingRowMapper implements RowMapper<Shopping> {

	@Override
	public Shopping mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Shopping shopping = new Shopping();
		shopping.setId(rs.getLong("id"));
		shopping.setTotalPrice(rs.getBigDecimal(("total_price")));
		
		return shopping;
	}
	
}
