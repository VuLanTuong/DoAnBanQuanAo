package com.example.doanbanquanao.repository;


import com.example.doanbanquanao.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {


    @Query("SELECT c FROM Customer c WHERE c.account.userName = ?1")
    Customer findByAccountId(String accountId);

}
