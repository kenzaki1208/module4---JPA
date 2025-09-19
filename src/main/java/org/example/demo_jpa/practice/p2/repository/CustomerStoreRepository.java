package org.example.demo_jpa.practice.p2.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.example.demo_jpa.practice.p2.model.CustomerStore;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class CustomerStoreRepository implements ICustomerStoreRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public boolean saveWithStoredProduce(CustomerStore customer) {
        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        return query.executeUpdate() != 0;
    }
}
