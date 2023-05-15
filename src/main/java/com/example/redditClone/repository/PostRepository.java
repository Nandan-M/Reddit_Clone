package com.example.redditClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.redditClone.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
