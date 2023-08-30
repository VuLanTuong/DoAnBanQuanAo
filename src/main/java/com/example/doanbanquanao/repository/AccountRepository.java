package com.example.doanbanquanao.repository;



import com.example.doanbanquanao.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {

    @Query("SELECT a FROM Account a WHERE a.userName = ?1")
    Account findAccountByUserName(String username);

}
