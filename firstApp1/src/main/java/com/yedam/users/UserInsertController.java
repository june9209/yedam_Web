package com.yedam.users;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.CommonUtil;

/**
 * Servlet implementation class EmpInsertController//103page
 */
@WebServlet("/UserInsert")
public class UserInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	// 사원 등록 페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/userInsert.jsp")
		.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 인코딩
		request.setCharacterEncoding("utf-8");
		
		User user = new User();
		user.setId(request.getParameter("id"));
		user.setPassword(request.getParameter("pwd"));
		user.setName(request.getParameter("name"));
		
		String[] hobbyArr = request.getParameterValues("hobby");
		String hobby = "";
		for (int i=0; i<hobbyArr.length; i++) {
			hobby = hobby + hobbyArr[i];
			
			if (i != hobbyArr.length -1) {
				hobby = hobby + ", ";
			}
		}
		user.setHobby(hobby);
		user.setGender(request.getParameter("gender"));
		user.setReligion(request.getParameter("religion"));
		user.setIntroduction(request.getParameter("introduction"));
		
		// 파라미터 전체 출력
//		CommonUtil.printParameter(request);
		// 서비스 호출
		UserDAO.getInstance().insert(user);
		
		// 페이지 이동
		// send 에는 context root 까지 적어줘야 함
		response.sendRedirect(request.getContextPath() + "/UserList");

	}

}
