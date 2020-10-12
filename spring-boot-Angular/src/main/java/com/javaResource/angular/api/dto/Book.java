package com.javaResource.angular.api.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private int id;
	private String name;
	private int price;
	private String availability;
	private LocalDateTime duedate;
	private int firstrating;
	private int secondrating;
	private int otherratings;
}
