package com.board.Utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/*
 *	alert 화면을 띄우기 위한 클래스
 * */


public class ScriptUtils {
	
	//response setting
	public static void init(HttpServletResponse response) {
		response.setContentType("text/html; charset=utf8");
		response.setCharacterEncoding("utf8");
	}
	
	//alert
	public static void alert(HttpServletResponse response, String alertText) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>alert('"+alertText+"');</script>");
		out.flush();
	}
	
	//alert 후 원하는 페이지로 이동하기
	public static void alertAndMovePage(HttpServletResponse response, String alertText, String nextPage) throws IOException{
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>alert('"+alertText+"'); location.href='"+nextPage+"';</script>");
		out.flush();
	}
	
	//alert후 뒤로 가기
	public static void alertAndBackPage(HttpServletResponse response, String alertText) throws IOException{
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>alert('"+alertText+"'); history.go(-1); </script>");
		out.flush();
	}
}
