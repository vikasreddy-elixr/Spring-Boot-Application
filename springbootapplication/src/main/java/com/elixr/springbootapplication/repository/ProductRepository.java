package com.elixr.springbootapplication.repository;

import com.elixr.springbootapplication.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Products, String> {

}
