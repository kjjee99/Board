package com.board.DTO;

import java.util.Date;
import java.util.Optional;

import com.board.Entity.Boards;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDTO {
	private int boardId;
	private String writer;
	private String title;
	private String content;
	private Date regDate;
	private Date updateDate;
	private Date deleteDate;
	
	@Builder
	public BoardDTO(String writer, String title, String content, Date regDate, Date updateDate, Date delDate) {
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.deleteDate = delDate;
	}
	
}
