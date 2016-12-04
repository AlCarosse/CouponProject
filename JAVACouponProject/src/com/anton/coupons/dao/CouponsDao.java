package com.anton.coupons.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anton.coupons.dao.interfaces.ICouponsDao;
import com.anton.coupons.dao.utils.ConnectionPool;
import com.anton.coupons.exceptions.ApplicationException;
import com.anton.coupons.javaBeans.Coupon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.anton.coupons.enums.ErrorType;

public class CouponsDao implements ICouponsDao {

	@Override
	public void createCoupon(Coupon coupon) throws ApplicationException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String sql = null;

		try {
			connection = ConnectionPool.getConnection();

			sql += "INSERT INTO `dbCoupons`.`tbl_Coupons` (";
			sql += "`coupon_title`, `coupon_start_date`, `coupon_end_date`, ";
			sql += "`coupon_amount`, `coupon_type_ID`, `company_ID`, ";
			sql += "`coupon_messege`, `coupon_price`, `coupon_image`";
			sql += " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(sql);

			// Inserting values into prepared SQL statement
			preparedStatement.setString(1, coupon.getTitle());
			preparedStatement.setLong(2, coupon.getStartDate());
			preparedStatement.setLong(3, coupon.getEndDate());
			preparedStatement.setInt(4, coupon.getAmount());
			preparedStatement.setInt(5, coupon.getCouponType());
			preparedStatement.setString(6, coupon.getMessage());
			preparedStatement.setFloat(7, coupon.getPrice());
			preparedStatement.setString(8, coupon.getImage());

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
	public void removeCoupon(long couponID) throws ApplicationException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String sql = null;

		try {
			connection = ConnectionPool.getConnection();

			sql += "DELETE FROM `dbCoupons`.`tbl_Coupons` WHERE coupon_ID  = ?";

			preparedStatement = connection.prepareStatement(sql);

			// Inserting values into prepared SQL statement
			preparedStatement.setLong(1, couponID);

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
	public void updateCoupon(long couponID, Coupon coupon) throws ApplicationException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String sql = null;

		try {
			connection = ConnectionPool.getConnection();

			sql += "UPDATE `dbcoupons`.`tbl_coupons` SET ";
			sql += "`coupon_title`=?, `coupon_start_date`=?, `coupon_end_date`=?, ";
			sql += "`coupon_amount`=?, `coupon_type_ID`=?, `company_ID`=?, ";
			sql += "`coupon_messege`=?, `coupon_price`=?, `coupon_image`=? ";
			sql += " WHERE `coupon_ID`=?";

			preparedStatement = connection.prepareStatement(sql);

			// Inserting values into prepared SQL statement
			preparedStatement.setString(1, coupon.getTitle());
			preparedStatement.setLong(2, coupon.getStartDate());
			preparedStatement.setLong(3, coupon.getEndDate());
			preparedStatement.setInt(4, coupon.getAmount());
			preparedStatement.setInt(5, coupon.getCouponType());
			preparedStatement.setString(6, coupon.getMessage());
			preparedStatement.setFloat(7, coupon.getPrice());
			preparedStatement.setString(8, coupon.getImage());

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
	public Coupon getCoupon(long couponID) throws ApplicationException {
		Coupon couponToReturn = null;

		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		String sql = null;

		try {
			// Establish connection to database
			connection = ConnectionPool.getConnection();

			sql = "SELECT * FROM dbcoupons.tbl_coupons WHERE coupon_ID = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, couponID);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next() == false) {
				return null;
			}

			couponToReturn = extractCouponFromResultSet(resultSet);

		} catch (ClassNotFoundException | SQLException e) {
			throw new ApplicationException(ErrorType.DAO_GET_ERROR, e,
					"Failed to get coupon information due to :" + e.getMessage());
		} finally {

			// Close connection
			ConnectionPool.closeResources(connection, preparedStatement);
		}

		return couponToReturn;

	}

	@Override
	public List<Coupon> getCouponsByType(int couponType) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Coupon> coupons = new ArrayList<Coupon>();
		Coupon coupon;
		String sql;

		try {
			connection = ConnectionPool.getConnection();
			sql = "SELECT * FROM dbcoupons.tbl_coupons WHERE coupon_type = ? ";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, couponType);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				coupon = extractCouponFromResultSet(resultSet);
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
	public List<Coupon> getCouponsByCompanyID(int companyID) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Coupon> coupons = new ArrayList<Coupon>();
		Coupon coupon;
		String sql;

		try {
			connection = ConnectionPool.getConnection();
			sql = "SELECT * FROM dbcoupons.tbl_coupons WHERE company_ID = ? ";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, companyID);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				coupon = extractCouponFromResultSet(resultSet);
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
	public List<Coupon> getAllCoupons() throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Coupon> coupons = new ArrayList<Coupon>();
		Coupon coupon;
		String sql;

		try {
			connection = ConnectionPool.getConnection();
			sql = "SELECT * FROM dbcoupons.tbl_coupons ";

			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				coupon = extractCouponFromResultSet(resultSet);
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

	public Coupon extractCouponFromResultSet(ResultSet resultSet) {
		Coupon coupon = null;
		try {
			coupon = new Coupon(resultSet.getLong("coupon_ID"), resultSet.getString("title"),
					resultSet.getLong("start_date"), resultSet.getLong("end_date"), resultSet.getInt("amount_in_stock"),
					resultSet.getInt("coupon_type_ID"), resultSet.getString("messege"), resultSet.getFloat("price"),
					resultSet.getString("image"), resultSet.getLong("company_ID"));

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return coupon;
	}

}
