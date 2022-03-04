package net.revature.nwarner.project1.service;

import net.revature.nwarner.project1.model.Order;
import net.revature.nwarner.project1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    OrderRepository or;

    @Autowired
    public OrderService(OrderRepository or) {
        this.or = or;
    }

    public Order getOrder(int orderId) {
        return or.findById(orderId);
    }

    public Order addOrder(Order o) {

        return or.save(o);

    }

    public boolean updateOrder(Order o) {
        //return or.updateOrder(o);
        return false;
    }

    public void removeOrder(Order o) {
        or.delete(o);

    }
}
