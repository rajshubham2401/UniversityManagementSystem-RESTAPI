package com.restapi.universitymanagement.resource;
/**
 * 
 */

import java.sql.SQLException;
import java.util.List;

import com.restapi.universitymanagement.entity.MarksEntity;
import com.restapi.universitymanagement.repository.MarksRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author rajsh
 * 
 *Root resource (exposed at "marks" path)
 */
@Path(value="marks")
public class MarksResource {

	MarksRepository  marksRepository  = new MarksRepository();
	
	/**
     * Method handling HTTP POST requests. The returned object will be sent
     * to the client as "XML / JSON " media type.
     *
     * @return DepartmentEntity that will be returned as a Object List response.
	 * @throws SQLException 
     */
	@PUT
	@Path("updateMarks")
	@Produces(value = {MediaType.APPLICATION_JSON})
	@Consumes(value = {MediaType.APPLICATION_JSON})
	public Response updateMarks( MarksEntity marksEntity) throws SQLException {
		marksRepository.updateMarks(marksEntity);
		return Response.status(200).entity("Student Marks Updated Succesfully").build();
    }
	
	
//	/**
//     * Method handling HTTP GET requests. The returned object will be sent
//     * to the client as " JSON " media type.
//     *
//     * @return List<DepartmentEntity> that will be returned as a Object List response.
//     */
//    @GET
//    @Produces(value = {MediaType.APPLICATION_JSON})
//    public List<MarksEntity> getMarks() {
//    	
//    	List<MarksEntity> marks =  marksRepository.getMarks();
//        return marks;
//    }
//    
//    /**
//     * Method handling HTTP GET requests. The returned object will be sent
//     * to the client as " JSON " media type.
//     *
//     * @return List<DepartmentEntity> that will be returned as a Object List response.
//     */
//    @GET
//    @Produces(value = {MediaType.APPLICATION_JSON})
//    @Path(value="/{student_reg_no}")
//    public List<MarksEntity> getMarksWithRegNo(@PathParam("student_reg_no") String student_reg_no) {
//    	
//    	List<MarksEntity> marks =  marksRepository.getMarksWithRegNo(student_reg_no);
//        return marks;
//    }
}

