package com.board.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.board.Entity.Member;

@Repository
public interface MemberDAO extends JpaRepository<Member, String> {

}
