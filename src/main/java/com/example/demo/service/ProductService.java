package com.example.demo.service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest req);
    List<Product> search(String keyword);
    List<Product> findAll();
}
