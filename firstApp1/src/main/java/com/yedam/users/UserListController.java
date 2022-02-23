package com.yedam.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpListController
 * 
 * 1. 요청 파악, validation
 * 2. 서비스 처리(DB)
 * 3. 결과 저장
 * 4. view 페이지로 이동(forward | sendRedirect)
 * 
 */
@WebServlet("/UserList")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// request 정보
		System.out.println("ContextPath : " + request.getContextPath());
		System.out.println("User-Agent : " + request.getHeader("User-Agent"));		
		System.out.println("Client IP : " + request.getRemoteAddr());
		System.out.println("질의 문자열 : " + request.getQueryString());
		System.out.println("uri : " + request.getRequestURI());
		System.out.println("RealPath : " + request.getRealPath("/") );
		
		List<User> list = UserDAO.getInstance().selectAll();
		request.setAttribute("userlist",list);
		request.getRequestDispatcher("/WEB-INF/views/userView.jsp").forward(request,response);
	}

}
