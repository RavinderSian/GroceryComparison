package com.personal.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.personal.model.Product;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getLong("id"));
		product.setTescoUrl(rs.getString(("tesco_url")));
		product.setSainsburyUrl(rs.getString(("sainsbury_url")));
		product.setAsdaUrl(rs.getString(("asda_url")));
		product.setLidlUrl(rs.getString(("lidl_url")));
		product.setAldiUrl(rs.getString(("aldi_url")));
		product.setMorrissonsUrl(rs.getString(("morrissons_url")));
		product.setHomeBargainsUrl(rs.getString(("home_bargains_url")));
		
		return product;
	}

}
