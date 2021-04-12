package com.restapi.universitymanagement.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restapi.universitymanagement.database.DatabaseOperation;
import com.restapi.universitymanagement.entity.MarksEntity;
import com.restapi.universitymanagement.exception.DataNotFoundException;

public class MarksRepository {
	
	DatabaseOperation databaseOperation = new DatabaseOperation();
	
	public MarksRepository() {
		databaseOperation.createConnection();
	}

	public boolean isMarksExist(String subject_id , String student_reg_no) {
		String query = "SELECT * FROM marks_details WHERE subject_id=? AND student_reg_no=?";
		try {
			if(databaseOperation.getConnection()!=null) {
				databaseOperation.createPreparedStatement(query);
				if(databaseOperation.getPreparedStatement()!=null) {
					databaseOperation.getPreparedStatement().setString(1, subject_id);
					databaseOperation.getPreparedStatement().setString(2, student_reg_no);
					databaseOperation.createResultset();
					if(databaseOperation.getResultSet().next()) {
						return true;
					}else {
						return false;
					}
				}
			}
			databaseOperation.closeResultSet();
			databaseOperation.closePreparedStatement();
			databaseOperation.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void addMarks(List<MarksEntity> marksEntities) throws SQLException {
		String query = "INSERT INTO marks_details(student_reg_no , subject_id, mark) VALUES (?,?,?)";
		try {
			for(MarksEntity marksEntity : marksEntities) {
				if(!isMarksExist(marksEntity.getSubject_id(), marksEntity.getStudent_reg_no())) {
					if(databaseOperation.getConnection()!=null) {
						databaseOperation.createPreparedStatement(query);
						if(databaseOperation.getPreparedStatement()!=null) {
							databaseOperation.getPreparedStatement().setString(1, marksEntity.getStudent_reg_no());
							databaseOperation.getPreparedStatement().setString(2, marksEntity.getSubject_id());
							databaseOperation.getPreparedStatement().setInt(3, marksEntity.getMark());
							databaseOperation.getPreparedStatement().executeUpdate();
						}else {
							throw new SQLException("Internal Server Error, Unable To Fetch Data With Database");
						}
					}else {
						throw new SQLException("Internal Server Error, Unable To Establish Connection With Database");
					}
				}else {
					throw new DataNotFoundException("Marks Data Not Found, For Given Student Or Subject Id ");
				}
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		finally {
			databaseOperation.closeResultSet();
			databaseOperation.closePreparedStatement();
			databaseOperation.closeConnection();
		}
	}

	public void updateMarks(MarksEntity marksEntity) throws SQLException {
		String query = "UPDATE marks_details set mark = ? WHERE subject_id=? AND student_reg_no=? ";
		try {
				if(isMarksExist(marksEntity.getSubject_id(), marksEntity.getStudent_reg_no())) {
					if(databaseOperation.getConnection()!=null) {
						databaseOperation.createPreparedStatement(query);
						if(databaseOperation.getPreparedStatement()!=null) {
							databaseOperation.getPreparedStatement().setString(3, marksEntity.getStudent_reg_no());
							databaseOperation.getPreparedStatement().setString(2, marksEntity.getSubject_id());
							databaseOperation.getPreparedStatement().setInt(1, marksEntity.getMark());
							databaseOperation.getPreparedStatement().executeUpdate();
						}else {
							throw new SQLException("Internal Server Error, Something Wrong During Updating Data To Database");
						}
				}else {
						throw new SQLException("Internal Server Error, Unable To Establish Connection With Database");
					}
				}
		}
		catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		finally {
			databaseOperation.closePreparedStatement();
			databaseOperation.closeConnection();
		}
		
	}

	public List<MarksEntity> getMarks() {
		String query = "SELECT * FROM marks_details";
		List<MarksEntity> marks = new ArrayList<MarksEntity>();
		try {
			if(databaseOperation.getConnection()!=null) {
				databaseOperation.createPreparedStatement(query);
				if(databaseOperation.getPreparedStatement()!=null) {
					databaseOperation.createResultset();
					while(databaseOperation.getResultSet().next()) {
						MarksEntity marksEntity = new MarksEntity();
						marksEntity.setStudent_reg_no(databaseOperation.getResultSet().getString(2));
						marksEntity.setSubject_id(databaseOperation.getResultSet().getString(3));
						marksEntity.setMark(databaseOperation.getResultSet().getInt(4));
						
						marks.add(marksEntity);
					}
				}
			}
			databaseOperation.closeResultSet();
			databaseOperation.closePreparedStatement();
			databaseOperation.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marks;
	}

	public List<MarksEntity> getMarksWithRegNo(String student_reg_no) {
		String query = "SELECT * FROM marks_details  WHERE student_reg_no=?  ";
		List<MarksEntity> marks = new ArrayList<MarksEntity>();
		try {
			if(databaseOperation.getConnection()!=null) {
				databaseOperation.createPreparedStatement(query);
				if(databaseOperation.getPreparedStatement()!=null) {
					databaseOperation.getPreparedStatement().setString(1, student_reg_no);
					databaseOperation.createResultset();
					while(databaseOperation.getResultSet().next()) {
						MarksEntity marksEntity = new MarksEntity();
						marksEntity.setStudent_reg_no(databaseOperation.getResultSet().getString(2));
						marksEntity.setSubject_id(databaseOperation.getResultSet().getString(3));
						marksEntity.setMark(databaseOperation.getResultSet().getInt(4));
						
						marks.add(marksEntity);
					}
				}
			}
			databaseOperation.closeResultSet();
			databaseOperation.closePreparedStatement();
			databaseOperation.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marks;
	}
	
}
