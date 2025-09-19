package org.example.demo_jpa.practice.p2.service;

import org.example.demo_jpa.practice.p2.model.CustomerStore;

import java.util.List;

public interface ICustomerStoreService {
    boolean saveWithStoredProduce(CustomerStore customer);
}
