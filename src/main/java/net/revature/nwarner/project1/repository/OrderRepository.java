package net.revature.nwarner.project1.repository;

import net.revature.nwarner.project1.model.Order;
import net.revature.nwarner.project1.repository.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class OrderRepository {

    public Order getOrder(int orderId) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Order> cq = cb.createQuery(Order.class);
            Root<Order> root = cq.from(Order.class);
            cq.select(root).where(cb.equal(root.get("id"), orderId));

            Query<Order> query = session.createQuery(cq);
            Order o = query.getSingleResult();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    public boolean addOrder(Order o) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.persist(o);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return false;
    }

    public boolean updateOrder(Order o) {
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.merge(o);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return false;
    }

    public boolean removeOrder(Order o) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.remove(o);
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
