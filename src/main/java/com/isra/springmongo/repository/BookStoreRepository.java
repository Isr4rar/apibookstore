package com.isra.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.isra.springmongo.domain.BookStore;

public interface BookStoreRepository extends MongoRepository<BookStore, String> {

}
