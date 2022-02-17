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


public class FindUserById extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public FindUserById() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute("Role").equals("Admin") || session.getAttribute("Role").equals("Employee")|| session.getAttribute("UserID").equals(RequestHelper.UserID(request, response)))
			{

				String json = new ObjectMapper().writeValueAsString(RequestHelper.processGet(request, response));
				response.getWriter().write(json);
			} else {
				response.getWriter().write("You must be an Admin or an Employee to access this endpoint");
			}
		} else {
			response.getWriter().write("There was no user logged into the session");
		}

	}

}