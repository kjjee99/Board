package com.board.Ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		mv.setViewName("/member/getMemberInfo");
		return mv;
	}
	
	@PostMapping("/signup-success")
	public ModelAndView doSignUp(@ModelAttribute("user") MemberDTO member) {
		ModelAndView mv = new ModelAndView();
		service.addMember(member);
		mv.setViewName("/member/signUp_success");
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", new MemberDTO());
		mav.setViewName("/member/login");
		return mav;
	}
	
	@PostMapping("/login.do")
	public ModelAndView doLogin(@ModelAttribute("user") MemberDTO member,RedirectAttributes re) {
		ModelAndView mav = new ModelAndView();
		String loginMessage = service.login(member);
		
		if(loginMessage.equals("true")) {
			//로그인 성공 시 로그인 버튼 -> 로그아웃으로 변경하기
			re.addFlashAttribute("btn", "로그아웃");
			mav.setViewName("redirect:/home");
		}
		else{
			re.addFlashAttribute("message", loginMessage);
			mav.setViewName("redirect:/account/login");
		}
		return mav;
	}
	
	//test
//	@GetMapping("/test")
//	public String test() {
//		System.out.println("test");
//		return "test";
//	}
}
