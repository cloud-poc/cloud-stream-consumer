package org.akj.springboot.stream.rabbit.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {
	private String id;
	
	private String summary;
	
	private BigDecimal amount;
	
	private String currency;
	
	private Date createDate;
}
