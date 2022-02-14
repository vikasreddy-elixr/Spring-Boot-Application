package com.elixr.springbootapplication.repository;

import com.elixr.springbootapplication.model.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseRepository extends MongoRepository<Purchase, String> {

    List<Purchase> findPurchasesByProductName(Optional<String> productName);
}
