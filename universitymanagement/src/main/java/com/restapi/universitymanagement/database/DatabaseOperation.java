/**
 * 
 */
package com.restapi.universitymanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.restapi.universitymanagement.exception.GenricExceptionMapper;

/**
 * @author rajsh
 *
 */
public class DatabaseOperation {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private String diverName = "com.mysql.jdbc.Driver";
	private String connectionUrl = "jdbc:mysql://localhost:3306/university_management";
	private String username = "root";
	private String password = "root";
	
	
	/**
	 * 
	 */
	public DatabaseOperation() {
		super();
	}
	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}
	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	/**
	 * @return the preparedStatement
	 */
	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}
	/**
	 * @param preparedStatement the preparedStatement to set
	 */
	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}
	
	/**
	 * @return the resultSet
	 */
	public ResultSet getResultSet() {
		return resultSet;
	}
	/**
	 * @param resultSet the resultSet to set
	 */
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
	
	public boolean createConnection() {
		try {
			Class.forName(diverName);
			connection = DriverManager.getConnection(connectionUrl,username,password);
		} catch (ClassNotFoundException | SQLException e) {
			e.toString();
		}
		
		return connection == null ? false : true;	
	}
	public boolean createPreparedStatement(String query) {
		try {
			preparedStatement = connection.prepareStatement(query);
		} catch (SQLException e) { 
			e.toString();
		}
		return preparedStatement == null ? false : true;
	}
	
	public boolean createResultset() {
		try {
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) { 
			e.toString();
		}
		return resultSet == null ? false : true;
	}
	
	public void closeResultSet() {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closePreparedStatement() {
		try {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
		
}
