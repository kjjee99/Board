package com.board.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "member")
@IdClass(memberID.class)
@ToString
public class Member{
	@Id
	@Column(name = "user_id")
	private String userID;
	@Column(name = "user_pw")
	private String userPW;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_phone")
	private String userPhone;
	@Column(name = "user_email")
	private String userEmail;
	@Column(name = "user_addr")
	private String userAddress;
	
	@Builder
	public Member(String id, String pw, String name, String phoneNumber, String email, String address) {
		this.userID = id;
		this.userPW = pw;
		this.userName = name;
		this.userPhone = phoneNumber;
		this.userEmail = email;
		this.userAddress = address;
	}
	
}
