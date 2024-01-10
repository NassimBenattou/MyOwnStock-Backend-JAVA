package org.aelion.product.products;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl {
    public List<Product> findAll(){
        var list = new ArrayList<Product>();
        var product = new Product("1ea77", "Pommes", 10);
        list.add(product);
        product = new Product("234ff", "Pâtes", 5);
        list.add(product);
        product = new Product("ff2e3", "Raviolis", 5);
        list.add(product);
        return list;
    }
}
