package com.p1.modles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name = "Reimbursement_table")
public class Reimbursement {
	@Id
	@Column(name = "reimbursementId")
	@GeneratedValue(generator = "reimbursementId", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "reimbursement", sequenceName = "reimbursement")
	private int reimbursementId;
	@Column
	private int employeeId;
	@Column
	private double amount;
	@Column
	private String date;
	@Column
	private String Status;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reimbursement(int reimbursementId, int employeeId, double amount, String date, String status) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.amount = amount;
		this.date = date;
		Status = status;
	}


	public int getReimbursementId() {
		return reimbursementId;
	}


	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + employeeId;
		result = prime * result + reimbursementId;
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
		Reimbursement other = (Reimbursement) obj;
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", employeeId=" + employeeId + ", amount=" + amount
				+ ", date=" + date + ", Status=" + Status + "]";
	}

}
