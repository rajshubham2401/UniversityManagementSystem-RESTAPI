/**
 * 
 */
package com.restapi.universitymanagement.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restapi.universitymanagement.database.DatabaseOperation;
import com.restapi.universitymanagement.entity.DepartmentEntity;
import com.restapi.universitymanagement.entity.SubjectEntity;
import com.restapi.universitymanagement.exception.DataNotFoundException;

/**
 * @author rajsh
 *
 */
public class DepartmentRepository {
	
	DatabaseOperation databaseOperation = new DatabaseOperation();
	
	public DepartmentRepository() {
		databaseOperation.createConnection();
	}
	
	public void addDepartment(DepartmentEntity departmentEntity) throws SQLException {
		String query = "INSERT INTO department_details(dept_id , dept_name, subjects_id) VALUES (?,?,?)";
		List<SubjectEntity> subjects = departmentEntity.getSubjects();
		String subjects_id = null ;
		for(SubjectEntity subject : subjects) {
			if(subjects_id == null) {
				subjects_id  = subject.getSubject_id();
			}else {
				subjects_id += ","+subject.getSubject_id();
			}
		}
		departmentEntity.setSubjects_id(subjects_id);
		try {
			if(databaseOperation.getConnection()!=null) {
				databaseOperation.createPreparedStatement(query);
				if(databaseOperation.getPreparedStatement()!=null) {
					databaseOperation.getPreparedStatement().setString(1, departmentEntity.getDept_id());
					databaseOperation.getPreparedStatement().setString(2, departmentEntity.getDept_name());
					databaseOperation.getPreparedStatement().setString(3, departmentEntity.getSubjects_id());
					databaseOperation.getPreparedStatement().executeUpdate();
				}
				else {
					throw new SQLException("Internal Server Error, Something Wrong During Adding Data To Database");
				}
			}else {
				throw new SQLException("Internal Server Error, Unable To Establish Connection With Database");
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		finally {
			databaseOperation.closePreparedStatement();
			databaseOperation.closeConnection();
		}
	}
	
	public List<DepartmentEntity> getDepartments() throws SQLException{
		String query = "SELECT * FROM department_details";
		List<DepartmentEntity> departments = new ArrayList<DepartmentEntity>();
		try {
			if(databaseOperation.getConnection()!=null) {
				databaseOperation.createPreparedStatement(query);
				if(databaseOperation.getPreparedStatement()!=null) {
					databaseOperation.createResultset();
					if(databaseOperation.getResultSet()!=null) {
						while(databaseOperation.getResultSet().next()) {
							DepartmentEntity departmentEntity = new DepartmentEntity();
							departmentEntity.setDept_id(databaseOperation.getResultSet().getString(2));
							departmentEntity.setDept_name(databaseOperation.getResultSet().getString(3));
							departmentEntity.setSubjects_id(databaseOperation.getResultSet().getString(4));
							
							departments.add(departmentEntity);
						}	
					}
					else {
						throw new DataNotFoundException("Department Data Not Found, May Department Details Table Is Empty In Database ");
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
		return departments;
	}
	
}
