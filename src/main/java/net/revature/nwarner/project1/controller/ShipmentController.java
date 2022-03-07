package net.revature.nwarner.project1.controller;

import net.revature.nwarner.project1.model.Shipment;
import net.revature.nwarner.project1.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("shipment")
public class ShipmentController {

    private ShipmentService ss;

    @Autowired
    public ShipmentController(ShipmentService ss) {
        this.ss = ss;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Shipment> getAllShipments() {
        return ss.getAllShipments();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "id/{id}")
    public Shipment getShipmentById(@PathVariable int id) {
        return ss.getShipment(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "date/{shipDate}")
    public List<Shipment> getShipmentsByDate(@PathVariable String shipDate) {

        return ss.getShipment(shipDate);
    }

    @GetMapping(value = "count/date")
    public List<Object[]> getShipmentCountByDate() {
        return ss.getShipmentCountByDate();
    }

    @PostMapping
    public Shipment addShipment(@RequestBody Shipment s) {
        return ss.addShipment(s);
    }

    @PutMapping(value = "{id}")
    public boolean updateShipment(@RequestBody Shipment s) {
        return ss.updateShipment(s);
    }

    @DeleteMapping(value = "{id}")
    public void deleteShipment(@RequestBody Shipment s) {
        ss.removeShipment(s);
    }
}
