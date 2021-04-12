/**
 * 
 */
package com.restapi.universitymanagement.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restapi.universitymanagement.database.DatabaseOperation;
import com.restapi.universitymanagement.entity.MarksEntity;
import com.restapi.universitymanagement.entity.ResultEntity;
import com.restapi.universitymanagement.entity.StudentEntity;
import com.restapi.universitymanagement.exception.DataNotFoundException;

/**
 * @author rajsh
 *
 */
public class ResultRepository {
	
DatabaseOperation databaseOperation = new DatabaseOperation();
	
	public ResultRepository() {
		databaseOperation.createConnection();
	}
	
	public List<ResultEntity> getTopThree() throws SQLException {
		List<ResultEntity> topThreeStudent = new ArrayList<ResultEntity>();
		String query = "SELECT student_reg_no, (SUM(mark)) AS TotalMarks, (SUM(mark)/COUNT(mark)) AS Average FROM marks_details GROUP BY student_reg_no ORDER BY Average DESC LIMIT 3";
		try {
			if(databaseOperation.getConnection()!=null) {
				databaseOperation.createPreparedStatement(query);
				if(databaseOperation.getPreparedStatement()!=null) {
					databaseOperation.createResultset();
					if(databaseOperation.getResultSet()!=null) {
						while(databaseOperation.getResultSet().next()) {
							ResultEntity resultEntity = new ResultEntity();
							resultEntity.setStudent_reg_no(databaseOperation.getResultSet().getString("student_reg_no"));
							resultEntity.setTotalMark(databaseOperation.getResultSet().getString("TotalMarks"));
							resultEntity.setAverageMark(databaseOperation.getResultSet().getString("Average"));
							
							topThreeStudent.add(resultEntity);
						}
					}else {
						throw new DataNotFoundException("Student Data Not Found With The Department Id");
					}
				}else {
					throw new SQLException("Internal Server Error, Unable To Fetch Data With Database");
				}
			}
			else {
				throw new SQLException("Internal Server Error, Unable To Establish Connection With Database");
			}
			for(ResultEntity student : topThreeStudent) {
				StudentEntity student_details = new StudentRepository().getStudentWithRegNo(student.getStudent_reg_no());
				student.setStudent_name(student_details.getStudent_name());
				List<MarksEntity> marksEntity  = new MarksRepository().getMarksWithRegNo(student.getStudent_reg_no());
				student.setMarks(marksEntity);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		finally {
			databaseOperation.closeResultSet();
			databaseOperation.closePreparedStatement();
			databaseOperation.closeConnection();
		}
		return topThreeStudent;
	}

	public List<MarksEntity> getTopThreeBySubject(String subject_id) throws SQLException {
		List<MarksEntity> topThreeStudent = new ArrayList<MarksEntity>();
		String query = "SELECT * FROM marks_details WHERE subject_id = ? ORDER BY mark DESC LIMIT 3";
		try {
			if(databaseOperation.getConnection()!=null) {
				databaseOperation.createPreparedStatement(query);
				if(databaseOperation.getPreparedStatement()!=null) {
					databaseOperation.getPreparedStatement().setString(1, subject_id);
					databaseOperation.createResultset();
					if(databaseOperation.getResultSet()!=null) {
						while(databaseOperation.getResultSet().next()) {
							MarksEntity  marksEntity = new MarksEntity();
							marksEntity.setStudent_reg_no(databaseOperation.getResultSet().getString(2));
							marksEntity.setSubject_id(databaseOperation.getResultSet().getString(3));
							marksEntity.setMark(databaseOperation.getResultSet().getInt(4));
							
							topThreeStudent.add(marksEntity);
						}
					}else {
						throw new DataNotFoundException("Student Data Not Found With The Department Id");
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
		return topThreeStudent;
	}
}
