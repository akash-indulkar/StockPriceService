package com.akashxdev.aop;

public class StockException extends RuntimeException {

	public StockException() {
		super();
	}

	public StockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StockException(String message, Throwable cause) {
		super(message, cause);
	}

	public StockException(String message) {
		super(message);
	}

	public StockException(Throwable cause) {
		super(cause);
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	

	
}
