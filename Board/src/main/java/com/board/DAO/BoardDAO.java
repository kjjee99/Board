package com.board.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.board.Entity.Boards;

@Repository
public interface BoardDAO extends JpaRepository<Boards, String>{

}
