package com.ecommerce.api.Api.REST.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/orders")
public class OrderController {


    @Autowired
    private OrderService orderService;

    // Endpoint para criar um novo pedido
    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // Endpoint para obter detalhes de um pedido pelo ID
    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable long orderId) {
        return orderService.getOrderById(orderId);
    }

    // Endpoint para listar todos os pedidos
    @GetMapping("/list")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
