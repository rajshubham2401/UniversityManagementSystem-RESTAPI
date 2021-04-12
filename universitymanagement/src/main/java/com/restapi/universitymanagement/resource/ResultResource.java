/**
 * 
 */
package com.restapi.universitymanagement.resource;

import java.sql.SQLException;
import java.util.List;

import com.restapi.universitymanagement.entity.MarksEntity;
import com.restapi.universitymanagement.entity.ResultEntity;
import com.restapi.universitymanagement.repository.ResultRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author rajsh
 *
 */
@Path(value="result")
public class ResultResource {
	
	ResultRepository resultRepository = new ResultRepository();
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as " JSON " media type.
     *
     * @return  List<ResultEntity> that will be returned as a Object List response.
	 * @throws SQLException 
     */
    @GET
    @Produces(value = {MediaType.APPLICATION_JSON})
    @Path(value="topThree")
    public Response getTopThree() throws SQLException {
    	List<ResultEntity> topThreeStudent =  resultRepository.getTopThree();
    	return Response.status(200).entity(topThreeStudent).build();
    }
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "JSON " media type.
     *
     * @return List<MarksEntity> that will be returned as a Object List response.
     * @throws SQLException 
     */
    @GET
    @Produces(value = {MediaType.APPLICATION_JSON})
    @Path(value="topThree/{subject_id}")
    public Response getTopThreeBySubject(@PathParam("subject_id") String subject_id) throws SQLException{
    	List<MarksEntity> topThreeStudent =  resultRepository.getTopThreeBySubject(subject_id);
    	return Response.status(200).entity(topThreeStudent).build();
    } 
}	
