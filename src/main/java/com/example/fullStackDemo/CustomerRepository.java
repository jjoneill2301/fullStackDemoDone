package com.example.fullStackDemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // extends keyword allows for the inheritance of the following CRUD methods: save, findbyId, findAll, delete, count
    // Save replaces create and update
    }
