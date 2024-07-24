package com.ecommerce.api.Api.REST.order;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepository;

    // Método para criar um novo pedido
    public Order createOrder(Order order) {
        // Calcular o total do pedido
        order.calculateTotal();

        // Aplicar desconto se o total for superior a 200 reais
        if (order.getTotal() > 200.0) {
            applyDiscount(order);
        }

        return orderRepository.save(order);
    }

    // Método para aplicar desconto de 10% no pedido
    private void applyDiscount(Order order) {
        double discount = order.getTotal() * 0.1;
        double discountedTotal = order.getTotal() - discount;
        order.setTotal(discountedTotal);
    }

    // Método para obter um pedido pelo ID
    public Order getOrderById(long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado com o ID: " + orderId));
    }

    // Método para listar todos os pedidos
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
}
