package com.personal.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class Shopping {

	private Long id;
	private List<Product> products;
	private BigDecimal totalPrice;
	
}
