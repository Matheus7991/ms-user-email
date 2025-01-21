package com.ms.user.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.dto.UserRecordDto;
import com.ms.user.model.UserModel;
import com.ms.user.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	UserService userService = new UserService();
	
	@PostMapping("/users")
	public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto){
		
		var userModel = new UserModel();
		BeanUtils.copyProperties(userRecordDto, userModel);		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
	}

}
