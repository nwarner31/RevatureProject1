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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Product> getAllProducts() {
        return ps.findAllProducts();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "id/{id}")
    public Product getProductById(@PathVariable int id) {

        return ps.findProductById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "upc/{upc}")
    public Product getProductByUpc(@PathVariable String upc) {
        System.out.println("In get by upc");
        return ps.findProductByUpc(upc);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "name/{name}")
    public List<Product> getProductsByName(@PathVariable String name) {
        return ps.findProductsByName(name);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "dept/{dept}")
    public List<Product> getProductsByDept(@PathVariable String dept) {
        return ps.findProductsByDept(dept);
    }

    @GetMapping(value = "count/dept")
    public List<Object[]> getProductCountByDept() {
        return ps.findProductCountByDepartment();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public Product addProduct(@RequestBody Product p) {
        return ps.saveProduct(p);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "{id}")
    public Product updateProduct(@RequestBody Product p) {
        return ps.putProduct(p);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value="{id}")
    public boolean deleteProduct(@RequestBody Product p) {
        return ps.removeProduct(p);
    }
}
