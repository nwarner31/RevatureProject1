package net.revature.nwarner.project1.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="order")
public class Order {
    @Id @GeneratedValue
    @Column(name="order_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name="shipment_id")
    private Shipment shipment;
    @Column(name="order_date", nullable = false)
    private Date orderDate;
    @OneToMany
    private List<ProductOrder> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public List<ProductOrder> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOrder> products) {
        this.products = products;
    }
}
