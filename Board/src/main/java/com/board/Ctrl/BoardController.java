package com.board.Ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
		List<Boards> list = service.showList();
		mav.addObject("posts", list);
		mav.setViewName("/post/boardList");
		return mav;
	}
}
