package com.java8.optional_class.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java8.optional_class.entity.User;
import com.java8.optional_class.repository.UserRepository;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserRepository repo;
	
	public Optional<User> getById(int id){
		return repo.findById(id);
	}
}
