package com.example.demo.application.service;

import com.example.demo.application.dto.request.ProductRequest;
import com.example.demo.domain.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest req);
    List<Product> search(String keyword);
    List<Product> findAll();
}
