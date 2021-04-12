/**
 * 
 */
package com.restapi.universitymanagement.exception;

import java.sql.SQLException;

import com.restapi.universitymanagement.entity.ExceptionEntity;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;

/**
 * @author rajsh
 *
 */
public class GenricExceptionMapper implements ExceptionMapper<Throwable> {

	public Response toResponse(Throwable ex)
	{
		if(ex instanceof DataNotFoundException)
		{
		
			return Response.status(Status.NOT_FOUND)
				       .entity(new ExceptionEntity("404", ex.getMessage()))
				       .build();
		}
		else
		{
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ExceptionEntity("500", ex.getMessage()))
					.build();
		}
	}

	
}
