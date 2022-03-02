package net.revature.nwarner.project1.controller;

import net.revature.nwarner.project1.model.Customer;
import net.revature.nwarner.project1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CustomerController {

    private CustomerService cs;

    @Autowired
    public CustomerController(CustomerService cs) {
        this.cs = cs;
    }

    @GetMapping(value = "customer/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return cs.getCustomerById(id);
    }

    @PostMapping(value = "customer/login")
    public Customer login(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        return cs.getCustomer(username, password);
    }

    @PostMapping(value = "customer")
    public boolean addCustomer(@RequestBody Customer c) {
        return cs.addCustomer(c);
    }

    @PutMapping(value = "customer")
    public boolean updateCustomer(@RequestBody Customer c) {
        return cs.updateCustomer(c);
    }

    @DeleteMapping(value = "customer/{id}")
    public boolean deleteCustomer(@RequestBody Customer c) {
        return cs.removeCustomer(c);
    }

}
