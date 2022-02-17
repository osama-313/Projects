package com.BankAPI.controller;

import static org.junit.Assume.assumeNoException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BankAPI.models.Account;
import com.BankAPI.models.AccountStatus;
import com.BankAPI.models.AccountType;
import com.BankAPI.models.Role;
import com.BankAPI.models.User;
import com.bank.service.BankService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.SQLException;


/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null)
		{
			if (session.getAttribute("Role").equals("Admin"))
			{
				int Roleid = 0;
				final String userId = request.getParameter("userId");
				final String username = request.getParameter("username");
				final String password = request.getParameter("password");
				final String firstName = request.getParameter("firstName");
				final String lastName = request.getParameter("lastName");
				final String email = request.getParameter("email");
				final String role = request.getParameter("role");
				int convertedtoint = Integer.parseInt(userId);

				if (role.equals("Admin"))
				{
					Roleid = 1;
				}
				else if (role.equals("Employee"))
				{
					Roleid = 2;
				}
				else if (role.equals("Standard"))
				{
					Roleid = 3;
				}
				else if (role.equals("Premium"))
				{
					Roleid = 4;
				}

				BankService Bankser = new BankService();
				Role role_ = new Role(Roleid,role);
				User user = new User(convertedtoint,username,password,firstName,lastName,email,role_);
				Bankser.insertUser(user);
				response.getWriter().write("User is Registered: User's info ->  ");
				response.getWriter().write(new BankService().finduserByName(username).toString());
				response.setStatus(201);
				
			}
			else
			{
				response.getWriter().write("you must be an Admin to enter this endpoint");
			}
		}
		else 
		{
			response.getWriter().write("There was no user logged into the session");
		}
		
	}

}
