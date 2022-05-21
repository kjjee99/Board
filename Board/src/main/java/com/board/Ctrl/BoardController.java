package com.board.Ctrl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	/* 게시판 목록 보여주기 */
	@GetMapping("/list")
	public ModelAndView showList() {
		ModelAndView mav = new ModelAndView();
		List<Boards> list = service.getList();
		mav.addObject("posts", list);
		mav.setViewName("/post/boardList");
		return mav;
	}
	
	/* 게시글 작성하기 */
	@GetMapping("/post")
	public ModelAndView writePost() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("post", new BoardDTO());
		mav.setViewName("/post/post_write");
		return mav;
	}
	
	/* 작성한 게시글 저장하기 */
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
	
	/* 게시글 상세보기 */
	@GetMapping("/detail")
	public ModelAndView detailPost(@RequestParam("id") int postNumber) {
		ModelAndView mav = new ModelAndView();
		BoardDTO post = service.getPost(postNumber);
		mav.addObject("post", post);
		System.out.println(post.getRegDate());
		mav.setViewName("/post/post_detail");
		return mav;
	}
	
	/* 게시글 수정하기 */
	@GetMapping("/post/edit")
	public ModelAndView editPost(@RequestParam("id") int postNumber) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/post/post_update");
		return mav;
	}
	
	/* 수정한 게시글 업데이트하기 */
	@PutMapping("/post/edit.do")
	public ModelAndView updateToDB(BoardDTO board) {
		ModelAndView mav = new ModelAndView();
		board.setUpdateDate(new Date());
		service.savePost(board);
		mav.setViewName("redirect:/board/list");
		return mav;
	}
	
	/* 게시글 삭제하기 */
	@DeleteMapping("/post")
	public ModelAndView deletePost(@RequestParam("id") int postNumber) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/list");
		return mav;
	}
}
