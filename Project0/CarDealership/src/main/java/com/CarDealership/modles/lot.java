package com.CarDealership.modles;

public class lot {
	private int id;
	private String CarType;
	private String Carmodel;
	private String CarYear;
	private String CarColor;
	private double Price;
	private CarStates states;

	public lot() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public lot(int id, String carType, String carmodel, String carYear, String carColor, double price,
			CarStates states) {
		super();
		this.id = id;
		CarType = carType;
		Carmodel = carmodel;
		CarYear = carYear;
		CarColor = carColor;
		Price = price;
		this.states = states;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarType() {
		return CarType;
	}

	public void setCarType(String carType) {
		CarType = carType;
	}

	public String getCarmodel() {
		return Carmodel;
	}

	public void setCarmodel(String carmodel) {
		Carmodel = carmodel;
	}

	public String getCarYear() {
		return CarYear;
	}

	public void setCarYear(String carYear) {
		CarYear = carYear;
	}

	public String getCarColor() {
		return CarColor;
	}

	public void setCarColor(String carColor) {
		CarColor = carColor;
	}

	public CarStates getStates() {
		return states;
	}

	public void setStates(CarStates states) {
		this.states = states;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CarColor == null) ? 0 : CarColor.hashCode());
		result = prime * result + ((CarType == null) ? 0 : CarType.hashCode());
		result = prime * result + ((CarYear == null) ? 0 : CarYear.hashCode());
		result = prime * result + ((Carmodel == null) ? 0 : Carmodel.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((states == null) ? 0 : states.hashCode());
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
		lot other = (lot) obj;
		if (CarColor == null) {
			if (other.CarColor != null)
				return false;
		} else if (!CarColor.equals(other.CarColor))
			return false;
		if (CarType == null) {
			if (other.CarType != null)
				return false;
		} else if (!CarType.equals(other.CarType))
			return false;
		if (CarYear == null) {
			if (other.CarYear != null)
				return false;
		} else if (!CarYear.equals(other.CarYear))
			return false;
		if (Carmodel == null) {
			if (other.Carmodel != null)
				return false;
		} else if (!Carmodel.equals(other.Carmodel))
			return false;
		if (Double.doubleToLongBits(Price) != Double.doubleToLongBits(other.Price))
			return false;
		if (id != other.id)
			return false;
		if (states == null) {
			if (other.states != null)
				return false;
		} else if (!states.equals(other.states))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "lot [id=" + id + ", CarType=" + CarType + ", Carmodel=" + Carmodel + ", CarYear=" + CarYear
				+ ", CarColor=" + CarColor + ", states=" + states + ", Price=" + Price + "]\n";
	}

	
	

	
}
