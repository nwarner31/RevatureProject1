package net.revature.nwarner.project1.controller;

import net.revature.nwarner.project1.model.Customer;
import net.revature.nwarner.project1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private CustomerService cs;

    @Autowired
    public CustomerController(CustomerService cs) {
        this.cs = cs;
    }

    @GetMapping(value = "{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return cs.getCustomerById(id);
    }

    @PostMapping(value = "login")
    public Customer login(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        return cs.getCustomer(username, password);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer c) {
        return cs.addCustomer(c);
    }

    @PutMapping
    public boolean updateCustomer(@RequestBody Customer c) {
        return cs.updateCustomer(c);
    }

    @DeleteMapping(value = "{id}")
    public void deleteCustomer(@RequestBody Customer c) {
        cs.removeCustomer(c);
    }

}
