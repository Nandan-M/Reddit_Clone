package com.example.redditClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.redditClone.model.SubReddit;

@Repository
public interface SubRedditRepository extends JpaRepository<SubReddit, Long> {

}
