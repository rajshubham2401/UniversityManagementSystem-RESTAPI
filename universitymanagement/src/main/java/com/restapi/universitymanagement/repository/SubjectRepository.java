/**
 * 
 */
package com.restapi.universitymanagement.repository;

import java.sql.SQLException;
import java.util.List;

import com.restapi.universitymanagement.database.DatabaseOperation;

import com.restapi.universitymanagement.entity.SubjectEntity;
import com.restapi.universitymanagement.exception.DataNotFoundException;

/**
 * @author rajsh
 *
 */
public class SubjectRepository {

	DatabaseOperation databaseOperation = new DatabaseOperation();
	
	public SubjectRepository() {
		databaseOperation.createConnection();
	}
	
	public boolean isSubjectExist(String subject_id) {
		String query = "SELECT * FROM subject_details WHERE subject_id=?";
		try {
			if(databaseOperation.getConnection()!=null) {
				databaseOperation.createPreparedStatement(query);
				if(databaseOperation.getPreparedStatement()!=null) {
					databaseOperation.getPreparedStatement().setString(1, subject_id);
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
	
	public void addSubjects(List<SubjectEntity> subjectEntities) throws SQLException {
		String query = "INSERT INTO subject_details(subject_id , subject_name) VALUES (?,?)";
		try {
			for(SubjectEntity subjectEntity : subjectEntities) {
				if(!isSubjectExist(subjectEntity.getSubject_id())) {
					if(databaseOperation.getConnection()!=null) {
						databaseOperation.createPreparedStatement(query);
						if(databaseOperation.getPreparedStatement()!=null) {
							databaseOperation.getPreparedStatement().setString(1, subjectEntity.getSubject_id());
							databaseOperation.getPreparedStatement().setString(2, subjectEntity.getSubject_name());
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
	
}
