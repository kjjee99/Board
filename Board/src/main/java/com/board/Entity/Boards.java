package com.board.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Table(name = "boards")
public class Boards {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="board_id")
	private int board_id;
	@Column(name = "writer")
	private String writer;
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	@Column(name = "reg_date")
	private Date reg_date;
	@Column(name = "update_date")
	private Date update_date;
	@Column(name = "delete_date")
	private Date delete_date;
	
	@Builder
	public Boards(String writer, String title, String content, Date regDate, Date updateDate, Date delDate) {
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.reg_date = regDate;
		this.update_date = updateDate;
		this.delete_date = delDate;
	}
}
