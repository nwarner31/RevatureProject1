package net.revature.nwarner.project1.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;


@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Integer id;
    @Column(name="upc", nullable = false, unique = true)
    private String upc;
    @Column(name="product_name", nullable = false)
    private String name;
    @Column(name="aisle", nullable = false)
    private Integer aisle;
    @Column(name="row", nullable = false)
    private Integer row;
    @Column(name="section", nullable = false)
    private Integer section;
    @Column(name="shelf", nullable = false)
    private Integer shelf;
    @Column(name="department", nullable = false)
    private String department;
    @Column(name="current_stock", nullable = false)
    @ColumnDefault("0")
    private Integer currentStock;

    public Product() {

    }

    public Product(String upc, String name, Integer aisle, Integer row, Integer section, Integer shelf, String department, Integer currentStock) {
        this.upc = upc;
        this.name = name;
        this.aisle = aisle;
        this.row = row;
        this.section = section;
        this.shelf = shelf;
        this.department = department;
        this.currentStock = currentStock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAisle() {
        return aisle;
    }

    public void setAisle(Integer aisle) {
        this.aisle = aisle;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public Integer getShelf() {
        return shelf;
    }

    public void setShelf(Integer shelf) {
        this.shelf = shelf;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }
}
