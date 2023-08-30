package com.example.doanbanquanao.controller;

import com.example.doanbanquanao.model.Account;
import com.example.doanbanquanao.model.Customer;
import com.example.doanbanquanao.model.Product;
import com.example.doanbanquanao.repository.AccountRepository;
import com.example.doanbanquanao.repository.CustomerRepository;
import com.example.doanbanquanao.repository.ProductRepository;
import com.example.doanbanquanao.service.CustomerService;
import com.example.doanbanquanao.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SecurityContextRepository securityContextRepository;

    @GetMapping("/products")
    public String showProductList(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Account account = accountRepository.findAccountByUserName(authentication.getName());
        model.addAttribute("authenticated", true);

        Customer customer = customerRepository.findByAccountId(authentication.getName());

        List<Product> productList = (List<Product>) productRepository.findAll();

        model.addAttribute("customer", customer);
        model.addAttribute("products", productList);
        model.addAttribute("account", account);

        List<Product> listProduct = productService.findAll();
        model.addAttribute("listProduct", listProduct);
        return "products";
    }

    @GetMapping("/product_detail/{id}")
    public String showProductDetail(@PathVariable("id") Long productId, Model model) {
        // Product product = productService.findById(productId);
        // model.addAttribute("product", product);

        return "product_detail";
    }

}
