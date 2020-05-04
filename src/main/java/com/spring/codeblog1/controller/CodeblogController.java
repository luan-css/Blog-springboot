package com.spring.codeblog1.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeblog1.model.Post;
import com.spring.codeblog1.service.CodeblogService;

@Controller
public class CodeblogController {

	@Autowired
	CodeblogService codeblogService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = codeblogService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = codeblogService.findById(id);
		mv.addObject("post", post);
		return mv;
	}
	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public ModelAndView getPostForm() {
		ModelAndView mv = new ModelAndView("postForm");
		mv.addObject(new Post());
		return mv;
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public ModelAndView savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("postForm");
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos");
			return mv;
		}
		ModelAndView mv2 = new ModelAndView("redirect:/");
		post.setData(LocalDate.now());
		codeblogService.save(post);
		return mv2;
	}
}
