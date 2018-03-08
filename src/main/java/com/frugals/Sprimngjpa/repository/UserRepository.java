package com.frugals.Sprimngjpa.repository;

import com.frugals.Sprimngjpa.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Sanju on 08-Mar-18.
 */

public interface UserRepository extends MongoRepository<User,Integer> {
    public List<User> findByName(String name);

}