package com.CarDealship.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.CarDealership.Service.Services;
import com.CarDealership.repository.ImplementRepo;
import com.CarDealership.modles.*;


public class CarDealershipTest {
	
	@InjectMocks
	private static Services services;
	
	@Mock
	private ImplementRepo implementRepo;

	@BeforeClass
	public static void setup() {
		services = new Services();
	}

	@Before
	public void before()
	{
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void test()
	{
		ArrayList<lot> Cars = new ArrayList<>(Arrays.asList(new lot(),new lot(),new lot()));
		Mockito.when(implementRepo.FindAllCars()).thenReturn(Cars);
		List<lot> returnedCars = services.FindCars();
		
		for(lot c : returnedCars) {
			Assert.assertNotNull(returnedCars);
		}
	}
	@Test
	public void test2()
	{
		ArrayList<lot> Cars = new ArrayList<>(Arrays.asList(new lot(),new lot(),new lot()));
		Mockito.when(implementRepo.FindAllCars()).thenReturn(Cars);
		List<lot> returnedCars = services.FindCarsByUser(1);
		for(lot c : returnedCars) {
			Assert.assertNotEquals(1,c.getCarType());
		}
	}
	@Test
	public void test3()
	{
		ArrayList<lot> Cars = new ArrayList<>(Arrays.asList(new lot(1, "CUV", "HONDA", "2007","Red", 4500.99,new CarStates()),
				new lot(2, "CUV", "HONDA", "2003","Red", 4500.99,new CarStates()),
				new lot(3, "CUV", "HONDA", "2004","Red", 4500.99,new CarStates())));
		Mockito.when(implementRepo.FindAllCars()).thenReturn(Cars);
		List<lot> returnedCars = services.FindCarsByUser(1);
		for(lot c : returnedCars) {
			Assert.assertNotEquals(1,c.getCarType());
		}
	}
	@Test
	public void test4()
	{
		ArrayList<Payments> payments = new ArrayList<>(Arrays.asList(new Payments(1,"12/5/2021",55.00),
				new Payments(1,"12/5/2021",55.00),
				new Payments(1,"12/5/2021",55.00)));
		Mockito.when(implementRepo.FindAllPayments()).thenReturn(payments);
		List<Payments> returnedpayments = services.FindAllPayments();
		for(Payments c : returnedpayments) {
			Assert.assertNotNull(returnedpayments);
		}
	}
	@Test
	public void test5()
	{
		ArrayList<Offers> offers = new ArrayList<>(Arrays.asList(new Offers(),
				new Offers(),
				new Offers()));
		Mockito.when(implementRepo.ViewOffers()).thenReturn(offers);
		List<Offers> returnedoffers = services.ViewOffers();
		for(Offers c : returnedoffers) {
			Assert.assertNotNull(returnedoffers);
		}
	}
}
