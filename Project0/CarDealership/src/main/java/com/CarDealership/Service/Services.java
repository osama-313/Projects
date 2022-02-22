package com.CarDealership.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.CarDealership.modles.Loan;
import com.CarDealership.modles.Offers;
import com.CarDealership.modles.Payments;
import com.CarDealership.modles.Users;
import com.CarDealership.modles.lot;
import com.CarDealership.repository.ImplementRepo;
import com.CarDealership.repository.Repository;

public class Services {
	
	//Writing Logs to a file.
	private static final Logger LOG = LogManager.getFormatterLogger(Services.class);

	private Repository repository;
	
	public Services() {
		this.repository = new ImplementRepo();
	}
	
	public Users findUserByUsername(String name) {
		return this.repository.finduserByUsername(name);
	}
	public  void insertUser(Users user) {
		this.repository.insertUser(user);
		LOG.info("A User Signed up");
	}
	public  void insertCartoLot(lot Lot) {
		this.repository.insertCartoLot(Lot);
	}
	public  void AcceptingOffers(int CarId,int UserId) {
		this.repository.AcceptingOffers(CarId, UserId);
	}
	public List<lot> FindCars(){
		return this.repository.FindAllCars();
	}
	public  void MakingOffers(Offers offer) {
		this.repository.makingOffers(offer);
	}
	public void insertLoan(Loan loan, int UserId)
	{
		this.repository.insertLoan(loan, UserId);
	}
	public List<Offers> ViewOffers()
	{
		return this.repository.ViewOffers();
	}
	public List<lot> FindCarsByUser(int User) {
		return this.repository.FindCarsByUser(User);
	}
	public void DeleteFromCar(int CarId) {
		this.repository.DeleteFromCar(CarId);
		LOG.info("An employee removed a car from the lot");
	}
	public Loan FindLoan(int UserId)
	{
		return this.repository.FindLoan(UserId);
	}
	public void UpdateLoanAmount(int UserId, double LoanAmount) {
		this.repository.UpdateLoanAmount(UserId, LoanAmount);
	}
	public void insertPayment(Payments payment) {
		this.repository.insertPayment(payment);
		LOG.info("A Customer Made a payment");
	}
	public List<Payments> FindAllPayments() {
		return this.repository.FindAllPayments();
	}
	public void PendingOffers(int CarId, int UserId) {
		this.repository.PendingOffers(CarId, UserId);
		LOG.info("A Car is Waiting to be approved");
	}
	public lot FindCarbyStats() {
		return this.repository.FindCarbyStats();
	}


}
