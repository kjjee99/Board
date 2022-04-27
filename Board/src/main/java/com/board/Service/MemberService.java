package com.board.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.DAO.MemberDAO;
import com.board.DTO.MemberDTO;
import com.board.Entity.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberService {
	@Autowired
	MemberDAO dao;
	Member entity;

	/* 회원 등록 */
//	@Transactional
	public void addMember(MemberDTO member) {
		entity = Member.builder()
				.id(member.getId()).pw(member.getPw())
				.name(member.getName()).email(member.getEmail())
				.phoneNumber(member.getPhone()).address(member.getAddress()).build();
		//회원 저장
		dao.save(entity);
	}
	
	/* 회원 로그인 */
	public boolean login(MemberDTO member) {
//		log.info(member.getId());
		entity = dao.findById(member.getId()).get();
//		log.error(entity.getUserID());
		//TODO: 입력한 ID가 DB에 존재하지 않을 경우
		
		//ID와 PW가 맞아 로그인 성공
		if(entity.getUserPW().equals(member.getPw())) {
			log.info("login success");
			return true;
		}
		//pw가 다를 경우
		else {
			log.error("password is difference");
			return false;
		}
	}
	
	/* 회원 탈퇴 */
	public void deleteMember (MemberDTO member) {
		//회원 조회
		entity = dao.findById(member.getId()).get();
		//회원 삭제
		dao.delete(entity);
	}
}
