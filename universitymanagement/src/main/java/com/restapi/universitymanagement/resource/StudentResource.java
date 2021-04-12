/**
 * 
 */
package com.restapi.universitymanagement.resource;

import java.sql.SQLException;
import java.util.List;

import com.restapi.universitymanagement.entity.MarksEntity;
import com.restapi.universitymanagement.entity.StudentEntity;
import com.restapi.universitymanagement.repository.MarksRepository;
import com.restapi.universitymanagement.repository.StudentRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author rajsh
 * 
 *Root resource (exposed at "students" path)
 */
@Path(value="students")
public class StudentResource {

	StudentRepository studentRepository = new StudentRepository();
	MarksRepository  marksRepository  = new MarksRepository();
	
	/**
     * Method handling HTTP POST requests. The returned object will be sent
     * to the client as "XML / JSON " media type.
     *
     * @return StudentEntity that will be returned as a Object List response.
	 * @throws SQLException 
     */
	@POST
	@Path("addStudent")
	@Produces(value = {MediaType.APPLICATION_JSON})
	@Consumes(value = {MediaType.APPLICATION_JSON})
	public Response addStudent( StudentEntity studentEntity) throws SQLException {
		studentRepository.addStudent(studentEntity);
		for(MarksEntity marks : studentEntity.getMarks())
		{
			marks.setStudent_reg_no(studentEntity.getStudent_reg_no());
		}
		marksRepository.addMarks(studentEntity.getMarks());
		return Response.status(200).entity("Student Data Added Succesfully").build();
    }
	
	
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as " JSON " media type.
     *
     * @return List<StudentEntity> that will be returned as a Object List response.
	 * @throws SQLException 
     */
    @GET
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response getStudents() throws SQLException {
    	List<StudentEntity> students =  studentRepository.getStudents();
    	return Response.status(200).entity(students).build();
    }
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as " JSON " media type.
     *
     * @return List<StudentEntity> that will be returned as a Object List response.
     * @throws SQLException 
     */
    @GET
    @Produces(value = {MediaType.APPLICATION_JSON})
    @Path(value="{dept_id}")
    public Response getStudentWithDeptId(@PathParam("dept_id") String dept_id) throws SQLException {
    	
    	List<StudentEntity> students =  studentRepository.getStudentWithDeptId(dept_id);
    	return Response.status(200).entity(students).build();
    }
    
    
}
