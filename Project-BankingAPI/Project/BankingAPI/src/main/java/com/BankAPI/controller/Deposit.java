package com.BankAPI.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BankAPI.models.Account;
import com.bank.service.BankService;

/**
 * Servlet implementation class Deposit
 */
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Deposit() {
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
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute("Role").equals("Admin")) {
				double FinalAmount = 0.0;
				final String Account_Id = request.getParameter("Account_Id");
				final String Amount = request.getParameter("Amount");
				int convertedtoint = Integer.parseInt(Account_Id);
				double convertedtoDouble = Double.parseDouble(Amount);

				BankService BankS = new BankService();
				BankS.getUserBalance(convertedtoint);
				Account account = BankS.getUserBalance(convertedtoint);
				FinalAmount = account.getBalance() + convertedtoDouble;
				BankS.updateAccountBalnce(FinalAmount, convertedtoint);
				response.getWriter().write("$" + Amount + " has been deposited  from Account # { " + Account_Id + " }");

			} else if (session != null) {
				double FinalAmount = 0.0;
				final String Account_Id = request.getParameter("Account_Id");
				final String Amount = request.getParameter("Amount");
				Integer convertedtoint = Integer.parseInt(Account_Id);
				double convertedtoDouble = Double.parseDouble(Amount);
				if (session.getAttribute("AccountID").equals(convertedtoint)) {
					BankService BankS = new BankService();
					BankS.getUserBalance(convertedtoint);
					Account account = BankS.getUserBalance(convertedtoint);
					FinalAmount = account.getBalance() + convertedtoDouble;
					BankS.updateAccountBalnce(FinalAmount, convertedtoint);
					response.getWriter()
							.write("$" + Amount + " has been deposited  from Account # { " + Account_Id + " }");
				} else {
					response.getWriter().write(
							"Your Account ID Does NOT Match With What We Have in Our Record, Pleace Try Agine !");

				}
			}
		} else {
			response.getWriter().write("There was no user logged into the session");

		}
	}

}
