package com.CarDealership.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.CarDealership.modles.CarStates;
import com.CarDealership.modles.Loan;
import com.CarDealership.modles.Offers;
import com.CarDealership.modles.Payments;
import com.CarDealership.modles.Role;
import com.CarDealership.modles.Users;
import com.CarDealership.modles.lot;
import com.connections.util.ConnectionClosers;
import com.connections.util.ConnectionFactory;

public class ImplementRepo implements Repository {

	public Users finduserByUsername(String name) {
		Users user = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from user_ where username = ? ";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, name);
			set = stmt.executeQuery();

			while (set.next()) {
				Role role = new Role(set.getInt(7), set.getString(8));
				user = new Users(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5),
						set.getString(6), role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return user;
	}

	public void insertUser(Users user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into user_ values(default,?,?,?,?,?,?,?)";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getEmail());
			stmt.setInt(6, user.getRole().getId());
			stmt.setString(7, user.getRole().getRoleName());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}

	@Override
	public void insertCartoLot(lot Lot) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into Lot values(default,?,?,?,?,?,?,?,null)";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, Lot.getCarType());
			stmt.setString(2, Lot.getCarmodel());
			stmt.setString(3, Lot.getCarYear());
			stmt.setString(4, Lot.getCarColor());
			stmt.setDouble(5, Lot.getPrice());
			stmt.setInt(6, Lot.getStates().getId());
			stmt.setString(7, Lot.getStates().getStates());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
	}

	@Override
	public void AcceptingOffers(int CarId, int UserId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "UPDATE Lot SET States = 'Owned', car_owner = ? WHERE carId = ?";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, UserId);
			stmt.setInt(2, CarId);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
	}

	@Override
	public List<lot> FindAllCars() {
		ArrayList<lot> Lot = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		try {

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery("select * from Lot");
			while (set.next()) {
				CarStates status = new CarStates(set.getInt(7), set.getString(8));
				Lot.add(new lot(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5),
						set.getInt(6), status));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				stmt.close();
				set.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Lot;
	}

	@Override
	public void makingOffers(Offers offer) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into Offers values(?,?,?)";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1,offer.getUserId());
			stmt.setInt(2, offer.getCarId());
			stmt.setDouble(3, offer.getOfferedAmont());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}		
	}

	@Override
	public void insertLoan(Loan loan, int UserId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into Loan values(default,?,?)";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setDouble(1, loan.getLoanAmount());
			stmt.setInt(2,UserId);

			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
		
	}

	@Override
	public List<Offers> ViewOffers() {
		ArrayList<Offers> offer = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		try {

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery("select * from Offers");
			while (set.next()) {
				offer.add(new Offers(set.getInt(1), set.getInt(2), set.getInt(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				stmt.close();
				set.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return offer;
	}

	@Override
	public List<lot> FindCarsByUser(int User) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		ArrayList<lot> Cars = new ArrayList<>();
		final String SQL = "select * from Lot where car_owner = " + User;

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while (set.next()) {
				CarStates status = new CarStates(set.getInt(7), set.getString(8));
				Cars.add(new lot(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5),
						set.getInt(6), status));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return Cars;
	}

	@Override
	public void DeleteFromCar(int CarId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "DELETE FROM Lot WHERE carId = ?";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, CarId);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}		
	}

	@Override
	public Loan FindLoan(int UserId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		Loan loan = null;
		final String SQL = "select * from Loan where Loan_User = " + UserId;

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while (set.next()) {
				loan = (new Loan(set.getInt(1), set.getDouble(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return loan;
	}

	@Override
	public void UpdateLoanAmount(int UserId, double LoanAmount) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "UPDATE Loan SET LoanAmount = ? WHERE Loan_User = ?";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setDouble(1, LoanAmount);
			stmt.setInt(2, UserId);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}				
	}

	@Override
	public void insertPayment(Payments payment) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into Payments values(?,?,?)";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, payment.getUserId());
			stmt.setString(2, payment.getDate());
			stmt.setDouble(3,payment.getAmountPaid() );
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}		
	}

	@Override
	public List<Payments> FindAllPayments() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		ArrayList<Payments> payments = new ArrayList<>();
		final String SQL = "select * from Payments";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while (set.next()) {
				payments.add(new Payments(set.getInt(1), set.getString(2), set.getDouble(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return payments;
	}

	@Override
	public void PendingOffers(int CarId, int UserId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "UPDATE Lot SET States = 'Pending', car_owner = ? WHERE carId = ?";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, UserId);
			stmt.setInt(2, CarId);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}		
	}

	@Override
	public lot FindCarbyStats() {
		lot car = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		String panding = "Pending";
		final String SQL = "select * from lot where States = ?";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, panding);
			set = stmt.executeQuery();

			while (set.next()) {
				car = new lot(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5),
						set.getDouble(6),new CarStates(set.getInt(7), set.getString(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return car;
	}
}
