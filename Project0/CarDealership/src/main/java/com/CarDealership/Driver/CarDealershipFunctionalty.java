package com.CarDealership.Driver;

import java.util.Scanner;

import com.CarDealership.Service.Services;
import com.CarDealership.modles.CarStates;
import com.CarDealership.modles.Loan;
import com.CarDealership.modles.Offers;
import com.CarDealership.modles.Payments;
import com.CarDealership.modles.Role;
import com.CarDealership.modles.Users;
import com.CarDealership.modles.lot;

public class CarDealershipFunctionalty {

	public void SignUp() {
		Scanner scanner = new Scanner(System.in);
		Services services = new Services();

		System.out.println("please enter all your info as asked. ");
		System.out.println("choose a username:  ");
		String username = scanner.nextLine();
		System.out.println("choose a password:  ");
		String password = scanner.nextLine();
		System.out.println("Enter your first name:  ");
		String firstname = scanner.nextLine();
		System.out.println("Enter your last name:  ");
		String lastname = scanner.nextLine();
		System.out.println("Enter your email:  ");
		String email = scanner.nextLine();

		Role role = new Role(2, "Customer");
		Users user = new Users(0, username, password, firstname, lastname, email, role);
		services.insertUser(user);
		System.out.println("account was registered successfully!");
		System.out.println("account info: " + services.findUserByUsername(username).toString());
	}

	public void InsertCar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter car info ");
		System.out.println("What is the type of the car:  ");
		String CarType = scanner.nextLine();
		System.out.println("What is the modle of the car:  ");
		String Carmodel = scanner.nextLine();
		System.out.println("What is the Year of the car:  ");
		String CarYear = scanner.nextLine();
		System.out.println("What is the Color of the car:  ");
		String CarColor = scanner.nextLine();
		System.out.println("What is the Price of the car:   ");
		double Price = scanner.nextDouble();
		Services services = new Services();
		CarStates state = new CarStates(1, "ForSale");
		lot Lot = new lot(0, CarType, Carmodel, CarYear, CarColor, Price, state);
		services.insertCartoLot(Lot);
		System.out.println("Car was added successfully!");
		System.out.println(services.FindCars().toString());

	}

	public void ViewCarsAndMakeOffers(int UserId) {
		Scanner scanner = new Scanner(System.in);
		Services services = new Services();
		System.out.println(services.FindCars().toString());
		System.out.println("Would you like to make an Offer:(Y/N) ");
		String decision = scanner.nextLine();
		if (decision.equals("Y")) {
			System.out.println("please Enter the Id number of the car you will like to make an offer on:  ");
			int CarId = scanner.nextInt();
			System.out.println("What is the Amount you're offering:  ");
			double AmountOffered = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Would you like to get a loan:(Y/N)   ");
			String decision2 = scanner.nextLine();
			if (decision2.equals("Y")) {
				System.out.println("What is the Amount of Loan you need to take:     ");
				double LoanAmount = scanner.nextDouble();
				Loan loan = new Loan(0, LoanAmount);
				services.insertLoan(loan, UserId);
				System.out.println("Loan was approved. ");
			}
			Offers offer = new Offers(UserId, CarId, AmountOffered);
			services.MakingOffers(offer);
			services.PendingOffers(CarId, UserId);
			System.out.println("Thank you for your offer, Our Employees will review your offer :  ");
			System.out.println(services.FindCarbyStats().toString());

		} else {
			System.out.println("alright see you soon");
		}
	}

	public void SeeOffersAndMakeDecisons() {
		Scanner scanner = new Scanner(System.in);
		Services services = new Services();
		System.out.println(services.FindCars().toString());
		System.out.println(services.ViewOffers().toString());
		System.out.println("Enter the User Id number for the person who made the Offer:  ");
		int UserId = scanner.nextInt();
		System.out.println("Enter the Car Id number for the car that the user wants to buy:  ");
		int CarId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Do you want to accept his offer:(Y/N)   ");
		String decision = scanner.nextLine();
		if (decision.equals("Y")) {
			services.AcceptingOffers(CarId, UserId);
			System.out.println("Offer was accepted successfully ");
			System.out.println(services.FindCarsByUser(UserId) + " Owned by User Id " + UserId);
		} else {
			System.out.println("Offer was rejected.");
		}

	}

	public void ViewMyCars(int UserId) {
		Scanner scanner = new Scanner(System.in);
		Services services = new Services();
		System.out.println(services.FindCarsByUser(UserId));
	}

	public void RemoveCarFromLot() {
		Scanner scanner = new Scanner(System.in);
		Services services = new Services();
		System.out.println(services.FindCars().toString());
		System.out.println("Enter The Car Id number that you want to remove:   ");
		int CarId = scanner.nextInt();
		services.DeleteFromCar(CarId);
		System.out.println("Car was removed successfully ! ");
		System.out.println(services.FindCars().toString());

	}

	public void viewRemaningPaymentAndMakePayments(int UserId) {
		Scanner scanner = new Scanner(System.in);
		Services services = new Services();
		System.out.println(services.FindLoan(UserId).toString());
		Loan loan = services.FindLoan(UserId);
		double monthlypayment = loan.getLoanAmount() / 12;
		System.out.println("You're Monthly payment is : " + monthlypayment);

		System.out.println("Would you like to make a payment:(Y/N)  ");
		String decision = scanner.nextLine();
		if (decision.equals("Y")) {
			System.out.println("Enter the Amount you would like to pay:  ");
			double amount = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Enter Today's Data:(Month/Day/Year)  ");
			String Date = scanner.nextLine();
			Payments payment = new Payments(UserId, Date, amount);
			services.insertPayment(payment);
			double NewLoanAmount = loan.getLoanAmount() - amount;
			services.UpdateLoanAmount(UserId, NewLoanAmount);
			System.out.println("Payment was Submitted successfully   ! ");
			System.out.println(services.FindLoan(UserId).toString());
		} else {
			System.out.println("Don't Forget to make a payment soon, thanks ");
		}

	}

	public void ViewAllPayments() {
		Services services = new Services();
		System.out.println(services.FindAllPayments().toString());
	}

}
