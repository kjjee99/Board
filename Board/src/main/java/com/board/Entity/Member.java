package com.board.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "member")
@IdClass(memberID.class)
@ToString
public class Member{
	@Id
	@Column(name = "idx")
	private String idx;
	@Id
	@Column(name = "userID")
	private String userID;
	@Column(name = "userPW")
	private String userPW;
	@Column(name = "userName")
	private String userName;
	@Column(name = "userPhone")
	private String userPhone;
	@Column(name = "userEmail")
	private String userEmail;
	@Column(name = "userAddress")
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
