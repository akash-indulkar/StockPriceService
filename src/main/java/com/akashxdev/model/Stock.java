package com.akashxdev.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String stockName;
	private Integer stockPrice;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Integer getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(Integer stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Stock(Integer id, String stockName, Integer stockPrice) {
		super();
		this.id = id;
		this.stockName = stockName;
		this.stockPrice = stockPrice;
	}
	
	public Stock() {
		super();
	}
	
	
}
