package com.board.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String address;
	
//	@Builder
//	public MemberDTO(String id, String pw) {
//		this.id = id;
//		this.pw = pw;
//	}
	
	@Builder
	public MemberDTO(String id, String pw, String name, String phone, String email, String address) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
}
