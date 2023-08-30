package com.example.doanbanquanao.repository;



import com.example.doanbanquanao.model.Order;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<Order, String> {
}
