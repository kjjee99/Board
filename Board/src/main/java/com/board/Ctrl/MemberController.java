package com.board.Ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ModelAndView getInfoToSignUp() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new MemberDTO());
		mv.setViewName("getMemberInfo");
		return mv;
	}
	
	@PostMapping("/signup-success")
	public ModelAndView doSignUp(@ModelAttribute("user") MemberDTO member) {
		ModelAndView mv = new ModelAndView();
		service.addMember(member);
		mv.setViewName("signUp_success");
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", new MemberDTO());
		mav.setViewName("login");
		return mav;
	}
	
	@PostMapping("/login.do")
	public ModelAndView doLogin(@ModelAttribute("user") MemberDTO member) {
		ModelAndView mav = new ModelAndView();
		boolean isLoginComplete = service.login(member);
		//TODO: 로그인 성공 시 로그인 버튼 -> 로그아웃으로 변경하기
		if(isLoginComplete)	mav.setViewName("redirect:/home");
		else				mav.setViewName("redirect:/account/login");
		return mav;
	}
	
	//test
//	@GetMapping("/test")
//	public String test() {
//		System.out.println("test");
//		return "test";
//	}
}
