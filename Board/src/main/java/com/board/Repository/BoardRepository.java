package com.board.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.board.Entity.Boards;

@Repository
public interface BoardRepository extends JpaRepository<Boards, String>{

	Optional<Boards> findByBoardId(int id);
	int deleteByBoardId(int id);



}
