package com.spring.codeblog1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.codeblog1.model.Post;
import com.spring.codeblog1.repository.CodeblogRepository;
import com.spring.codeblog1.service.CodeblogService;


@Service
public class CodeblogServiceImpl implements CodeblogService {

	@Autowired
	CodeblogRepository cbr;
	@Override
	public List<Post> findAll() {
		return cbr.findAll();
	}

	@Override
	public Post findById(long id) {
		return cbr.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return cbr.save(post);
	}

}
