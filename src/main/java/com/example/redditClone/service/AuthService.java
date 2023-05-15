package com.example.redditClone.service;

import java.time.Instant;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.redditClone.dto.RegisterRequest;
import com.example.redditClone.exception.SpringRedditException;
import com.example.redditClone.model.NotificationEmail;
import com.example.redditClone.model.User;
import com.example.redditClone.model.VerificationToken;
import com.example.redditClone.repository.UserReposiotry;
import com.example.redditClone.repository.VerificationRepository;

//using constructor injection so added all arg
@Service
public class AuthService {
	

	@Autowired
	private UserReposiotry userRepository;
	
	
	@Autowired
	private VerificationRepository verificationRepository;
	
	@Autowired
	private MailService mailService;

	@Transactional
	public void signUp(RegisterRequest registerRequest) throws SpringRedditException {
		User user  = new User();
		user.setEmail(registerRequest.getEmail());
		user.setUserName(registerRequest.getUserName());
		user.setPassword( registerRequest.getPassword());
		user.setCreated(Instant.now());
		user.setEnabled(false);
		
		userRepository.save(user);
		
		String token = generateVerificationToken(user);
		mailService.sendMail(new NotificationEmail("active the mail" + user.getEmail()+","+ token));
	}

	private String generateVerificationToken(User user) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		
		verificationToken.setToken(token);
		verificationToken.setUser(user);
		
		verificationRepository.save(verificationToken);
		return token;
	}
}
