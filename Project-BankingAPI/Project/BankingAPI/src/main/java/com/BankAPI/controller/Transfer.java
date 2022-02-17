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
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Transfer() {
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
				final String sourceAccountId = request.getParameter("sourceAccountId");
				final String targetAccountId = request.getParameter("targetAccountId");
				final String Amount = request.getParameter("Amount");

				int convertedtoint = Integer.parseInt(sourceAccountId);
				int convertedtoint2 = Integer.parseInt(targetAccountId);
				double convertedtoDouble = Double.parseDouble(Amount);

				BankService BankS = new BankService();

				BankS.getUserBalance(convertedtoint);
				Account account = BankS.getUserBalance(convertedtoint);
				FinalAmount = account.getBalance() - convertedtoDouble;
				BankS.updateAccountBalnce(FinalAmount, convertedtoint);

				BankS.getUserBalance(convertedtoint2);
				Account account2 = BankS.getUserBalance(convertedtoint2);
				FinalAmount = account2.getBalance() + convertedtoDouble;
				BankS.updateAccountBalnce(FinalAmount, convertedtoint2);

				response.getWriter().write("$" + Amount + " has been transferred from Account # { " + sourceAccountId
						+ " } " + " to Account # { " + targetAccountId + " } ");

			} else if (session != null) {
				double FinalAmount = 0.0;
				final String sourceAccountId = request.getParameter("sourceAccountId");
				final String targetAccountId = request.getParameter("targetAccountId");
				final String Amount = request.getParameter("Amount");

				Integer convertedtoint = Integer.parseInt(sourceAccountId);
				int convertedtoint2 = Integer.parseInt(targetAccountId);
				double convertedtoDouble = Double.parseDouble(Amount);
				if (session.getAttribute("UserID").equals(convertedtoint)) {
					BankService BankS = new BankService();
					BankS.getUserBalance(convertedtoint);
					Account account = BankS.getUserBalance(convertedtoint);
					FinalAmount = account.getBalance() - convertedtoDouble;
					BankS.updateAccountBalnce(FinalAmount, convertedtoint);

					BankS.getUserBalance(convertedtoint2);
					Account account2 = BankS.getUserBalance(convertedtoint2);
					FinalAmount = account2.getBalance() + convertedtoDouble;
					BankS.updateAccountBalnce(FinalAmount, convertedtoint2);

					response.getWriter().write("$" + Amount + " has been transferred from Account # { "
							+ sourceAccountId + " } " + " to Account # { " + targetAccountId + " } ");

				} else {
					response.getWriter().write("Your Account ID Does NOT Match With What We Have in Our Record, Pleace Try Agine !");

				}
			}
		} else {
			response.getWriter().write("There was no user logged into the session");

		}
	}
}
