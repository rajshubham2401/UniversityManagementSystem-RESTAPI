/**
 * 
 */
package com.restapi.universitymanagement.entity;

import java.util.List;

/**
 * @author rajsh
 *
 */
public class DepartmentEntity {
	
	private String dept_id;
	private String dept_name;
	private List<SubjectEntity> subjects; 
	private String subjects_id;
	/**
	 * 
	 */
	public DepartmentEntity() {
		super();

	}

	/**
	 * @param dept_id
	 * @param dept_name
	 * @param subjects
	 * @param subjects_id
	 */
	public DepartmentEntity(String dept_id, String dept_name, List<SubjectEntity> subjects, String subjects_id) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.subjects = subjects;
		this.subjects_id = subjects_id;
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
	 * @return the dept_name
	 */
	public String getDept_name() {
		return dept_name;
	}

	/**
	 * @param dept_name the dept_name to set
	 */
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	/**
	 * @return the subjects
	 */
	public List<SubjectEntity> getSubjects() {
		return subjects;
	}

	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(List<SubjectEntity> subjects) {
		this.subjects = subjects;
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
	

	
}

	
