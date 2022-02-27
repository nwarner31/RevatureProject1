package net.revature.nwarner.project1.repository;

import net.revature.nwarner.project1.model.Shipment;
import net.revature.nwarner.project1.repository.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;

public class ShipmentRepository {

    public Shipment getShipment(int shipmentId) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Shipment> cq = cb.createQuery(Shipment.class);
            Root<Shipment> root = cq.from(Shipment.class);
            cq.select(root).where(cb.equal(root.get("id"), shipmentId));

            Query<Shipment> query = session.createQuery(cq);
            Shipment s = query.getSingleResult();
            return s;
        } catch (Exception e) {

        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    public List<Shipment> getShipment(Date shipDate) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Shipment> cq = cb.createQuery(Shipment.class);
            Root<Shipment> root = cq.from(Shipment.class);
            cq.select(root).where(cb.equal(root.get("shipDate"), shipDate));

            Query<Shipment> query = session.createQuery(cq);
            List<Shipment> shipments = query.getResultList();
            return shipments;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    public boolean updateShipment(Shipment s) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.merge(s);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session != null) session.close();
        }
        return false;
    }

    public boolean removeShipment(Shipment s) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.remove(s);
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
