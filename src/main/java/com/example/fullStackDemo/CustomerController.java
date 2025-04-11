package com.example.fullStackDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository repo;

    @GetMapping("/")
    public String listCustomers(Model model) {
        model.addAttribute("customers", repo.findAll());
        model.addAttribute("customer", new Customer()); // allows loop to run when db is unpopulated
        return "index";
    }

    @PostMapping("/create")
    public String addCustomer(@ModelAttribute Customer customer) {
        System.out.println("Saving customer: " + customer);
        repo.save(customer);
        return "redirect:/";
    }


}
