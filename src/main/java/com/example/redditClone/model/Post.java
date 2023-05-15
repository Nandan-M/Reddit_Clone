package com.example.redditClone.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;import javax.persistence.criteria.Fetch;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	@NotBlank(message = "PostName should not be null")
	private String postName;
	@Nullable
	private String url;
	
	@Lob   //it refers to large large objects
	@Nullable
	private String description;
	private Integer voteCount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId" , referencedColumnName = "userId")
	private User user;
	private Instant createdDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id" , referencedColumnName = "id")
	private SubReddit subReddit;
	
	
	
	

}
