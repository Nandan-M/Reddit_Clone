package com.example.redditClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.redditClone.model.Comment;

@Repository
public interface CommentRepositry extends JpaRepository<Comment, Long> {

}
