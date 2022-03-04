package net.revature.nwarner.project1.controller;

import net.revature.nwarner.project1.model.Product;
import net.revature.nwarner.project1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private ProductService ps;

    @Autowired
    public ProductController(ProductService ps) {
        this.ps = ps;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return ps.findAllProducts();
    }

    @GetMapping(value = "id/{id}")
    public Product getProductByUpc(@PathVariable int id) {
        System.out.println("In get by upc");
        return ps.getProductById(id);
    }

    @GetMapping(value = "upc/{upc}")
    public Product getProductByUpc(@PathVariable String upc) {
        System.out.println("In get by upc");
        //return ps.getProductByUpc(upc);
        return null;
    }

    @GetMapping(value = "name/{name}")
    public List<Product> getProductsByName(@PathVariable String name) {
        return ps.getProductsByName(name);
    }

    @GetMapping(value = "dept/{dept}")
    public List<Product> getProductsByDept(@PathVariable String dept) {
        return ps.getProductsByDept(dept);
    }

    @GetMapping(value = "count/dept/")
    public String getProductCountByDept() {
        return ps.getProductCountByDepartment();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product p) {
        return ps.addProduct(p);
    }

    @PutMapping(value = "{id}")
    public boolean updateProduct(@RequestBody Product p) {
        return ps.updateProduct(p);
    }

    @DeleteMapping(value="{id}")
    public boolean deleteProduct(@RequestBody Product p) {
        return ps.removeProduct(p);
    }
}
