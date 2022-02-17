package com.BankAPI.operations;

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

/**
 * Servlet implementation class FindAccounts
 */
public class FindUpdateAndSubmitAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindUpdateAndSubmitAccounts() {
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

				response.getWriter().write(BankS.findAccount().toString());
			} else {
				response.getWriter().write("You must be an Admin or an Employee to access this endpoint");
			}
		} else {
			response.getWriter().write("There was no user logged into the session");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			int AccountTypeID = 0;
			int AccountStatusID = 0;
			final String accountId = request.getParameter("accountId");
			final String balance = request.getParameter("balance");
			final String AccountStatus = request.getParameter("AccountStatus");
			final String AccountType = request.getParameter("AccountType");
			final String user_id = request.getParameter("Which_user_id_This_Account_for");
			int convertedtoint = Integer.parseInt(accountId);
			double Balnce = Integer.parseInt(balance);
			Integer Userid = Integer.parseInt(user_id);

			if (AccountType.equals("Checking")) {
				AccountTypeID = 1;
			} else if (AccountType.equals("Savings")) {
				AccountTypeID = 2;
			}
			////////////////////////////////////////
			if (AccountStatus.equals("Pending")) {
				AccountStatusID = 1;
			} else if (AccountStatus.equals("Open")) {
				AccountStatusID = 2;
			} else if (AccountStatus.equals("Closed")) {
				AccountStatusID = 3;
			} else if (AccountStatus.equals("Denied")) {
				AccountStatusID = 4;
			}
			if (session.getAttribute("Role").equals("Admin") || session.getAttribute("Role").equals("Employee") || session.getAttribute("UserID").equals(Userid)) {

				AccountType type = new AccountType(AccountTypeID, AccountType);
				AccountStatus stats = new AccountStatus(AccountStatusID, AccountStatus);
				Account account = new Account(convertedtoint, Balnce, stats, type);
				BankService Bankser = new BankService();
				Bankser.insertToAccount(account, Userid);
				response.getWriter().write("Account Submited Successfully !, you can now view your account by your User ID");
				response.setStatus(201);
			} else {
				response.getWriter().write("You must be an Admin or an Employee to Submit other user's Account");
			}
		} else {
			response.getWriter().write("There was no user logged into the session");
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute("Role").equals("Admin")) {
				int AccountTypeID = 0;
				int AccountStatusID = 0;
				final String accountId = request.getParameter("accountId");
				final String balance = request.getParameter("balance");
				final String AccountStatus = request.getParameter("AccountStatus");
				final String AccountType = request.getParameter("AccountType");
				final String WhichUser = request.getParameter("Which_Account_You_Want_To_Update");
				int convertedtoint = Integer.parseInt(accountId);
				double Balnce = Integer.parseInt(balance);
				int User = Integer.parseInt(WhichUser);

				if (AccountType.equals("Checking")) {
					AccountTypeID = 1;
				} else if (AccountType.equals("Savings")) {
					AccountTypeID = 2;
				}
				////////////////////////////////////////
				if (AccountStatus.equals("Pending")) {
					AccountStatusID = 1;
				} else if (AccountStatus.equals("Open")) {
					AccountStatusID = 2;
				} else if (AccountStatus.equals("Closed")) {
					AccountStatusID = 3;
				} else if (AccountStatus.equals("Denied")) {
					AccountStatusID = 4;
				}
				AccountType type = new AccountType(AccountTypeID, AccountType);
				AccountStatus stats = new AccountStatus(AccountStatusID, AccountStatus);
				Account account = new Account(convertedtoint, Balnce, stats, type);
				BankService Bankser = new BankService();
				Bankser.updateAccount(account, User);
				response.getWriter().write("Account Updated Successfully !");
				response.getWriter().write(new BankService().FindAccountByID(convertedtoint).toString());
			} else {
				response.getWriter().write("You must be an Admin or an Employee to access this endpoint");
			}
		} else {
			response.getWriter().write("There was no user logged into the session");
		}
	}
}
