package org.aelion.product.products;

import org.springframework.stereotype.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl {
    private static final String FILE_PATH = "products.ser";

    private final List<Product> productList;

    public ProductServiceImpl() {
        this.productList = loadProductsFromFile();
    }

    public List<Product> findAll() {
        return new ArrayList<>(productList);
    }

    public void addProduct(Product product) {
        if (productList.stream().noneMatch(p -> p.getId().equals(product.getId()))) {
            productList.add(product);
            System.out.println("Produit ajouté avec succès.");
            saveProductsToFile();
        } else {
            System.out.println("L'ID du produit existe déjà.");
        }
    }

    private List<Product> loadProductsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            return createDefaultProductList();
        }
    }

    private void saveProductsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Product> createDefaultProductList() {
        List<Product> defaultList = new ArrayList<>();
        defaultList.add(new Product("1ea77", "Pommes", 10));
        defaultList.add(new Product("234ff", "Pâtes", 5));
        defaultList.add(new Product("ff2e3", "Raviolis", 5));
        return defaultList;
    }
}
