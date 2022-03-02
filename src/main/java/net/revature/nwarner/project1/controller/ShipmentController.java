package net.revature.nwarner.project1.controller;

import net.revature.nwarner.project1.model.Shipment;
import net.revature.nwarner.project1.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
public class ShipmentController {

    private ShipmentService ss;

    @Autowired
    public ShipmentController(ShipmentService ss) {
        this.ss = ss;
    }

    @GetMapping(value = "shipment/id/{id}")
    public Shipment getShipmentById(@PathVariable int id) {
        return ss.getShipment(id);
    }

    @GetMapping(value = "shipment/date/{date}")
    public List<Shipment> getShipmentsByDate(@PathVariable String date) {
        LocalDate shipDate = LocalDate.parse(date);
        return ss.getShipment(shipDate);
    }

    @PostMapping(value = "shipment")
    public boolean addShipment(@RequestBody Shipment s) {
        return ss.addShipment(s);
    }

    @PutMapping(value = "shipment/{id}")
    public boolean updateShipment(@RequestBody Shipment s) {
        return ss.updateShipment(s);
    }

    @DeleteMapping(value = "shipment/{id}")
    public boolean deleteShipment(@RequestBody Shipment s) {
        return ss.removeShipment(s);
    }
}
