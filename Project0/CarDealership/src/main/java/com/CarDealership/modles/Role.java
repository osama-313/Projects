package com.CarDealership.modles;

public class Role {
	private int Id;
	private String RoleName;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String roleName) {
		super();
		Id = id;
		RoleName = roleName;
	}

	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((RoleName == null) ? 0 : RoleName.hashCode());
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
		Role other = (Role) obj;
		if (Id != other.Id)
			return false;
		if (RoleName == null) {
			if (other.RoleName != null)
				return false;
		} else if (!RoleName.equals(other.RoleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [Id=" + Id + ", RoleName=" + RoleName + "]";
	}
	
	
	
	
}
