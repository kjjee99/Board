package com.board.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.DAO.MemberDAO;
import com.board.DTO.MemberDTO;
import com.board.Entity.Member;

@Service
public class MemberService {
	@Autowired
	MemberDAO dao;
	Member entity;

	public void addMember(MemberDTO member) {
		entity = Member.builder()
				.id(member.getId()).pw(member.getPw())
				.name(member.getName()).email(member.getEmail())
				.phoneNumber(member.getPhone()).address(member.getAddress()).build();
		dao.save(entity);
	}
}
