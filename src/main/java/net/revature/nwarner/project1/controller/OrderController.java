package net.revature.nwarner.project1.controller;

import net.revature.nwarner.project1.model.Order;
import net.revature.nwarner.project1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    private OrderService os;

    @Autowired
    public OrderController(OrderService os) {
        this.os = os;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Order> getAllOrders() {
        return os.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "id/{id}")
    public Order getOrderById(@PathVariable int id) {
        return os.findOrder(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "date/{orderDate}")
    public List<Order> getOrdersByDate(@PathVariable String orderDate) {
        return os.findOrdersByDate(orderDate);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "customer/{customerId}")
    public List<Order> getOrderByCustomer(@PathVariable int customerId) {
        return os.findOrdersByCustomerId(customerId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public Order addOrder(@RequestBody Order o) {
        return os.postOrder(o);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "{id}")
    public Order updateOrder(@RequestBody Order o) {
        return os.putOrder(o);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "{id}")
    public void deleteOrder(@RequestBody Order o) {
        os.removeOrder(o);
    }
}
