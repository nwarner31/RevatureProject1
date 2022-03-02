package net.revature.nwarner.project1.repository;

import net.revature.nwarner.project1.model.Customer;
import net.revature.nwarner.project1.repository.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Component
public class CustomerRepository {

    public Customer getCustomer(int customerId) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
            Root<Customer> root = cq.from(Customer.class);
            cq.select(root).where(cb.equal(root.get("id"), customerId));

            Query<Customer> query = session.createQuery(cq);
            Customer c = query.getSingleResult();
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    public Customer getCustomer(String username, String password) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
            Root<Customer> root = cq.from(Customer.class);
            cq.select(root).where(cb.and(cb.equal(root.get("username"), username), cb.equal(root.get("password"), password)));

            Query<Customer> query = session.createQuery(cq);
            Customer c = query.getSingleResult();
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    public boolean addCustomer(Customer c) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.persist(c);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return false;
    }

    public boolean updateCustomer(Customer c) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.merge(c);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return false;
    }

    public boolean removeCustomer(Customer c) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.remove(c);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return false;
    }
}
