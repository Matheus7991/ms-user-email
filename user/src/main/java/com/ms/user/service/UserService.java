package com.ms.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.user.model.UserModel;
import com.ms.user.producer.UserProducer;
import com.ms.user.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository; 
	
	@Autowired
	UserProducer userProducer;
	
	@Transactional
	public UserModel save(UserModel userModel) {
		
		userModel = userRepository.save(userModel);
		userProducer.publishMessageEmail(userModel);
		
		return userModel;
	}

}
