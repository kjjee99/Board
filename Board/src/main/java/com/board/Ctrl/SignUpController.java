package com.board.Ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.board.DAO.MemberDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="/account")
public class SignUpController {
	@Autowired
	private MemberDAO memberDAO;
	
	@GetMapping(path="/all")
	public @ResponseBody String getAlluser() {
		String mem = memberDAO.findAll().get(0).getUserID();
		log.info(mem, memberDAO.findAll().get(0));
		return memberDAO.toString();
	}
	
	@RequestMapping("/user")
	public ModelAndView inputBox() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signUp");
		return mv;
	}
	
	@GetMapping("/test")
	public String test() {
		System.out.println("test");
		return "test";
	}
}
