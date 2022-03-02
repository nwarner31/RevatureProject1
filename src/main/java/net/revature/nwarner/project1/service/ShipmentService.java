package net.revature.nwarner.project1.service;

import net.revature.nwarner.project1.model.Shipment;
import net.revature.nwarner.project1.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
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
        return sr.getShipment(shipmentId);
    }

    public List<Shipment> getShipment(LocalDate shipDate) {
        return sr.getShipment(shipDate);
    }

    public boolean addShipment(Shipment s) {

            return sr.addShipment(s);

    }

    public boolean updateShipment(Shipment s) {
        return sr.updateShipment(s);
    }

    public boolean removeShipment(Shipment s) {
        return sr.removeShipment(s);
    }
}
