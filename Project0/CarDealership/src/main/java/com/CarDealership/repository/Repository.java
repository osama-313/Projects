package com.CarDealership.repository;

import java.util.List;

import com.CarDealership.modles.Loan;
import com.CarDealership.modles.Offers;
import com.CarDealership.modles.Payments;
import com.CarDealership.modles.Users;
import com.CarDealership.modles.lot;

public interface Repository {

	Users finduserByUsername(String name);
	public void insertUser(Users user);
	public void insertCartoLot(lot Lot);
	public void AcceptingOffers (int CarId,int UserId);
	List<lot> FindAllCars();
	public void makingOffers (Offers offer);
	public void insertLoan(Loan loan, int UserId);
	List<Offers> ViewOffers();
	List<lot> FindCarsByUser(int User);
	public void DeleteFromCar (int CarId);
	Loan FindLoan(int UserId);
	public void UpdateLoanAmount (int UserId, double LoanAmount);
	public void insertPayment(Payments payment);
	List<Payments> FindAllPayments();
	public void PendingOffers (int CarId,int UserId);
	lot FindCarbyStats();
}
