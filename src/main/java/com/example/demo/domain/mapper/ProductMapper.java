package com.example.demo.domain.mapper;

import com.example.demo.domain.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    void insertProduct(Product product);
    List<Product> findAllProducts();
    Product findById(String id);
}
