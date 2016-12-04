package com.anton.coupons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anton.coupons.dao.interfaces.ICustomersDao;
import com.anton.coupons.dao.utils.ConnectionPool;
import com.anton.coupons.enums.ErrorType;
import com.anton.coupons.exceptions.ApplicationException;
import com.anton.coupons.javaBeans.Coupon;
import com.anton.coupons.javaBeans.Customer;

public class CustomersDao implements ICustomersDao {

	@Override
	public void createCustomer(Customer customer) throws ApplicationException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String sql = null;

		try {
			connection = ConnectionPool.getConnection();

			sql += "INSERT INTO `dbCoupons`.`tbl_Customers`";
			sql += "( `customer_name`, `customer_password`, `customer_email`)";
			sql += "VALUES ( ?, ?, ?)";

			preparedStatement = connection.prepareStatement(sql);

			// Inserting values into prepared SQL statement
			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getCustomerPassword());
			preparedStatement.setString(2, customer.getEmail());
			// Executes creation of new entry
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new ApplicationException(ErrorType.DAO_CREATE_ERROR, e,
					"Failed to create coupon due to :" + e.getMessage());
		} finally {
			// Close connection to database
			ConnectionPool.closeResources(connection, preparedStatement);
		}

	}

	@Override
	public void removeCustomer(long customerID) throws ApplicationException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String sql = null;

		try {
			connection = ConnectionPool.getConnection();

			sql += "DELETE FROM `dbCoupons`.`tbl_Customers` WHERE customer_ID  = ?";

			preparedStatement = connection.prepareStatement(sql);

			// Inserting values into prepared SQL statement
			preparedStatement.setLong(1, customerID);

			// Executes creation of new entry
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new ApplicationException(ErrorType.DAO_DELETE_ERROR, e,
					"Failed to remove coupon due to :" + e.getMessage());
		} finally {
			// Close connection to database
			ConnectionPool.closeResources(connection, preparedStatement);
		}

	}

	@Override
	public void updateCustomer(long customerID, Customer customer) throws ApplicationException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String sql = null;

		try {
			connection = ConnectionPool.getConnection();

			sql += "UPDATE `dbcouponsoupons`.`tbl_customers`";
			sql += " SET `customer_name`= ?, `customer_password`= ?, `customer_email`=?";
			sql += " WHERE `customer_ID`='?'";

			preparedStatement = connection.prepareStatement(sql);

			// Inserting values into prepared SQL statement
			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getCustomerPassword());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setLong(4, customerID);

			// Executes creation of new entry
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new ApplicationException(ErrorType.DAO_UPDATE_ERROR, e,
					"Failed to update coupon due to :" + e.getMessage());
		} finally {
			// Close connection to database
			ConnectionPool.closeResources(connection, preparedStatement);
		}

	}

	@Override
	public Customer getCustomer(long customerID) throws ApplicationException {
		Customer customerToReturn = null;

		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		String sql = null;

		try {
			// Establish connection to database
			connection = ConnectionPool.getConnection();

			sql = "SELECT * FROM dbcoupons.tbl_customers WHERE customer_ID = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerID);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next() == false) {
				return null;
			}

			customerToReturn = extractCustomerFromResultSet(resultSet);

		} catch (ClassNotFoundException | SQLException e) {
			throw new ApplicationException(ErrorType.DAO_GET_ERROR, e,
					"Failed to get coupon information due to :" + e.getMessage());
		} finally {

			// Close connection
			ConnectionPool.closeResources(connection, preparedStatement);
		}

		return customerToReturn;
	}

	@Override
	public List<Coupon> getCouponsByCustomer(long customerID) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Coupon> coupons = new ArrayList<Coupon>();
		CouponsDao couponDao = new CouponsDao();
		Coupon coupon;
		String sql;

		try {
			connection = ConnectionPool.getConnection();
			sql = "SELECT * FROM dbcoupons.tbl_coupons WHERE user_ID = ? ";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerID);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				coupon = couponDao.extractCouponFromResultSet(resultSet);
				coupons.add(coupon);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new ApplicationException(ErrorType.DAO_UPDATE_ERROR, e,
					"Failed to update coupon due to :" + e.getMessage());
		} finally {
			// Close connection to database
			ConnectionPool.closeResources(connection, preparedStatement);
		}

		return coupons;
	}

	@Override
	public List<Customer> getAllCustomers() throws ApplicationException {
		
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			List<Customer> customers = new ArrayList<Customer>();
			Customer customer;
			String sql;

			try {
				connection = ConnectionPool.getConnection();
				sql = "SELECT * FROM dbcoupons.tbl_customers ";

				preparedStatement = connection.prepareStatement(sql);

				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					customer = extractCustomerFromResultSet(resultSet);
					customers.add(customer);
				}

			} catch (ClassNotFoundException | SQLException e) {
				throw new ApplicationException(ErrorType.DAO_UPDATE_ERROR, e,
						"Failed to update coupon due to :" + e.getMessage());
			} finally {
				// Close connection to database
				ConnectionPool.closeResources(connection, preparedStatement);
			}

			return customers;

		}
	

	private Customer extractCustomerFromResultSet(ResultSet resultSet) {
		Customer customer = null;
		try {
			customer = new Customer(resultSet.getLong("customer_ID"), resultSet.getString("castomer_name"),
					resultSet.getString("customer_password"), resultSet.getString("customer_email")

			);

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return customer;
	}

}
