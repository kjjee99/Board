package com.board.DAO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Member {
	private String id;
	private String pw;
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	
	@Builder
	public Member(String id, String pw, String name, String phoneNumber, String email, String address) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}
	
}
