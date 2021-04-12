/**
 * 
 */
package com.restapi.universitymanagement.exception;

import com.restapi.universitymanagement.entity.ExceptionEntity;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 * @author rajsh
 *
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	
	public Response toResponse(DataNotFoundException ex)
	{
		return Response.status(Status.NOT_FOUND)
				.entity(new ExceptionEntity("404", ex.getMessage()))
				.build();
	}
}
