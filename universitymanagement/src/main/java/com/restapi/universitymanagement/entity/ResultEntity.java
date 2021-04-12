/**
 * 
 */
package com.restapi.universitymanagement.entity;

import java.util.List;

/**
 * @author rajsh
 *
 */
public class ResultEntity {
	
	private String student_reg_no;
	private String student_name;
	private List<MarksEntity> marks;
	private String totalMark;
	private String averageMark;
	/**
	 * 
	 */
	public ResultEntity() {
		super();
	}
	/**
	 * @param student_reg_no
	 * @param student_name
	 * @param marks
	 * @param totalMark
	 * @param averageMark
	 */
	public ResultEntity(String student_reg_no, String student_name, List<MarksEntity> marks, String totalMark,
			String averageMark) {
		super();
		this.student_reg_no = student_reg_no;
		this.student_name = student_name;
		this.marks = marks;
		this.totalMark = totalMark;
		this.averageMark = averageMark;
	}
	/**
	 * @return the student_reg_no
	 */
	public String getStudent_reg_no() {
		return student_reg_no;
	}
	/**
	 * @param student_reg_no the student_reg_no to set
	 */
	public void setStudent_reg_no(String student_reg_no) {
		this.student_reg_no = student_reg_no;
	}
	/**
	 * @return the student_name
	 */
	public String getStudent_name() {
		return student_name;
	}
	/**
	 * @param student_name the student_name to set
	 */
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	/**
	 * @return the marks
	 */
	public List<MarksEntity> getMarks() {
		return marks;
	}
	/**
	 * @param marks the marks to set
	 */
	public void setMarks(List<MarksEntity> marks) {
		this.marks = marks;
	}
	/**
	 * @return the totalMark
	 */
	public String getTotalMark() {
		return totalMark;
	}
	/**
	 * @param totalMark the totalMark to set
	 */
	public void setTotalMark(String totalMark) {
		this.totalMark = totalMark;
	}
	/**
	 * @return the averageMark
	 */
	public String getAverageMark() {
		return averageMark;
	}
	/**
	 * @param averageMark the averageMark to set
	 */
	public void setAverageMark(String averageMark) {
		this.averageMark = averageMark;
	}
	
	
	
	
}
