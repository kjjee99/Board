package com.board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.board.Entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

}
