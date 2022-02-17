package com.BankAPI.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BankAPI.models.Role;
import com.BankAPI.models.User;
import com.bank.service.BankService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public String String(String password) {
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");

		BankService bs = new BankService();
		User user = bs.finduserByName(username);
		if (user != null) {
			if (password.equals(user.getPassword())) {

				request.getSession();
				response.getWriter().write("Welcome " + user.getUsername() + " you're now loged in");
				HttpSession session = request.getSession(); // this create a session.
				session.setAttribute("UserID", user.getId());
				session.setAttribute("user", username);
				session.setAttribute("Role", user.getRole().getRole());

				//session.setAttribute("Role", );

			} else {
				response.getWriter().write("your username or password are not correct dd");

			}
		} else {
			response.getWriter().write("your username or password are not correct");
		}
	}

}
