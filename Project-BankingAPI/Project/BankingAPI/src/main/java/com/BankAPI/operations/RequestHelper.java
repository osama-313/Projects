package com.BankAPI.operations;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.service.BankService;

public class RequestHelper {

	public static Object processGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String URI = request.getRequestURI();
		String resource = URI.replace("/sample/users/", "");
		Integer convertedtointresorce = Integer.parseInt(resource);
		return new BankService().finduserById(convertedtointresorce);
	}
	public static int UserID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String URI = request.getRequestURI();
		String resource = URI.replace("/sample/users/", "");
		Integer convertedtointresorce = Integer.parseInt(resource);
		return convertedtointresorce;
	}
	public static Object processGetAccountByID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String URI = request.getRequestURI();
		String resource = URI.replace("/sample/accounts/", "");
		Integer convertedtointresorce = Integer.parseInt(resource);
		return new BankService().FindAccountByID(convertedtointresorce);
	}
	public static int AccountID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String URI = request.getRequestURI();
		String resource = URI.replace("/sample/accounts/", "");
		Integer convertedtointresorce = Integer.parseInt(resource);
		return convertedtointresorce;
	}
	public static Object processGetAccountByStatus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String URI = request.getRequestURI();
		String resource = URI.replace("/sample/accounts/status/", "");
		Integer convertedtointresorce = Integer.parseInt(resource);
		return new BankService().findAccountByStatusid(convertedtointresorce);
	}
	public static Object processGetAccountByUserID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String URI = request.getRequestURI();
		String resource = URI.replace("/sample/accounts/owner/", "");
		Integer convertedtointresorce = Integer.parseInt(resource);
		return new BankService().findAccountByuser(convertedtointresorce);
	}
	public static int IDAccountofUserID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String URI = request.getRequestURI();
		String resource = URI.replace("/sample/accounts/owner/", "");
		Integer convertedtointresorce = Integer.parseInt(resource);
		return convertedtointresorce;
	}
}
