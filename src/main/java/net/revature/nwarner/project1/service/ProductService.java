package net.revature.nwarner.project1.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.revature.nwarner.project1.model.Product;
import net.revature.nwarner.project1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class ProductService {

    private ProductRepository pr;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public ProductService(ProductRepository pr) {
        this.pr = pr;
    }

    public List<Product> findAllProducts() {
        return pr.findAll();
    }

    public Product getProductById(int productId) {
        return pr.findById(productId);
    }

    public Product getProductByUpc(String upc) {
        return pr.findByUpc(upc);
    }

    public List<Product> getProductsByName(String productName) {
        return pr.getProductsByName(productName);
    }

    public List<Product> getProductsByDept(String productDept) {
        return  pr.findAllByDepartment(productDept);
    }

    public List<Object[]> getProductCountByDepartment() {
        List<Object[]> data = pr.getProductCountByDepartment();
//        String json = "[";
//        for(int index = 0; index < data.toArray().length; index++) {
//            json += String.format("{\"%s\": %s}", data.get(index)[0], data.get(index)[1]);
//            if(index != data.toArray().length - 1) json+=", ";
//        }
//        json += "]";
//        return json;
        return data;

    }


        public Product addProduct(Product p) {
        if (getProductByUpc(p.getUpc()) == null) {
            return pr.save(p);
        } else {
            return null;
        }

    }

    @Transactional
    public Product updateProduct(Product p) {

        return em.merge(p);
    }

    public boolean removeProduct(Product p) {
        pr.delete(p);
        return false;
    }
}
