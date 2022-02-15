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
 * Servlet implementation class MemberJsonServlet
 */
@WebServlet("/MemberJsonServlet")
public class MemberJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());	
		// {"user_id": 100, "user_name": "박문수", "user_age": 25, "is_marriage": false}
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		List<Map<String,String>> list = dao.getMemberList();
		int totalCount = list.size();	// 전체 데이터 건수
		int cnt = 0;
		out.print("[");
		for(Map<String, String> map : list) {
			out.print("{\"name\": \"" + map.get("name") + "\", \"age\": \"" + map.get("age") + "\", \"score\": \"" + map.get("score") + "\", \"is_married\": false}\n");
			
			// 마지막 데이터에는 , 생략
			if(++cnt != totalCount) {
				out.print(", ");
			}
		}
		out.print("]");	// [{}, {}, {}] 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
