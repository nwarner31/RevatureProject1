package net.revature.nwarner.project1.repository;

import net.revature.nwarner.project1.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();

    //@Query("from Product where product_id = :id")
    Product findById(int id);

    //@Query("from Product where upc = :upc")
    Product findByUpc(String upc);

    @Query("from Product where product_name like %:name%")
    List<Product> getProductsByName(@Param("name") String name);

    //@Query("from Product where department = :department")
    List<Product> findAllByDepartment(String department);

    @Query("SELECT department, COUNT(product_id) FROM Product GROUP BY department")
    List<Object[]> getProductCountByDepartment();

    Product save(Product p);

    void delete(Product entity);


    //Product update();
}