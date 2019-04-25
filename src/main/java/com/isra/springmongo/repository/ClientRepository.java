package com.isra.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isra.springmongo.domain.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

}
