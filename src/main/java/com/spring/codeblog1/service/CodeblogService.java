package com.spring.codeblog1.service;

import java.util.List;

import com.spring.codeblog1.model.Post;

public interface CodeblogService {
	List<Post> findAll();
	Post findById(long id);
	Post save(Post post);
}
