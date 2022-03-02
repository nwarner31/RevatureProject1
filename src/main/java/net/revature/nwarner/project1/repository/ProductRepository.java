package net.revature.nwarner.project1.repository;

import net.revature.nwarner.project1.model.Product;
import net.revature.nwarner.project1.repository.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class ProductRepository {

    public Product getProduct(int productId) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Product> cq = cb.createQuery(Product.class);
            Root<Product> root = cq.from(Product.class);
            cq.select(root).where(cb.equal(root.get("id"), productId));

            Query<Product> query = session.createQuery(cq);
            Product p = query.getSingleResult();
            return p;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();

        }
        return null;
    }

    public Product getProduct(String upc) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Product> cq = cb.createQuery(Product.class);
            Root<Product> root = cq.from(Product.class);
            cq.select(root).where(cb.equal(root.get("upc"), upc));

            Query<Product> query = session.createQuery(cq);
            Product p = query.getSingleResult();
            return p;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();

        }
        return null;
    }

    public List<Product> getProductsByName(String productName) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Product> cq = cb.createQuery(Product.class);
            Root<Product> root = cq.from(Product.class);
            cq.select(root).where(cb.like(root.get("name"), String.format("%%%s%%", productName)));

            Query<Product> query = session.createQuery(cq);
            List<Product> products = query.getResultList();
            return products;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();

        }
        return null;
    }

    public List<Product> getProductsByDept(String productDept) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Product> cq = cb.createQuery(Product.class);
            Root<Product> root = cq.from(Product.class);
            cq.select(root).where(cb.equal(root.get("department"), productDept));

            Query<Product> query = session.createQuery(cq);
            List<Product> products = query.getResultList();
            return products;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();

        }
        return null;
    }

    public boolean addProduct(Product p) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.persist(p);
            transaction.commit();
            return true;

        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            if(session != null) session.close();

        }
        return false;
    }

    public boolean updateProduct(Product p) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.merge(p);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return false;
    }

    public boolean removeProduct(Product p) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.remove(p);
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
