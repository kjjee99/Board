package com.board.DTO;

import java.util.Date;

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
	private int board_id;
	private String writer;
	private String title;
	private String content;
	private Date reg_date;
	private Date update_date;
	private Date delete_date;
	
	@Builder
	public BoardDTO(String writer, String title, String content, Date regDate, Date updateDate, Date delDate) {
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.reg_date = regDate;
		this.update_date = updateDate;
		this.delete_date = delDate;
	}
}
