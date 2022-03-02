package net.revature.nwarner.project1.service;

import net.revature.nwarner.project1.model.Product;
import net.revature.nwarner.project1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository pr;

    @Autowired
    public ProductService(ProductRepository pr) {
        this.pr = pr;
    }

    public Product getProductById(int productId) {
        return pr.getProduct(productId);
    }

    public Product getProductByUpc(String upc) {
        return pr.getProduct(upc);
    }

    public List<Product> getProductsByName(String productName) {
        return pr.getProductsByName(productName);
    }

    public List<Product> getProductsByDept(String productDept) {
        return  pr.getProductsByDept(productDept);
    }

    public boolean addProduct(Product p) {
        if (getProductByUpc(p.getUpc()) == null) {
            return pr.addProduct(p);
        } else {
            return false;
        }
    }

    public boolean updateProduct(Product p) {
        return pr.updateProduct(p);
    }

    public boolean removeProduct(Product p) {
        return pr.removeProduct(p);
    }
}
