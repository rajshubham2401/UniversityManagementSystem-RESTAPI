/**
 * 
 */
package com.restapi.universitymanagement.entity;

/**
 * @author rajsh
 *
 */
public class SubjectEntity {

	
	private String subject_id;
	private String subject_name;
	/**
	 * 
	 */
	public SubjectEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param subject_id
	 * @param subject_name
	 */
	public SubjectEntity(String subject_id, String subject_name) {
		super();
		this.subject_id = subject_id;
		this.subject_name = subject_name;
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
	 * @return the subject_name
	 */
	public String getSubject_name() {
		return subject_name;
	}
	/**
	 * @param subject_name the subject_name to set
	 */
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	
	
}
