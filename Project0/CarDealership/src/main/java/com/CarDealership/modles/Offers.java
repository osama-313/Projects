package com.CarDealership.modles;

public class Offers {

	private int UserId;
	private int CarId;
	private double OfferedAmont;
	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Offers(int userId, int carId, double offeredAmont) {
		super();
		UserId = userId;
		CarId = carId;
		OfferedAmont = offeredAmont;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getCarId() {
		return CarId;
	}
	public void setCarId(int carId) {
		CarId = carId;
	}
	public double getOfferedAmont() {
		return OfferedAmont;
	}
	public void setOfferedAmont(double offeredAmont) {
		OfferedAmont = offeredAmont;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CarId;
		long temp;
		temp = Double.doubleToLongBits(OfferedAmont);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Offers other = (Offers) obj;
		if (CarId != other.CarId)
			return false;
		if (Double.doubleToLongBits(OfferedAmont) != Double.doubleToLongBits(other.OfferedAmont))
			return false;
		if (UserId != other.UserId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Offers [UserId=" + UserId + ", CarId=" + CarId + ", OfferedAmont=" + OfferedAmont + "]";
	}
	
	
}
