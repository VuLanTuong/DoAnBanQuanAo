package com.example.doanbanquanao.controller;



import com.example.doanbanquanao.model.Account;
import com.example.doanbanquanao.model.Customer;
import com.example.doanbanquanao.model.Product;
import com.example.doanbanquanao.repository.AccountRepository;
import com.example.doanbanquanao.repository.CustomerRepository;
import com.example.doanbanquanao.repository.ProductRepository;
import com.example.doanbanquanao.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
public class CustomerController {

    @Autowired private CustomerService customerService;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private AccountRepository accountRepository;
    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private SecurityContextRepository securityContextRepository;



    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("signUpRequest", new SignUpRequest());
        return "signup";
    }

    @GetMapping("/homepage")
    public String home(Model model)  {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        Account account = accountRepository.findAccountByUserName(authentication.getName());
       model.addAttribute("authenticated", true);



        Customer customer = customerRepository.findByAccountId(authentication.getName());




        List<Product> productList = (List<Product>) productRepository.findAll();


        model.addAttribute("customer", customer);
        model.addAttribute("products", productList);
        model.addAttribute("account", account);


        return "homepage";
    }

    @PostMapping("/")
    public String postHome(){
        return "homepage";
    }


    @GetMapping("/index")
    public String index() {
        return "index";
    }



    @PostMapping("/signup/save")
    public String saveCustomer(SignUpRequest request, Model model){
//        log.info("{}{}{}{}", request.getUsername(), request.getPassword(), request.getFullName(), request.isGender());


        customerService.signUp(request);
        Customer customer = customerRepository.findByAccountId(request.getUsername());

        model.addAttribute("customer", customer);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    @PostMapping("/login/account")
    public String getAccount(Account account, HttpServletRequest request, HttpServletResponse response
    ) {
//        log.info("{} {}", account.getPassWord(), account.getUserName());

        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUserName(), account.getPassWord()));
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
        securityContextRepository.saveContext(context, request, response);



        return "redirect:/homepage";
    }


    @GetMapping("/information")
    public String userInformation(Model model) {
        boolean editing = false;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = customerRepository.findByAccountId(authentication.getName());
        model.addAttribute("editing", editing);
        model.addAttribute("customer", customer);



        return "information";
    }

    @RequestMapping( value = "/information/{username}", method = RequestMethod.POST)
    public String updateCustomer(@PathVariable(name = "username") String username, Customer updatedCustomer) {

        log.info("{}", updatedCustomer.getFullName());


            customerService.updateByUsername(updatedCustomer, username);
            return "redirect:/information";
        }

        // Redirect back to the information page or any other appropriate page



//    @PostMapping("/login")
//    public String authenticate(HttpServletRequest request, Model model) {
//        LoginService loginService = new LoginService();
//        String username = request.getParameter("userName");
//        String password = request.getParameter("passWord");
//        boolean isAuthenticated = loginService.authenticate(username, password);
//
//        if (isAuthenticated) {
//            // Redirect to the homepage or any other authenticated page
//            return "redirect:/homepage";
//        } else {
//            // Authentication failed, add an error message and return to the login page
//            model.addAttribute("errorMessage", "Invalid username or password");
//            return "login";
//        }
    }


//    @PostMapping("/login")
//    public String loginWithAuthenticate(@RequestParam("username") String username, @RequestParam("password") String password) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password)
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // Authentication successful, redirect to a secure page
//        return "redirect:/secure-page";
//    }



