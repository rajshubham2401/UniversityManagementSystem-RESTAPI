/**
 * 
 */
package com.restapi.universitymanagement.entity;

/**
 * @author rajsh
 *
 */
public class ExceptionEntity {
	
	private String status;
	private String errorMessage;
	
	public ExceptionEntity(){}
	
	public ExceptionEntity(String status, String errorMessage)
	{
		this.status = status;
		this.errorMessage = errorMessage;
	}
	
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	

}
