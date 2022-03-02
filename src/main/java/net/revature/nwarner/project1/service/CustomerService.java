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
        return cr.getCustomer(customerId);
    }

    public Customer getCustomer(String username, String password) {
        return cr.getCustomer(username, password);
    }

    public boolean addCustomer(Customer c) {
            return cr.addCustomer(c);

    }

    public boolean updateCustomer(Customer c) {
        return cr.updateCustomer(c);
    }

    public boolean removeCustomer(Customer c) {
        return cr.removeCustomer(c);
    }
}
