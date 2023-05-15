package com.example.redditClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.redditClone.model.VerificationToken;

public interface VerificationRepository extends JpaRepository<VerificationToken, Long>{

}
