package org.example.demo_jpa.practice.p1.service;

import org.example.demo_jpa.practice.p1.model.Customer;
import org.example.demo_jpa.practice.p1.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void remove(long id) {
        iCustomerRepository.remove(id);
    }
}
