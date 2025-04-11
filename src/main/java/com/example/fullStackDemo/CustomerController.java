package com.example.fullStackDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

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

    @GetMapping("/searchName")
    public String searchName(@RequestParam("query") String query, Model model) {
        List<Customer> customers = repo.findByNameContainsIgnoreCase(query);
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer());
        return "index"; // Return to the same page with search results
    }


    @GetMapping("/searchPhone")
    public String searchPhone(@RequestParam("query") String query, Model model) {
        List<Customer> customers = repo.findByPhone(query);
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer());
        return "index"; // Return to the same page with search results
    }

    @GetMapping("/searchPhone2")
    public  String searchStartPhone(@RequestParam("query") String query, Model model) {
        List<Customer> customers = repo.findByPhoneStartingWith(query);
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer());
        return "index";
    }

    @PostMapping("/rmAll")
    public String deleteAll() {
        repo.deleteAll();
        return "redirect:/";
    }
}
