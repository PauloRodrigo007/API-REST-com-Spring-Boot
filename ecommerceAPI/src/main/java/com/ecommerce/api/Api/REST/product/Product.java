package com.ecommerce.api.Api.REST.product;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private long id;
    private String name;
    private double price;
	public void setId(int i) {
		
	}
	public long getId() {
		return 0;
	}
	public Object getNome() {
		return null;
	}
	public void setNome(Object nome) {
		
	}
	public Object getPreco() {
		
		return null;
	}
	public void setPreco(Object preco) {
		
	}
}
