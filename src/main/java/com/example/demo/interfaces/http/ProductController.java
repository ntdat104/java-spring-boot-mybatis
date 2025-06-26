package com.example.demo.interfaces.http;

import com.example.demo.application.dto.request.ProductRequest;
import com.example.demo.domain.model.Product;
import com.example.demo.application.service.ProductService;
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