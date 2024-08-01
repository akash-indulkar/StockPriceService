package com.akashxdev.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akashxdev.model.Stock;
import com.akashxdev.service.StockService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/stocks")
public class StockController {

	@Autowired
	private StockService stockService;
	
	@GetMapping("/getprice/{stockname}")
	public ResponseEntity<?> getPriceByStockName(@PathVariable String stockname) {
		return stockService.getPrice(stockname);
	}
	
	@GetMapping("/getallstocks")
	public ResponseEntity<List<Stock>> getAllStocks() {
		return stockService.getAllStocks();
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addStock(@RequestBody Stock stock) {
		return stockService.add(stock);
	}
	
	@DeleteMapping("/delete/{stockID}")
	public ResponseEntity<String> deleteStock(@PathVariable Integer stockID) {
		return stockService.delete(stockID);
	}
	
}
