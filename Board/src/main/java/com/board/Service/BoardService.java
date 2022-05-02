package com.board.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.DAO.BoardDAO;
import com.board.Entity.Boards;

@Service
public class BoardService {
	
	@Autowired
	BoardDAO boardDAO;
	Boards boardEntity;
	
	/*게시판 리스트 출력*/
	public List<Boards> showList() {
		List<Boards> list = new ArrayList<>();
		list = boardDAO.findAll();
		return list;
	}
}
