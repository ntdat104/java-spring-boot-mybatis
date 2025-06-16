package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductSearchRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByNameContainingOrDescriptionContaining(String name, String description);
}
