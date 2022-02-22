package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpInsertController//103page
 */
@WebServlet("/EmpInsert")
public class EmpInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = new Employee();
		emp.setEmployeeId(Integer.parseInt(request.getParameter("employee_id")));
		emp.setLastName(request.getParameter("last_name"));
		emp.setEmail(request.getParameter("email"));
		emp.setJobId(request.getParameter("job_id"));
		emp.setHireDate(request.getParameter("hire_date"));
		EmployeesDAO.getInstance().insert(emp);
		
//		response.sendRedirect("/firstApp/emp/empList.jsp");
		request.getRequestDispatcher("/emp/empList.jsp")
				.forward(request,response);
	}

}
