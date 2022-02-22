package com.yedam;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpListController
 */
@WebServlet("/adm/EmpListController")
public class EmpListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Employee> list = EmployeesDAO.getInstance().selectAll();
		request.setAttribute("list",list);
		request.getRequestDispatcher("/WEB-INF/views/empView.jsp").forward(request,response);
	}

}
