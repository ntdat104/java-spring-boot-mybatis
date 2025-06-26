package com.example.demo.domain.repository;

import com.example.demo.domain.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductSearchRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByNameContainingOrDescriptionContaining(String name, String description);
}
