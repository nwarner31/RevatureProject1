package net.revature.nwarner.project1.repository;

import net.revature.nwarner.project1.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAll();

    Order findById(int id);

    Order save(Order o);

    void delete(Order o);
}
