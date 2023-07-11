package com.example.demo.datacontrol;

import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class InitialLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    public InitialLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save some sample products
        Product product1 = new Product("Product 1", "Category1", 10.0, "123");
        Product product2 = new Product("Product 2", "Category2", 15.0, "456");

        List<Product> products = Arrays.asList(product1, product2);
        productRepository.saveAll(products);
    }
}