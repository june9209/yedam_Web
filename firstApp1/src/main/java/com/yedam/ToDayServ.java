package com.yedam;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ToDayServ")
public class ToDayServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ToDayServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter()
		.append("<html>")
		.append("<head>")
		.append("<title>today</title>")
		.append("</head>")
		.append("<body>")
		.append("today : " + new Date())
		.append("</body>")
		.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
