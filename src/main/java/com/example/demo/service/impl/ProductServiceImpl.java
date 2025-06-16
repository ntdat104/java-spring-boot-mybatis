package com.example.demo.service.impl;

import com.example.demo.dto.ProductRequest;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.ProductSearchRepository;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductSearchRepository searchRepository;

    @Override
    public Product createProduct(ProductRequest req) {
        Product p = new Product();
        p.setId(UUID.randomUUID().toString());
        p.setName(req.getName());
        p.setDescription(req.getDescription());
        p.setPrice(req.getPrice());

        productMapper.insertProduct(p);
        searchRepository.save(p); // index in Elasticsearch

        return p;
    }

    @Override
    public List<Product> search(String keyword) {
        return searchRepository.findByNameContainingOrDescriptionContaining(keyword, keyword);
    }

    @Override
    public List<Product> findAll() {
        return productMapper.findAllProducts();
    }
}
