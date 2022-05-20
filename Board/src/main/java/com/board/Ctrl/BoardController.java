package com.board.Ctrl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.DTO.BoardDTO;
import com.board.Entity.Boards;
import com.board.Service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService service;

	@GetMapping("/list")
	public ModelAndView showList() {
		ModelAndView mav = new ModelAndView();
		List<Boards> list = service.getList();
		mav.addObject("posts", list);
		mav.setViewName("/post/boardList");
		return mav;
	}
	
	@GetMapping("/post")
	public ModelAndView writePost() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("post", new BoardDTO());
		mav.setViewName("/post/post_write");
		return mav;
	}
	
	@PostMapping("/post.do")
	public ModelAndView doPost(@ModelAttribute BoardDTO post, RedirectAttributes re) {
		ModelAndView mav = new ModelAndView();
		Date date = new Date();
		post.setWriter("aaa");
		post.setRegDate(date);
		boolean result = service.savePost(post);
		if(result) {
			mav.setViewName("redirect:/board/list");
		}
		else {
			mav.setViewName("redirect:/board/post");
		}
		return mav;
	}
	
	@GetMapping("/detail")
	public ModelAndView detailPost(@RequestParam("id") int postNumber) {
		ModelAndView mav = new ModelAndView();
		BoardDTO post = service.getPost(postNumber);
		mav.addObject("post", post);
		mav.setViewName("/post/post_detail");
		return mav;
	}
}
