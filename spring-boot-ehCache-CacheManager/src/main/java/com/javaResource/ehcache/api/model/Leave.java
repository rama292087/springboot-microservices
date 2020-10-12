package com.javaResource.ehcache.api.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Leave implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String date;
	private int days;
}
