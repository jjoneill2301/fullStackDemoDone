package com.example.fullStackDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This allows auto indexing. This will auto update ID each new val
    private Long id; // Primary key, unique
    private String phone; // Integer because max value is in the 2 billions meaning it is perfect for a +1 phone num
    private String name;

    public Customer(String name, String phone, Long id) {
        this.name = name;
        this.phone = phone;
        this.id = id;
    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone + "";
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", tel=" + phone +
                ", name='" + name + '\'' +
                '}';
    }
}
