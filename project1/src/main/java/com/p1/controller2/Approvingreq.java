package com.p1.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.p1.controller.ReimbursementReq;
import com.p1.modles.Reimbursement;
import com.p1.service.Service;

/**
 * Servlet implementation class Approvingreq
 */
public class Approvingreq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Approvingreq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		Service ser = new Service();
		ObjectMapper objetMapper= new ObjectMapper();
		String jsonString = objetMapper.writeValueAsString(ser.findPending());
		response.getWriter().write(jsonString);
	
		

		Reimbursement req = new Reimbursement(1,2,1200,"2/3/2021","Approved");
		ser.update(req);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
