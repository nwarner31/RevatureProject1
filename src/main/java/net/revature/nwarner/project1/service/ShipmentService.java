package net.revature.nwarner.project1.service;

import net.revature.nwarner.project1.model.Shipment;
import net.revature.nwarner.project1.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ShipmentService {

    private ShipmentRepository sr;

    @Autowired
    public ShipmentService(ShipmentRepository sr) {
        this.sr = sr;
    }

    public Shipment getShipment(int shipmentId) {
        return sr.findById(shipmentId);
    }

    public List<Shipment> getShipment(LocalDate shipDate) {
        return sr.findAllByShipDate(shipDate);
    }

    public List<Object[]> getShipmentCountByDate() {
        return sr.getShipmentCountByDate();
    }

    public Shipment addShipment(Shipment s) {
        return sr.save(s);
    }

    public boolean updateShipment(Shipment s) {
        //return sr.updateShipment(s);
        return false;
    }

    public void removeShipment(Shipment s) {
        sr.delete(s);
    }
}
