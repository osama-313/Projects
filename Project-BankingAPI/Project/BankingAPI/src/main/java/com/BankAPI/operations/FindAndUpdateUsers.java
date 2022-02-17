package com.BankAPI.operations;

import java.io.IOException;
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
 * Servlet implementation class FindUsers
 */
public class FindAndUpdateUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindAndUpdateUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BankService BankS = new BankService();
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute("Role").equals("Admin") || session.getAttribute("Role").equals("Employee")) {

				response.getWriter().write(BankS.finduser().toString());
			} else {
				response.getWriter().write("You must be an Admin or an Employee to access this endpoint");
			}
		} else {
			response.getWriter().write("There was no user logged into the session");
		}

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			final String Whitch_User = request.getParameter("Which_User_You_want_to_Update");
			final String username = request.getParameter("username");
			final String password = request.getParameter("password");
			final String firstName = request.getParameter("firstName");
			final String lastName = request.getParameter("lastName");
			final String email = request.getParameter("email");
			Integer whichUser = Integer.parseInt(Whitch_User);
			if (session.getAttribute("Role").equals("Admin") || session.getAttribute("UserID").equals(whichUser)) {

				Role role_ = new Role();
				User userx = new User(whichUser, username, password, firstName, lastName, email, role_);
				new BankService().UpdateUser(userx, whichUser);
				response.getWriter().write("User was Updated Successfully !");
				response.getWriter().write(new BankService().finduserById(whichUser).toString());
			} else {
				String message = "You must be an Admin to update others info!";
				String json = new ObjectMapper().writeValueAsString(message);
				response.getWriter().write(json);
			}

		} else {
			response.getWriter().write("There was no user logged into the session");
		}
	}

}
