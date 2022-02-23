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

@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      response.getWriter().append("Served at: ").append(request.getContextPath());
      response.setContentType("text/html;charset=utf-8");
      MemberDAO dao = new MemberDAO();
      List<Map<String,String>> list = dao.getMemberList();
      
      PrintWriter out = response.getWriter();
      out.print("<h3>Hello,World</h3>");
      out.print("");
      out.print("<tr>");
      for(Map<String, String> map : list) {
         out.print("<td>" + map.get("name") + ", " + map.get("age") + ", " + map.get("score")+"</td>");
      }
      out.print("</tr>");
//      out.print("<ul><li>Apple</li><li>Banana</li><li>Cherry</li></ul>");
      }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
