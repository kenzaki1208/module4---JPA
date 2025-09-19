package org.example.demo_jpa.practice.p2.repository;

import org.example.demo_jpa.practice.p2.model.CustomerStore;

import java.util.List;

public interface ICustomerStoreRepository {
    boolean saveWithStoredProduce(CustomerStore customer);
}
