package com.example.demo.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Relation(value="user", collectionRelation="Users")
/*
 * @Relation annotation can help break the coupling between the JSON field
 * name and the resource type class names as defined in Java.
 */
public class Users extends RepresentationModel<Users> {
	private String name;
	private Long salary;

}
