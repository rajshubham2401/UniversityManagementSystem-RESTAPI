/**
 * 
 */
package com.restapi.universitymanagement.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restapi.universitymanagement.database.DatabaseOperation;
import com.restapi.universitymanagement.entity.MarksEntity;
import com.restapi.universitymanagement.entity.StudentEntity;
import com.restapi.universitymanagement.exception.DataNotFoundException;

/**
 * @author rajsh
 *
 */
public class StudentRepository {

	DatabaseOperation databaseOperation = new DatabaseOperation();
	
	public StudentRepository() {
		databaseOperation.createConnection();
	}
	
	public void addStudent(StudentEntity studentEntity) throws SQLException {
		String query = "INSERT INTO student_details(student_name, student_reg_no, student_age, student_gender, dept_id, subjects_id) VALUES (?,?,?,?,?,?)";
		String subjects_id = null ;
		for(MarksEntity marks : studentEntity.getMarks()) {
			if(subjects_id == null) {
				subjects_id  = marks.getSubject_id();
			}else {
				subjects_id += ","+marks.getSubject_id();
			}
		}
		studentEntity.setSubjects_id(subjects_id);
		try {
			if(databaseOperation.getConnection()!=null) {
				databaseOperation.createPreparedStatement(query);
				if(databaseOperation.getPreparedStatement() != null) {
					databaseOperation.getPreparedStatement().setString(1, studentEntity.getStudent_name());
					databaseOperation.getPreparedStatement().setString(2, studentEntity.getStudent_reg_no());
					databaseOperation.getPreparedStatement().setInt(3, studentEntity.getStudent_age());
					databaseOperation.getPreparedStatement().setString(4, studentEntity.getStudent_gender());
					databaseOperation.getPreparedStatement().setString(5, studentEntity.getDept_id());
					databaseOperation.getPreparedStatement().setString(6, studentEntity.getSubjects_id());
					databaseOperation.getPreparedStatement().executeUpdate();
				}
				else {
					throw new SQLException("Internal Server Error, Something Wrong During Adding Data To Database");
				}
			}
			else {
				throw new SQLException("Internal Server Error, Unable To Establish Connection With Database");
			}
		}catch (SQLException e) {
				throw new SQLException(e.getMessage());
		}
		finally {
			databaseOperation.closePreparedStatement();
			databaseOperation.closeConnection();
		}
	}
	
	public List<StudentEntity> getStudents() throws SQLException{
		String query = "SELECT * FROM student_details";
		List<StudentEntity> students = new ArrayList<StudentEntity>();
		try {
			if(databaseOperation.getConnection()!=null) {
				databaseOperation.createPreparedStatement(query);
				if(databaseOperation.getPreparedStatement()!=null) {
					databaseOperation.createResultset();
					if(databaseOperation.getResultSet()!=null) {
						while(databaseOperation.getResultSet().next()) {
							StudentEntity studentEntity = new StudentEntity();
							studentEntity.setStudent_name(databaseOperation.getResultSet().getString(2));
							studentEntity.setStudent_reg_no(databaseOperation.getResultSet().getString(3));
							studentEntity.setStudent_age(databaseOperation.getResultSet().getInt(4));
							studentEntity.setStudent_gender(databaseOperation.getResultSet().getString(5));
							studentEntity.setDept_id(databaseOperation.getResultSet().getString(6));
							studentEntity.setSubjects_id(databaseOperation.getResultSet().getString(7));
							
							students.add(studentEntity);
					}
					
					}else {
						throw new DataNotFoundException("Student Data Not Found, May Student Details Table Is Empty In Database ");
					}
				}else {
					throw new SQLException("Internal Server Error, Unable To Fetch Data With Database");
				}
			}
			else {
				throw new SQLException("Internal Server Error, Unable To Establish Connection With Database");
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		finally {
			databaseOperation.closeResultSet();
			databaseOperation.closePreparedStatement();
			databaseOperation.closeConnection();
		}
		return students;
	}
	
	public List<StudentEntity> getStudentWithDeptId(String dept_id) throws SQLException {
		String query = "SELECT * FROM student_details WHERE dept_id=?";
		List<StudentEntity> students = new ArrayList<StudentEntity>();
		try {
			if(databaseOperation.getConnection()!=null) {
				databaseOperation.createPreparedStatement(query);
				if(databaseOperation.getPreparedStatement()!=null) {
					databaseOperation.getPreparedStatement().setString(1, dept_id);
					databaseOperation.createResultset();
					if(databaseOperation.getResultSet()!=null) {
						while(databaseOperation.getResultSet().next()) {
							StudentEntity studentEntity = new StudentEntity();
							studentEntity.setStudent_name(databaseOperation.getResultSet().getString(2));
							studentEntity.setStudent_reg_no(databaseOperation.getResultSet().getString(3));
							studentEntity.setStudent_age(databaseOperation.getResultSet().getInt(4));
							studentEntity.setStudent_gender(databaseOperation.getResultSet().getString(5));
							studentEntity.setDept_id(databaseOperation.getResultSet().getString(6));
							studentEntity.setSubjects_id(databaseOperation.getResultSet().getString(7));
							
							students.add(studentEntity);
					}
					
					}else {
						throw new DataNotFoundException("Student Data Not Found With The Department Id"+dept_id);
					}
				}else {
					throw new SQLException("Internal Server Error, Unable To Fetch Data With Database");
				}
			}
			else {
				throw new SQLException("Internal Server Error, Unable To Establish Connection With Database");
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		finally {
			databaseOperation.closeResultSet();
			databaseOperation.closePreparedStatement();
			databaseOperation.closeConnection();
		}
		return students;
	}
	public StudentEntity getStudentWithRegNo(String student_reg_no) throws SQLException {
		String query = "SELECT * FROM student_details WHERE student_reg_no=?";
		StudentEntity student = new StudentEntity();
		try {
			if(databaseOperation.getConnection()!=null) {
				databaseOperation.createPreparedStatement(query);
				if(databaseOperation.getPreparedStatement()!=null) {
					databaseOperation.getPreparedStatement().setString(1, student_reg_no);
					databaseOperation.createResultset();
					if(databaseOperation.getResultSet()!=null) {
						while(databaseOperation.getResultSet().next()) {
							student.setStudent_name(databaseOperation.getResultSet().getString(2));
							student.setStudent_reg_no(databaseOperation.getResultSet().getString(3));
							student.setStudent_age(databaseOperation.getResultSet().getInt(4));
							student.setStudent_gender(databaseOperation.getResultSet().getString(5));
							student.setDept_id(databaseOperation.getResultSet().getString(6));
							student.setSubjects_id(databaseOperation.getResultSet().getString(7));

					}
					
					}else {
						throw new DataNotFoundException("Student Data Not Found With The Department Id"+student_reg_no);
					}
				}else {
					throw new SQLException("Internal Server Error, Unable To Fetch Data With Database");
				}
			}
			else {
				throw new SQLException("Internal Server Error, Unable To Establish Connection With Database");
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		finally {
			databaseOperation.closeResultSet();
			databaseOperation.closePreparedStatement();
			databaseOperation.closeConnection();
		}
		return student;
	}
}








