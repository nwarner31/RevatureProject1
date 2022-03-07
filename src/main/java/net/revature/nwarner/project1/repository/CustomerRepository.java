package net.revature.nwarner.project1.repository;

import net.revature.nwarner.project1.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAll();

    //@Query("from Customer where customer_id = :id")
    Customer findById(@Param("id") int id);

    @Query("from Customer where username = :username and password = :password")
    Customer getCustomerLogin(@Param("username") String username, @Param("password") String password);

    Customer save(Customer c);

    @Override
    void delete(Customer c);
}
