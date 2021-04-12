/**
 * 
 */
package com.restapi.universitymanagement.entity;

/**
 * @author rajsh
 *
 */
public class MarksEntity {
	
	private String student_reg_no;
	private String subject_id;
	private int mark;
	/**
	 * 
	 */
	public MarksEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param student_reg_no
	 * @param subject_id
	 * @param marks
	 */
	public MarksEntity(String student_reg_no, String subject_id, int mark) {
		super();
		this.student_reg_no = student_reg_no;
		this.subject_id = subject_id;
		this.mark = mark;
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
	 * @return the subject_id
	 */
	public String getSubject_id() {
		return subject_id;
	}
	/**
	 * @param subject_id the subject_id to set
	 */
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	/**
	 * @return the marks
	 */
	public int getMark() {
		return mark;
	}
	/**
	 * @param marks the marks to set
	 */
	public void setMark(int  mark) {
		this.mark = mark;
	}
	
}
