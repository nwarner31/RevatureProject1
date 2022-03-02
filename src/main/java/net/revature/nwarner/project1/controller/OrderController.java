package net.revature.nwarner.project1.controller;

import net.revature.nwarner.project1.model.Order;
import net.revature.nwarner.project1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private OrderService os;

    @Autowired
    public OrderController(OrderService os) {
        this.os = os;
    }

    @GetMapping(value = "order/{id}")
    public Order getOrderById(@PathVariable int id) {
        return os.getOrder(id);
    }

    @PostMapping(value = "order")
    public boolean addOrder(@RequestBody Order o) {
        return os.addOrder(o);
    }

    @PutMapping(value = "order/{id}")
    public boolean updateOrder(@RequestBody Order o) {
        return os.updateOrder(o);
    }

    @DeleteMapping(value = "order/{id}")
    public boolean deleteOrder(@RequestBody Order o) {
        return os.removeOrder(o);
    }
}
