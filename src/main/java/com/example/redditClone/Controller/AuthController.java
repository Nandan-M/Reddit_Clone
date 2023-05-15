package com.example.redditClone.Controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.redditClone.dto.RegisterRequest;
import com.example.redditClone.model.User;
import com.example.redditClone.repository.UserReposiotry;
import com.example.redditClone.service.AuthService;



@RequestMapping("/api/auth")
@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserReposiotry userRepo;
	
	@PostMapping("/signup")
	public void signUp(@RequestBody RegisterRequest registerRequest) {
		User user  = new User();
		user.setEmail(registerRequest.getEmail());
		user.setUserName(registerRequest.getUserName());
		user.setPassword(registerRequest.getPassword());
		user.setCreated(Instant.now());
		user.setEnabled(false);
		
		userRepo.save(user);
		
	}
	
	@GetMapping("/working")
	public String get() {
		return "Nandan working";
	}
}
