package net.revature.nwarner.project1.service;

import net.revature.nwarner.project1.model.Product;
import net.revature.nwarner.project1.repository.ProductRepository;

import java.util.List;

public class ProductService {
    ProductRepository pr;
    public ProductService() {
        pr = new ProductRepository();
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
        if (getProductById(p.getId()) == null) {
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
