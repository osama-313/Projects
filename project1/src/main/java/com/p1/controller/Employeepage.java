package com.p1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Employeepage
 */
public class Employeepage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Employeepage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String button = request.getParameter("button");

		if ("button1".equals(button)) {
			response.sendRedirect("http://localhost:8088/project1/reimbursementform.html");
		} else if ("button2".equals(button)) {
			response.sendRedirect("http://localhost:8088/project1/requests.html");
		} else if ("button3".equals(button)) {
			response.getWriter().append("Served at:3 ");
		} else if ("button4".equals(button)) {
			// ???
		}else if ("button5".equals(button)) {
			response.sendRedirect("http://localhost:8088/project1/userinfo.html");
		}
	}

}
