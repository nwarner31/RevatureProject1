package net.revature.nwarner.project1.service;

import net.revature.nwarner.project1.model.Shipment;
import net.revature.nwarner.project1.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Component
public class ShipmentService {

    private ShipmentRepository sr;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public ShipmentService(ShipmentRepository sr) {
        this.sr = sr;
    }

    public List<Shipment> findAllShipments(){
        return sr.findAll();
    }

    public Shipment findShipment(int shipmentId) {
        return sr.findById(shipmentId);
    }

    public List<Shipment> findShipment(String shipDate) {
        return sr.findAllByShipDate(shipDate);
    }

    public List<Object[]> findShipmentCountByDate() {
        return sr.getShipmentCountByDate();
    }

    public Shipment postShipment(Shipment s) {
        return sr.save(s);
    }

    @Transactional
    public Shipment putShipment(Shipment s) {
        return em.merge(s);
    }

    public void removeShipment(Shipment s) {
        sr.delete(s);
    }
}
