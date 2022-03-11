package net.revature.nwarner.project1.repository;

import net.revature.nwarner.project1.model.Customer;
import net.revature.nwarner.project1.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAll();

    Order findById(int id);

    List<Order> findAllByOrderDate(String orderDate);

    List<Order> findAllByCustomer_Id(int customer_id);

    Order save(Order o);

    void delete(Order o);
}
