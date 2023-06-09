package com.java8.optional_class.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java8.optional_class.entity.User;
import com.java8.optional_class.service.UserServiceImpl;

@RestController
@RequestMapping("/UserController")
public class UserController {

	@Autowired
	private UserServiceImpl service;

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		Optional<User> opt = service.getById(id);
		if (opt.isPresent()) {
			User user = opt.get();
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
//---------------------------------------------------
	@GetMapping("/getUserById1/{id}")

	public Optional<String> getUserById1(@PathVariable int id){
		if (id ==0) {
			return Optional.empty();
		}
		return Optional.of("Ritika");
	}
//---------------------------------------------------

//public Optional<Integer> getUserById3(Integer id) {
//return Optional.ofNullable(id);
//}
	@GetMapping("/getUserById2/{id}")
	public Optional<Integer> getUserById2(@PathVariable Integer id) {
		if (id==0) {
			id=null;
		}
		return Optional.ofNullable(id);
	}
//----------------------------------------------------
	@GetMapping("/getUserById3/{id}")
	public String getUserById3(@PathVariable Integer id){
		Optional<User> opt = service.getById(id);
		opt.ifPresent(u -> System.out.println(u));
		return "ifPresent is running ..!";
}

//--------------------------------------------------
	@GetMapping("/getUserById4/{id}")
	public  User getUserById4(@PathVariable Integer id) {
		Optional<User> opt =  service.getById(id);
		return opt.orElse(new User());
	}

//-------------------------------------------------	
	@GetMapping("/getUserById5/{id}")
	public ResponseEntity<User> getUserById5(@PathVariable Integer id){
		Optional<User> opt = service.getById(id);
		User user = opt.orElseGet(() -> new User());
		return ResponseEntity.ok(user);
	}	
//-------------------------------------------------
@GetMapping("/getUserById6/{id}")
public ResponseEntity<?> getUserById6(@PathVariable Integer id) throws Exception{
	Optional<User> opt = service.getById(id);
	User user=null;
	try {
		 user = opt.orElseThrow(()->new Exception("User not found"));
	}catch(Exception e) {
		
		return ResponseEntity.ok("User not found");
	}
	return ResponseEntity.ok(user);
  }
}
