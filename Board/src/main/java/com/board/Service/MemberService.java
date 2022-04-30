package com.board.Service;

import java.util.NoSuchElementException;

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
	public String login(MemberDTO member) {
		try{
			entity = dao.findById(member.getId()).get();
			//ID와 PW가 맞아 로그인 성공
			if(entity.getUserPW().equals(member.getPw())) {
				log.info("login success");
				return "true";
			}
			//pw가 다를 경우
			else {
				//TODO: alert 설정
				log.error("password is difference");
				return "비밀번호가 일치하지 않습니다.";
			}
		}
		//입력한 ID가 DB에 존재하지 않을 경우
		catch(NoSuchElementException e) {
			log.error("일치하는 아이디가 존재하지 않습니다.");
		}catch(NullPointerException e){
			log.error("일치하는 아이디가 조재하지 않습니다.");
		}
		return "일치하는 정보가 없습니다.";
		
	}
	
	/* 회원 탈퇴 */
	public void deleteMember (MemberDTO member) {
		//회원 조회
		entity = dao.findById(member.getId()).get();
		//회원 삭제
		dao.delete(entity);
	}
}
