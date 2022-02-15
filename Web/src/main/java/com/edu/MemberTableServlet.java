package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberTableServelet
 */
@WebServlet("/MemberTableServlet")
public class MemberTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		테이블 형식으로 화면에 출력
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		List<Map<String,String>> list = dao.getMemberList();
		
		PrintWriter out = response.getWriter();
		out.print("<h3>Hello,World</h3>");
		out.print("<table border = 1>");
		out.print("<thead><tr><th>이름</th><th>나이</th><th>점수</th></thead>");
		out.print("<tbody>");
		for(Map<String, String> map : list) {
			out.print("<tr>");
			out.print("<td>" + map.get("name") + "</td><td>" + map.get("age") + "</td><td>" + map.get("score") + "</td>");
			out.print("</tr>");
		}
		out.print("</tbody></table>");
		out.print("</ul>");
		out.print("<ul><li>Apple</li><li>Banana</li><li>Cherry</li></ul>");
		}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
