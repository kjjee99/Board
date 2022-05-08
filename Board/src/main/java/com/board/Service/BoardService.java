package com.board.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.DAO.BoardDAO;
import com.board.DTO.BoardDTO;
import com.board.Entity.Boards;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService {

	@Autowired
	BoardDAO boardDAO;
	Boards boardEntity;

	/* 게시판 리스트 가져오기 */
	public List<Boards> getList() {
		List<Boards> list = new ArrayList<>();
		list = boardDAO.findAll();
		return list;
	}

	/* 게시판 저장하기 */
	public boolean savePost(BoardDTO post) {
		try {
			if (post.getWriter() == null || post.getReg_date() == null) {
				log.error("null error");
				return false;
			} else {
				boardEntity = Boards.builder().title(post.getTitle()).content(post.getContent())
						.writer(post.getWriter()).regDate(post.getReg_date()).build();
				boardDAO.save(boardEntity);
				return true;
			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;

	}

	/* 게시판 수정하기 */
	public void modifyPost() {

	}

	/* 게시판 삭제하기 */
	public void deletePost() {

	}
}
