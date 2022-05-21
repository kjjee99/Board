package com.board.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.DTO.BoardDTO;
import com.board.Entity.Boards;
import com.board.Repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;
	Boards boardEntity;

	/* 게시판 리스트 가져오기 */
	public List<Boards> getList() {
		List<Boards> list = new ArrayList<>();
		list = boardRepository.findAll();
		return list;
	}
	
	/* 게시판 내용 가져오기 */
	public BoardDTO getPost(int id) {
//		Optional<Boards> data = repository.findById(board_id);
		Boards data = boardRepository.findByBoardId(id).get();
		BoardDTO post = BoardDTO.builder().title(data.getTitle()).content(data.getContent())
				.writer(data.getWriter()).regDate(data.getRegDate()).build();
//		data.ifPresent(board -> post.setBoard(board));
		return post;
	}

	/* 게시판 저장하기 */
	public boolean savePost(BoardDTO post) {
		try {
			if (post.getWriter() == null || post.getRegDate() == null) {
				log.error("null error");
				return false;
			} 
			
			if(post.getUpdateDate() != null) {
				Boards.builder().updateDate(post.getUpdateDate()).build();
			}
			boardEntity = Boards.builder().title(post.getTitle()).content(post.getContent())
					.writer(post.getWriter()).regDate(post.getRegDate()).build();
			System.out.println(boardEntity.getUpdateDate());
//			boardRepository.save(boardEntity);
				return true;

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	/* 게시판 수정하기 */
	public void modifyPost() {

	}

	/* 게시판 삭제하기 */
	public int deletePost(int id) {
		try {
			int result = boardRepository.deleteByBoardId(id);
			return result;
		}catch(Exception e) {
			log.error(e.getMessage());
		}
		return 0;
	}
}
