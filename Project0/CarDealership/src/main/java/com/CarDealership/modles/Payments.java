package com.CarDealership.modles;

public class Payments {
	private int UserId;
	private String Date;
	private double AmountPaid;
	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payments(int userId, String date, double amountPaid) {
		super();
		UserId = userId;
		Date = date;
		AmountPaid = amountPaid;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public double getAmountPaid() {
		return AmountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		AmountPaid = amountPaid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(AmountPaid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((Date == null) ? 0 : Date.hashCode());
		result = prime * result + UserId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payments other = (Payments) obj;
		if (Double.doubleToLongBits(AmountPaid) != Double.doubleToLongBits(other.AmountPaid))
			return false;
		if (Date == null) {
			if (other.Date != null)
				return false;
		} else if (!Date.equals(other.Date))
			return false;
		if (UserId != other.UserId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Payments [UserId=" + UserId + ", Date=" + Date + ", AmountPaid=" + AmountPaid + "]";
	}
	
	
	
	



	
	
	
	
}
