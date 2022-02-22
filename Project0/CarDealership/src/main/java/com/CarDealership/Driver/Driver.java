package com.CarDealership.Driver;

import java.util.Scanner;

import com.CarDealership.Service.Services;
import com.CarDealership.modles.Role;
import com.CarDealership.modles.Users;

public class Driver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to The car DealerShip!");
		System.out.println("Enter #1 to login in, or #2 to sign up for a customer account: ");
		int signupOrlogin = scanner.nextInt();
		if (signupOrlogin == 1) {
			scanner.nextLine();
			System.out.println("Enter your Username: ");
			String username = scanner.nextLine();
			System.out.println("Enter your Password: ");
			String password = scanner.nextLine();
			Services services = new Services();
			Users user = services.findUserByUsername(username);
			if (user != null) {
				if (password.equals(user.getPassword())) {
					System.out.println("Welcome " + user.getFirstName() + "\tRole: " + user.getRole().getRoleName());
					if (user.getRole().getRoleName().equals("Employee")) {
						String logout = "N";
						while (logout.equals("N")) {
							System.out.println(
									"Enter 1) To add a car to the lot.\t2) To accept or reject a pending offer for a car.\t3)To remove a car from the lot.\t4)To view all payments.");
							int EmployeeFun = scanner.nextInt();
							CarDealershipFunctionalty function = new CarDealershipFunctionalty();
							switch (EmployeeFun) {
							case 1:
								function.InsertCar();
								break;
							case 2:
								function.SeeOffersAndMakeDecisons();
								break;
							case 3:
								function.RemoveCarFromLot();
								break;
							case 4:
								function.ViewAllPayments();
								break;
							default:
								System.out.println("Unvalid Entry, please try agine");
								break;
							}
							scanner.nextLine();
							System.out.println("Would you like to log out: (Y/N) ");
							logout = scanner.nextLine();
						}
					} else if (user.getRole().getRoleName().equals("Customer")) {
						String logout = "N";
						while (logout.equals("N")) {
							System.out.println(
									"Enter 1) To view the cars on the lot, and make offers.\t2) To view the cars that you own.\t3)To make a payment or view your remaining payments for a car.");
							int CustomerFun = scanner.nextInt();
							CarDealershipFunctionalty function = new CarDealershipFunctionalty();
							switch (CustomerFun) {
							case 1:
								function.ViewCarsAndMakeOffers(user.getId());
								break;
							case 2:
								function.ViewMyCars(user.getId());
								break;
							case 3:
								function.viewRemaningPaymentAndMakePayments(user.getId());
								break;
							default:
								System.out.println("Unvalid Entry, please try agine");
								break;
							}
							scanner.nextLine();
							System.out.println("Would you like to log out: (Y/N) ");
							logout = scanner.nextLine();
							scanner.nextLine();
						}
					}

				} else {
					System.out.println("your username or password is not correct");
				}
			} else {
				System.out.println("your username or password is not correct");
			}
		} else if (signupOrlogin == 2) {
			CarDealershipFunctionalty function = new CarDealershipFunctionalty();
			function.SignUp();
		}

	}

}
