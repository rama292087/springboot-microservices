package com.example.demo.exceptionhandlepkg;


public class OrderNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private Long id;

	public OrderNotFoundException(Long id) {
		super(String.format("Order Id %d not found", id));
	}
	
	

}
