package net.revature.nwarner.project1.service;

import net.revature.nwarner.project1.model.Customer;
import net.revature.nwarner.project1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
    private CustomerRepository cr;

    @Autowired
    public CustomerService(CustomerRepository cr) {
        this.cr = cr;
    }

    public Customer getCustomerById(int customerId) {
        return cr.findById(customerId);
    }

    public Customer getCustomer(String username, String password) {
        return cr.getCustomerLogin(username, password);
    }

    public Customer addCustomer(Customer c) {
            return cr.save(c);
    }

    public boolean updateCustomer(Customer c) {
        //return cr.updateCustomer(c);
        return false;
    }

    public void removeCustomer(Customer c) {
        cr.delete(c);
    }
}
