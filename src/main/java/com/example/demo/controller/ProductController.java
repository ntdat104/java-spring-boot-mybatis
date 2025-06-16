package com.example.demo.controller;

import com.example.demo.dto.ProductRequest;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product create(@RequestBody ProductRequest req) {
        return productService.createProduct(req);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String keyword) {
        return productService.search(keyword);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }
}