package com.example.crudjwt.controller;

import com.example.crudjwt.model.Product;
import com.example.crudjwt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Get all products (USER & ADMIN)
    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    // Get one product by ID (USER & ADMIN)
    @GetMapping("/{id}")
    public Optional<Product> getOne(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    // Create product (ADMIN only)
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Update product (ADMIN only)
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        Product existing = productRepository.findById(id).orElseThrow();
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        return productRepository.save(existing);
    }

    // Delete product (ADMIN only)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "Product deleted!";
    }
}
