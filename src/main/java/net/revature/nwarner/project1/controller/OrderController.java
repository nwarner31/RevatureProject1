package net.revature.nwarner.project1.controller;

import net.revature.nwarner.project1.model.Order;
import net.revature.nwarner.project1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    private OrderService os;

    @Autowired
    public OrderController(OrderService os) {
        this.os = os;
    }

    @GetMapping(value = "{id}")
    public Order getOrderById(@PathVariable int id) {
        return os.getOrder(id);
    }

    @PostMapping
    public Order addOrder(@RequestBody Order o) {
        return os.addOrder(o);
    }

    @PutMapping(value = "{id}")
    public boolean updateOrder(@RequestBody Order o) {
        return os.updateOrder(o);
    }

    @DeleteMapping(value = "{id}")
    public void deleteOrder(@RequestBody Order o) {
        os.removeOrder(o);
    }
}
