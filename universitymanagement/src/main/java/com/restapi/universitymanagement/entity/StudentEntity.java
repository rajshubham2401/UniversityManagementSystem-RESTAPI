/**
 * 
 */
package com.restapi.universitymanagement.entity;

import java.util.List;

/**
 * @author rajsh
 *
 */
public class StudentEntity {

	private String student_name;
	private String student_reg_no;
	private int student_age;
	private String student_gender;
	private String dept_id;
	private String subjects_id;
	private List<MarksEntity> marks;
	/**
	 * 
	 */
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param student_name
	 * @param student_reg_no
	 * @param student_age
	 * @param student_gender
	 * @param dept_id
	 * @param subjects_id
	 * @param marks
	 */
	public StudentEntity(String student_name, String student_reg_no, int student_age, String student_gender,
			String dept_id, String subjects_id, List<MarksEntity> marks) {
		super();
		this.student_name = student_name;
		this.student_reg_no = student_reg_no;
		this.student_age = student_age;
		this.student_gender = student_gender;
		this.dept_id = dept_id;
		this.subjects_id = subjects_id;
		this.marks = marks;
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
	 * @return the student_age
	 */
	public int getStudent_age() {
		return student_age;
	}
	/**
	 * @param student_age the student_age to set
	 */
	public void setStudent_age(int student_age) {
		this.student_age = student_age;
	}
	/**
	 * @return the student_gender
	 */
	public String getStudent_gender() {
		return student_gender;
	}
	/**
	 * @param student_gender the student_gender to set
	 */
	public void setStudent_gender(String student_gender) {
		this.student_gender = student_gender;
	}
	/**
	 * @return the dept_id
	 */
	public String getDept_id() {
		return dept_id;
	}
	/**
	 * @param dept_id the dept_id to set
	 */
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	/**
	 * @return the subjects_id
	 */
	public String getSubjects_id() {
		return subjects_id;
	}
	/**
	 * @param subjects_id the subjects_id to set
	 */
	public void setSubjects_id(String subjects_id) {
		this.subjects_id = subjects_id;
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
	
	
}
