package com.example.demo.mapper;

import com.example.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    void insertProduct(Product product);
    List<Product> findAllProducts();
    Product findById(String id);
}
