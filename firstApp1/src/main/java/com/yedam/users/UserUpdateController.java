package com.yedam.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.CommonUtil;

/**
 * Servlet implementation class EmpInsertController//103page
 */
@WebServlet("/UserUpdate")
public class UserUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	// 사원 수정 페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사번 파라미터
		String id = request.getParameter("id");
		
		// 단건 조회
		User users = UserDAO.getInstance().selectOne(id);

		// request에 결과 저장하고 view로 이동
		request.setAttribute("user", users);
		//request.setAttribute("jobList", UserDAO.getInstance().selectJobs());
		request.getRequestDispatcher("/WEB-INF/views/userUpdate.jsp")
		.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 인코딩
		request.setCharacterEncoding("utf-8");
		
		User users = new User();
		users.setId(request.getParameter("id"));
		users.setPassword(request.getParameter("password"));
		users.setName(request.getParameter("name"));
		users.setHobby(request.getParameter("hobby"));
		users.setGender(request.getParameter("gender"));
		users.setReligion(request.getParameter("religion"));
		users.setIntroduction(request.getParameter("introduction"));
		
		// 파라미터 전체 출력
		CommonUtil.printParameter(request);
		
		// 서비스 호출
		UserDAO.getInstance().update(users);
		
		// 페이지 이동
		// send 에는 context root 까지 적어줘야 함
		response.sendRedirect(request.getContextPath() + "/UserList");

	}

}
