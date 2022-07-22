package com.example.springboot.controllers;

import com.example.springboot.dao.CustomerDao;
import com.example.springboot.models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {
    private CustomerDao customerDao;

    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String get() {
        return "jfaekjfd";
    }

    @GetMapping("/customers")
    public String customers() {
        return "customers";
    }
    @PostMapping("/")
    public String post(){
        return "yes";
    }

    @PostMapping("/customers")
    public void saveCustomer(@RequestBody Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerDao.save(customer);

    }


}
