package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//
//HttpServlet 상속
//goGet/Post 메서드 오버라이딩
//@WebServlet 설정
//실행흐름을 개발자가 제어하는 것이 아닌 톰캣 컨테이너가 제어(IoC)
//싱글톤 :static 필드
//@WebServlet p86참조
//p93 서블릿 생성과 소멸(실행과정 설명) 한번 슥 해보고 샥 확인해볼것
@WebServlet(urlPatterns = {"/today","/day"}, loadOnStartup = 1, name = "today")
public class TodayServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		System.out.println(req.getRealPath("/"));
		System.out.println("doGet");
		PrintWriter out = resp.getWriter(); //응답관련작업 수행하는데 데이터를 출력하기 위한 											                         											출력스트림을 추출하는 메서드
		out.append("오늘은 " + new Date().toString());
		out.flush();
		try {
		Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		out.append(" 입니다.");
		System.in.read(); //System.out // 모니터
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
		resp.getWriter().append("today is " + new Date().toString());
	}
	
	@Override
	//서버 stop
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	//최초 한번만 메모리 로드될 때
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

}
