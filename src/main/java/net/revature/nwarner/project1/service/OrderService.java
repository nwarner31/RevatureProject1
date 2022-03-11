package net.revature.nwarner.project1.service;

import net.revature.nwarner.project1.model.Order;
import net.revature.nwarner.project1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {
    OrderRepository or;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public OrderService(OrderRepository or) {
        this.or = or;
    }

    public List<Order> findAll() {
        return or.findAll();
    }

    public Order findOrder(int orderId) {
        return or.findById(orderId);
    }

    public List<Order> findOrdersByDate(String shipDate) {
        return or.findAllByOrderDate(shipDate);
    }

    public List<Order> findOrdersByCustomerId(int customerId) {
        return or.findAllByCustomer_Id(customerId);
    }

    public Order postOrder(Order o) {

        return or.save(o);

    }

    @Transactional
    public Order putOrder(Order o) {
        return em.merge(o);
    }

    public void removeOrder(Order o) {
        or.delete(o);

    }
}
