package com.CarDealership.modles;

public class Loan {
	private int LoanId;
	private double LoanAmount;
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loan(int loanId, double loanAmount) {
		super();
		LoanId = loanId;
		LoanAmount = loanAmount;
	}
	public int getLoanId() {
		return LoanId;
	}
	public void setLoanId(int loanId) {
		LoanId = loanId;
	}
	public double getLoanAmount() {
		return LoanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		LoanAmount = loanAmount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(LoanAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + LoanId;
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
		Loan other = (Loan) obj;
		if (Double.doubleToLongBits(LoanAmount) != Double.doubleToLongBits(other.LoanAmount))
			return false;
		if (LoanId != other.LoanId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Loan [ Amount Remaining: " + LoanAmount + "]";
	}
	
	

}
