package net.revature.nwarner.project1.controller;

import net.revature.nwarner.project1.model.Customer;
import net.revature.nwarner.project1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private CustomerService cs;

    @Autowired
    public CustomerController(CustomerService cs) {
        this.cs = cs;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Customer> getAllCustomers() {
        return cs.findAllCustomers();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "id/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return cs.findCustomerById(id);
    }

    @PostMapping(value = "login")
    public Customer login(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        return cs.findCustomer(username, password);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public Customer addCustomer(@RequestBody Customer c) {
        return cs.postCustomer(c);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "{id}")
    public Customer updateCustomer(@RequestBody Customer c) {
        return cs.putCustomer(c);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "{id}")
    public void deleteCustomer(@RequestBody Customer c) {
        cs.removeCustomer(c);
    }

}
