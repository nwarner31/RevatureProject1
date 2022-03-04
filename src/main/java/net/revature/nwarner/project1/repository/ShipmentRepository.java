package net.revature.nwarner.project1.repository;

import net.revature.nwarner.project1.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

    //@Query("from Shipment where shipment_id = :id")
    Shipment findById(int id);

    //@Query("from Shipment where ship_date = :shipDate")
    List<Shipment> findAllByShipDate(LocalDate shipDate);

    @Query("SELECT shipDate, COUNT(shipment_id) FROM Shipment GROUP BY shipDate")
    List<Object[]> getShipmentCountByDate();

    Shipment save(Shipment s);

    void delete(Shipment s);
}
