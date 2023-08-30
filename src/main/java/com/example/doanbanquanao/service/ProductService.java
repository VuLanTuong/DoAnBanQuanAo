package com.example.doanbanquanao.service;

import com.example.doanbanquanao.model.Product;
import com.example.doanbanquanao.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<Product> findAll(){
        return (List<Product>) productRepository.findAll();
    }
    public Product findById(Long productId) {return  (Product) productRepository.findById(productId);}
    public String getImageByProductId(Long productId){
        return (String) productRepository.getImageByProductId(productId);

    }
 }
