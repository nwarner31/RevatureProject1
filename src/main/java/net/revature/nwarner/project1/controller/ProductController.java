package net.revature.nwarner.project1.controller;

import net.revature.nwarner.project1.model.Product;
import net.revature.nwarner.project1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ProductController {

    private ProductService ps;

    @Autowired
    public ProductController(ProductService ps) {
        this.ps = ps;
    }

    @GetMapping(value = "product/upc/{upc}")
    public Product getProductByUpc(@PathVariable String upc) {
        System.out.println("In get by upc");
        //return ps.getProductByUpc(upc);
        return null;
    }

    @GetMapping(value = "product/name/{name}")
    public List<Product> getProductsByName(@PathVariable String name) {
        return ps.getProductsByName(name);
    }

    @GetMapping(value = "product/dept/{dept}")
    public List<Product> getProductsByDept(@PathVariable String dept) {
        return ps.getProductsByDept(dept);
    }

    @PostMapping(value = "product")
    public boolean addProduct(@RequestBody Product p) {
        System.out.println(p);
        return ps.addProduct(p);
    }

    @PutMapping(value = "product/{id}")
    public boolean updateProduct(@RequestBody Product p) {
        return ps.updateProduct(p);
    }

    @DeleteMapping(value="product/{id}")
    public boolean deleteProduct(@RequestBody Product p) {
        return ps.removeProduct(p);
    }
}
