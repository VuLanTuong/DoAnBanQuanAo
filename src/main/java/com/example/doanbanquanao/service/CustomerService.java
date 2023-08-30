package com.example.doanbanquanao.service;


import com.example.doanbanquanao.controller.SignUpRequest;
import com.example.doanbanquanao.model.Account;
import com.example.doanbanquanao.model.Contact;
import com.example.doanbanquanao.model.Customer;
import com.example.doanbanquanao.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    private PasswordEncoder passwordEncoder;


    @Autowired
    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder){
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }




    public void signUp(SignUpRequest request){
        final String encodedPassword = this.passwordEncoder.encode(request.getPassword());

        final Account account = new Account(request.getUsername(), encodedPassword);

        Customer customer = new Customer();
        customer.setAccount(account);
        customer.setFullName(request.getFullName());
        Contact contact = new Contact(request.getContact().getPhoneNumber(), request.getContact().getEmail());
        customer.setContact(contact);
        customer.setGender(request.isGender());

        this.customerRepository.save(customer);
    }


    public Customer updateByUsername(Customer updatedCustomer, String username) {
        Customer existingCustomer = customerRepository.findByAccountId(username);
        if (existingCustomer != null) {
            existingCustomer.setFullName(updatedCustomer.getFullName());
            existingCustomer.setGender(updatedCustomer.isGender());
            existingCustomer.getContact().setEmail(updatedCustomer.getContact().getEmail());
            existingCustomer.getContact().setPhoneNumber(updatedCustomer.getContact().getPhoneNumber());

        }
        return customerRepository.save(existingCustomer);

    }


}
