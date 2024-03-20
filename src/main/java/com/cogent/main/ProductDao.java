package com.cogent.main;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDao 
{
	private String name;
	private String description;
	private float price;
	private String category;
	private String image;
}
