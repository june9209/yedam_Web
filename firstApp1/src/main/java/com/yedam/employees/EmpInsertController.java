package com.yedam.employees;

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
@WebServlet("/EmpInsert")
public class EmpInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	// 사원 등록 페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("jobList", EmployeesDAO.getInstance().selectJobs());
		request.getRequestDispatcher("/WEB-INF/views/empInsert.jsp")
		.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 인코딩
		request.setCharacterEncoding("utf-8");
		
		Employee emp = new Employee();
		emp.setEmployeeId(Integer.parseInt(request.getParameter("employee_id")));
		emp.setLastName(request.getParameter("last_name"));
		emp.setEmail(request.getParameter("email"));
		emp.setJobId(request.getParameter("job_id"));
		emp.setHireDate(request.getParameter("hire_date"));
		
		// 파라미터 전체 출력
		CommonUtil.printParameter(request);
		
		// 서비스 호출
		EmployeesDAO.getInstance().insert(emp);
		
		// 페이지 이동
		// send 에는 context root 까지 적어줘야 함
		response.sendRedirect(request.getContextPath() + "/EmpList");

	}

}
