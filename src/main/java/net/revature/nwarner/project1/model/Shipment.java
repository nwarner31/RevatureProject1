package net.revature.nwarner.project1.model;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name="shipment")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shipment_id")
    private Integer id;
    @Column(name="ship_date", nullable = false)
    private LocalDate shipDate;
    @Column(name="ship_time", nullable = false)
    private Time shipTime;
    @Column(name="bay_number", nullable = false)
    private Integer bayNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDate shipDate) {
        this.shipDate = shipDate;
    }

    public Time getShipTime() {
        return shipTime;
    }

    public void setShipTime(Time shipTime) {
        this.shipTime = shipTime;
    }

    public Integer getBayNum() {
        return bayNum;
    }

    public void setBayNum(Integer bayNum) {
        this.bayNum = bayNum;
    }
}
