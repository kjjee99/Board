package com.board.Ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.board.DTO.MemberDTO;
import com.board.Service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="/account")
public class MemberController {
	@Autowired
	MemberService service;
	
	@RequestMapping("/user")
	public ModelAndView inputBox() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new MemberDTO());
		mv.setViewName("signUp");
		return mv;
	}
	
	@PostMapping("/complete")
	public ModelAndView complete(@ModelAttribute("user") MemberDTO member) {
		ModelAndView mv = new ModelAndView();
		log.info(member.getId());
		log.info(member.getPw());
		service.addMember(member);
		mv.setViewName("signUp_complete");
		return mv;
	}
	
	//test
//	@GetMapping("/test")
//	public String test() {
//		System.out.println("test");
//		return "test";
//	}
}
