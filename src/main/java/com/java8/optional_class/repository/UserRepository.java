package com.java8.optional_class.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java8.optional_class.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//	Optional<User> findById(int id);
}
