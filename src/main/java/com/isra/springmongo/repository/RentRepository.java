package com.isra.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isra.springmongo.domain.Rent;

@Repository
public interface RentRepository extends MongoRepository<Rent, String>{

}
