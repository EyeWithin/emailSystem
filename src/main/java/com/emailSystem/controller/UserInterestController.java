package com.emailSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emailSystem.dto.UserInterestDto;
import com.emailSystem.service.UserInterestService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserInterestController {
	
	@Autowired
		private UserInterestService userInterestService;
		
		
		@GetMapping("/test")
		public String testEndpoint() {
		return "User Interest service is running!";
	}
	    @GetMapping("/allUsers")
	    public ResponseEntity<List<UserInterestDto>> getAllUsers() {
	        return ResponseEntity.ok(userInterestService.getAllUsers());
	}

}
