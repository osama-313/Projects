package com.p1.controller2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.p1.modles.Reimbursement;
import com.p1.service.Service;

/**
 * Servlet implementation class updateingreq
 */
public class updateingreq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateingreq() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service ser = new Service();
		String reqid = request.getParameter("id");
		String employeeid = request.getParameter("employeeid");
		String amount = request.getParameter("amount");
		String date = request.getParameter("date");
		int convertetoint = Integer.parseInt(reqid);
		int convertetoint2 = Integer.parseInt(employeeid);
		double convertetodob3 = Double.parseDouble(amount);

		Reimbursement req = new Reimbursement(convertetoint,convertetoint2,convertetodob3,date,"Approved");
		ser.update(req);

	}

}
