package com.spring.codeblog1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.codeblog1.model.Post;

public interface CodeblogRepository extends JpaRepository<Post, Long>{

}
