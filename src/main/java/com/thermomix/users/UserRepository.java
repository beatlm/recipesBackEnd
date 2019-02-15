package com.thermomix.users;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.thermomix.users.entity.User;

@RepositoryRestResource(collectionResourceRel = "result", path = "users") 
public interface UserRepository extends PagingAndSortingRepository<User,String> {
	
	User findByUsername(String username);
}
