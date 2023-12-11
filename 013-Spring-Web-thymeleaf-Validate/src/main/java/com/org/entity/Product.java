package com.org.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Data
public class Product {

	@Id
	@GeneratedValue
	private Integer pid;
	
	@NotBlank(message = "!name is mandatory")
	@Size(min = 3, max = 15,message ="name should be between 3 to 15 character" )
	private String name;
	
	@NotNull(message = "!price is mandatory")
	@Positive(message = "price must be positive")
	private Double price;
	
	@NotNull(message = "!quantity is mandatory")
	@Positive(message = "quantity must be positive")
	private Integer quan;
}
