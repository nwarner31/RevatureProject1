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
        return ss.findAllShipments();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "id/{id}")
    public Shipment getShipmentById(@PathVariable int id) {
        return ss.findShipment(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "date/{shipDate}")
    public List<Shipment> getShipmentsByDate(@PathVariable String shipDate) {

        return ss.findShipment(shipDate);
    }

    @GetMapping(value = "count/date")
    public List<Object[]> findShipmentCountByDate() {
        return ss.findShipmentCountByDate();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public Shipment addShipment(@RequestBody Shipment s) {
        return ss.postShipment(s);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "{id}")
    public Shipment updateShipment(@RequestBody Shipment s) {
        return ss.putShipment(s);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "{id}")
    public void deleteShipment(@RequestBody Shipment s) {
        ss.removeShipment(s);
    }
}
