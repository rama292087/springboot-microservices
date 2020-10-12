package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.emnumpack.OrderStatus;

import lombok.Data;
@Data
@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue
	private Long id;
	private OrderStatus orderStatus;
	private String description;

	public Order() {
		this.id = null;
		this.orderStatus = OrderStatus.BEING_CREATED;
		this.description = "";
	}

	public Order(String description) {
		this();
		this.description = description;
	}

	
	
}
