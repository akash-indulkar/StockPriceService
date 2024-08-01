package com.akashxdev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.akashxdev.model.Stock;

@Repository
public interface StockDao extends JpaRepository<Stock, Integer>{

	Stock findByStockName(String stockname);

}
