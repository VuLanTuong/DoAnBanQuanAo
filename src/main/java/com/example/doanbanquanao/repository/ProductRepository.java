package com.example.doanbanquanao.repository;


import com.example.doanbanquanao.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

    @Query(value = "SELECT image FROM product_image WHERE product_id = :productID", nativeQuery = true)
    String getImageByProductId(@Param("productID") Long productID);

    @Query("SELECT p from Product p where p.productID = :productID")
    Product findById(@Param("productID") Long productID);
}
