package com.example.redditClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.redditClone.model.User;

@Repository
public interface UserReposiotry extends JpaRepository<User, Long> {

}
