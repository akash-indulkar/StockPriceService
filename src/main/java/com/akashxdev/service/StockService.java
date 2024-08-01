package com.akashxdev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akashxdev.aop.StockException;
import com.akashxdev.dao.StockDao;
import com.akashxdev.model.Stock;

@Service
public class StockService {

	@Autowired
	private StockDao stockDao;
	
	public ResponseEntity<?> getPrice(String stockname) {
		Stock stock = stockDao.findByStockName(stockname);
		if(stock == null) {
			return new ResponseEntity<>("Stock not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(stock.getStockPrice(), HttpStatus.OK);
	}

	public ResponseEntity<String> add(Stock stock) {
		stockDao.save(stock);
		return new ResponseEntity<String>("stock added!", HttpStatus.OK);
	}

	public ResponseEntity<String> delete(Integer stockID) {
		stockDao.deleteById(stockID);
		return new ResponseEntity<String>("Stock deleted!", HttpStatus.OK);
	}

	public ResponseEntity<List<Stock>> getAllStocks() {
		List<Stock> allStocks = stockDao.findAll();
		return new ResponseEntity<List<Stock>>(allStocks, HttpStatus.OK);
	}

}
