package com.ee417.groupf.controller;

import com.ee417.groupf.model.Order;
import com.ee417.groupf.service.OrdersService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        System.out.println("OrdersController===================");
        this.ordersService = ordersService;
    }

    @PostMapping("/post-order")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) throws IOException {
        System.out.println("saveOrder===================");
        ordersService.saveOrder(order);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }

    @GetMapping("/orderslist")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Order>> listOrders() throws IOException {
        System.out.println("listOrders===================");
        return ResponseEntity.ok(ordersService.listOrders());
    }

    @GetMapping("/{orderId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<JsonNode>> getOrdersByOrderId(@PathVariable String orderId) throws IOException {
        System.out.println("getOrdersByEmail===================" + orderId);
        System.out.println(ordersService.getOrdersByOrderId(orderId));
        return ResponseEntity.ok(ordersService.getOrdersByOrderId(orderId));
    }

    @DeleteMapping("delete/{orderId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> deleteOrderByOrderId(@PathVariable String orderId) throws IOException {
        System.out.println("deleteOrderByOrderId===================" + orderId);
        boolean deleted = ordersService.deleteOrderByOrderId(orderId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
