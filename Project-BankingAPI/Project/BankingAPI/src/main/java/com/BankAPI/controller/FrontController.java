package com.BankAPI.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BankAPI.operations.RequestHelper;
import com.fasterxml.jackson.databind.ObjectMapper;


//this class follows a front controller design pattern. it is responsible 
//for intercepting all HTTP request. 
//this mean that all request come through our front controller,
//which allows us to define a single point of validation.
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * I first check the HTTP.
		 * 
		 * we will say here that client should only access resources if they are logged in.
		 */
		if (request.getMethod().equals("GET") && request.getSession(false) != null)
		{
			
			String json = new ObjectMapper().writeValueAsString(RequestHelper.processGet(request, response));
			response.getWriter().write(json);
		}else {
			response.getWriter().write("You're not authenticated.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
