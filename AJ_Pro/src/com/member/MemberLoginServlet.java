package com.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
request.setCharacterEncoding("UTF-8");
		
		String um_loginid =  request.getParameter("loginid");
		String um_passwd = request.getParameter("passwd");
		
		System.out.println(um_loginid);
		System.out.println(um_passwd);
		
		HashMap<String,String> map = new HashMap<>();
		map.put("um_loginid",um_loginid);
		map.put("um_passwd", um_passwd);
		
		MemberService service = new MemberService();
		MemberDTO dto = service.MemberLogin(map);
		String nextPage = "";
		
		if(dto!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", "로그인 성공");
//			session.setMaxInactiveInterval(5); // 5초가 지나면 더이상 Main.jsp에서 회원가입성공이 안뜨게한다.
			nextPage="Main.jsp";
		}else {
			HttpSession session = request.getSession();
			
			nextPage="MemberLogin.jsp";
		}
		response.sendRedirect(nextPage);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		
	}

}
