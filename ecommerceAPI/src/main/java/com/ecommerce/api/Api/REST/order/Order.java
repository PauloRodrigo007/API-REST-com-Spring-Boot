package com.ecommerce.api.Api.REST.order;

import lombok.*;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@SuppressWarnings("unused")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<Order> items;

    private Double total;

    // Método para calcular o valor total do pedido
    public void calculateTotal() {
        double calculatedTotal = 0.0;
        for (Order item : items) {
            calculatedTotal += item.getPrice() * item.getQuantity();
        }
        this.total = calculatedTotal;
    }

	private int getQuantity() {
		return 0;
	}

	private int getPrice() {
		return 0;
	}

	public double getTotal() {
		return 0;
	}

	public void setTotal(double discountedTotal) {

		
	}
}


