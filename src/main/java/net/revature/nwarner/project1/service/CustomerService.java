package net.revature.nwarner.project1.service;

import net.revature.nwarner.project1.model.Customer;
import net.revature.nwarner.project1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CustomerService {
    private CustomerRepository cr;

    @PersistenceContext
    EntityManager em;

    @Autowired
    public CustomerService(CustomerRepository cr) {
        this.cr = cr;
    }

    public List<Customer> findAllCustomers() {
        return cr.findAll();
    }

    public Customer findCustomerById(int customerId) {
        return cr.findById(customerId);
    }

    public Customer findCustomer(String username, String password) {
        return cr.getCustomerLogin(username, password);
    }

    public Customer postCustomer(Customer c) {
            return cr.save(c);
    }

    @Transactional
    public Customer putCustomer(Customer c) {
        return em.merge(c);
    }

    public void removeCustomer(Customer c) {
        cr.delete(c);
    }
}
