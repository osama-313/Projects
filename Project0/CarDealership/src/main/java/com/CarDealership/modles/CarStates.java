package com.CarDealership.modles;

public class CarStates {
	private int Id;
	private String states;
	
	
	public CarStates() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarStates(int id, String states) {
		super();
		Id = id;
		this.states = states;
	}
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
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
		CarStates other = (CarStates) obj;
		if (Id != other.Id)
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
		return "CarStates [Id=" + Id + ", states=" + states + "]";
	}
	
	
	
	
	
}
