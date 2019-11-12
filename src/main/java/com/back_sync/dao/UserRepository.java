package com.back_sync.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.back_sync.models.User;

@RepositoryRestResource
public interface UserRepository extends MongoRepository<User, String> {
	// Spring boot take care of our database calls.
}
