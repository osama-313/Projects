package com.p1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.p1.modles.User;
import com.p1.service.Service;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("useremail");
		String password = request.getParameter("password");
		Service s = new Service();
		User user = s.findByEmail(email);
		if (user != null) {
			if (password.equals(user.getPassword())) {

				request.getSession();
				response.getWriter().write("Welcome " + user.getFirstname() + " you're now loged in");
				HttpSession session = request.getSession(); // this create a session.
				session.setAttribute("username", user.getUsername());
				session.setAttribute("userid", user.getUserId());
				if (user.getRole().getRoleId() == 1)
				{
					response.sendRedirect("http://localhost:8088/project1/mangerpage.html");
				}else
				{
				response.sendRedirect("http://localhost:8088/project1/EmployeePage.html");
				}
			} else {
				response.getWriter().write("your username or password are not correct ");

			}
		} else {
			response.getWriter().write("your username or password are not correct");
		}
	}
}
