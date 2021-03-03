package com.p1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.p1.modles.Reimbursement;
import com.p1.service.Service;

/**
 * Servlet implementation class ReimbursementReq
 */
public class ReimbursementReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementReq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("employeeId");
		String amount = request.getParameter("amount");
		String date = request.getParameter("date");
		double converte = Double.parseDouble(amount);
		int convertetoint = Integer.parseInt(employeeId);
		Service service = new Service();
		Reimbursement reimbursement = new Reimbursement(1,convertetoint,converte,date,"pending");
		service.insert(reimbursement);
		response.sendRedirect("http://localhost:8088/project1/EmployeePage.html");
	}

}
