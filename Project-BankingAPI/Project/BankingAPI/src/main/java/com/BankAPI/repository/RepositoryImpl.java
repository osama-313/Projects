package com.BankAPI.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import com.BankAPI.models.Account;
import com.BankAPI.models.AccountStatus;
import com.BankAPI.models.AccountType;
import com.BankAPI.models.Role;
import com.BankAPI.models.User;
import com.connection.util.ConnectionClosers;
import com.connection.util.ConnectionFactory;

public class RepositoryImpl implements Repository {

	@Override
	public List<User> finduser() {

		ArrayList<User> user = new ArrayList<>();

		Connection conn = null;

		Statement stmt = null;

		ResultSet set = null;
		try {

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(System.getenv("url"), System.getenv("postgres_username"),
					System.getenv("postgres_password"));
			stmt = conn.createStatement();
			set = stmt.executeQuery("select * from User_");

			while (set.next()) {
				Role role = new Role(set.getInt(7), set.getString(8));
				user.add(new User(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5),
						set.getString(6), role));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return user;
	}

	@Override
	public User finduserById(int id) {
		User user = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from User_ where userId = " + id;

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while (set.next()) {
				Role role = new Role(set.getInt(7), set.getString(8));
				user = (new User(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5),
						set.getString(6), role));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return user;
	}

	@Override
	public Account findAccountById(int id) {

		Account account = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from Account where accountId = " + id;

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while (set.next()) {
				AccountStatus accs = new AccountStatus(set.getInt(3), set.getString(4));
				AccountType acct = new AccountType(set.getInt(5), set.getString(6));
				account = (new Account(set.getInt(1), set.getDouble(2), accs, acct));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return account;
	}

	@Override
	public List<Account> findAccount() {

		ArrayList<Account> accounts = new ArrayList<>();

		Connection conn = null;

		Statement stmt = null;

		ResultSet set = null;
		try {

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(System.getenv("url"), System.getenv("postgres_username"),
					System.getenv("postgres_password"));
			stmt = conn.createStatement();
			set = stmt.executeQuery("select * from Account");
			while (set.next()) {
				AccountStatus accs = new AccountStatus(set.getInt(3), set.getString(4));
				AccountType acct = new AccountType(set.getInt(5), set.getString(6));
				accounts.add(new Account(set.getInt(1), set.getDouble(2), accs, acct));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return accounts;
	}

	@Override
	public List<Account> findAccountByStatusID(int statusid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		ArrayList<Account> accounts = new ArrayList<>();
		final String SQL = "select * from Account where AccountStatusID = " + statusid;

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while (set.next()) {
				AccountStatus accs = new AccountStatus(set.getInt(3), set.getString(4));
				AccountType acct = new AccountType(set.getInt(5), set.getString(6));
				accounts.add(new Account(set.getInt(1), set.getDouble(2), accs, acct));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return accounts;
	}

	@Override
	public List<Account> findAccountByuser(int userid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		ArrayList<Account> accounts = new ArrayList<>();
		final String SQL = "select * from Account where user_id = " + userid;

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while (set.next()) {
				AccountStatus accs = new AccountStatus(set.getInt(3), set.getString(4));
				AccountType acct = new AccountType(set.getInt(5), set.getString(6));
				accounts.add(new Account(set.getInt(1), set.getDouble(2), accs, acct));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return accounts;
	}

	@Override
	public void updateAccount(Account account, int id) {
		Connection conn = null;
		PreparedStatement stmt = null;

		final String SQL = "update Account set accountId = ? , balance = ? , AccountStatusID = ? , AccountStatus = ? , AccountTypeID = ? , AccountType = ?  where accountId ="
				+ id;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, account.getAccountId());
			stmt.setDouble(2, account.getBalance());
			stmt.setInt(3, account.getStatus().getStatusId());
			stmt.setString(4, account.getStatus().getStatus());
			stmt.setInt(5, account.getType().getTypeId());
			stmt.setString(6, account.getType().getType());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}

	@Override
	public User finduserByName(String name) {
		User user = null;

		Connection conn = null;
		
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from user_ where username = ?";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			
			stmt.setString(1, name);
			set = stmt.executeQuery();

			while (set.next()) {
				Role role = new Role(set.getInt(7), set.getString(8));
				user = new User(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5),
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

	@Override
	public void insertUser(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;

		final String SQL = "insert into user_ (userId, username, password_ ,firstname, lastname, email , role_ID,role_name) values(default,?,?,?,?,?,?,?)";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			//stmt.setInt(1, user.getId());
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getEmail());
			stmt.setInt(6, user.getRole().getId());
			stmt.setString(7, user.getRole().getRole());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}

	@Override
	public void insertToAccount(Account account, int userid) {
		Connection conn = null;
		PreparedStatement stmt = null;

		final String SQL = "insert into Account values(default,?,?,?,?,?,?)";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			//stmt.setInt(1, account.getAccountId());
			stmt.setDouble(1, account.getBalance());
			stmt.setInt(2, account.getStatus().getStatusId());
			stmt.setString(3, account.getStatus().getStatus());
			stmt.setInt(4, account.getType().getTypeId());
			stmt.setString(5, account.getType().getType());
			stmt.setInt(6, userid);

			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}

	@Override
	public void updateAccountBalnce(double amount, int accountId) {
		Connection conn = null;
		PreparedStatement stmt = null;

		final String SQL = "update Account set balance = " + amount + "  where accountId = " + accountId;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}

	@Override
	public Account getUserBalance(int accountId) {
		Account account = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from Account where accountId = " + accountId;

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while (set.next()) {
				AccountStatus accountStatus = new AccountStatus(set.getInt(3), set.getString(4));
				AccountType accountTyype = new AccountType(set.getInt(5), set.getString(6));
				account = new Account(set.getInt(1), set.getDouble(2), accountStatus, accountTyype);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return account;

	}

	@Override
	public void updateUser(User user, int id) {
		Connection conn = null;
		PreparedStatement stmt = null;

		final String SQL = "update User_ set  username = ? , password_ = ? , firstname = ? , lastname = ? , email = ?  where userId = " + id;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getEmail());

			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}

}
