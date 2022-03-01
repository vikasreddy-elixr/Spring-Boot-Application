package com.elixr.springbootapplication.repository;

import com.elixr.springbootapplication.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    boolean existsUserByUserName(String userName);
}
