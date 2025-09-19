package org.example.demo_jpa.practice.p2.service;

import org.example.demo_jpa.practice.p2.model.CustomerStore;
import org.example.demo_jpa.practice.p2.repository.ICustomerStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerStoreService implements ICustomerStoreService {
    @Autowired
    private ICustomerStoreRepository iCustomerRepository;
    
    @Override
    public boolean saveWithStoredProduce(CustomerStore customer) {
        return iCustomerRepository.saveWithStoredProduce(customer);
    }
}
