/**
 * 
 */
package com.restapi.universitymanagement.resource;

import java.sql.SQLException;
import java.util.List;

import com.restapi.universitymanagement.entity.DepartmentEntity;
import com.restapi.universitymanagement.repository.DepartmentRepository;
import com.restapi.universitymanagement.repository.SubjectRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author rajsh
 * 
 *Root resource (exposed at "departments" path)
 */
@Path("departments")
public class DepartmentResource {
	
	DepartmentRepository departmentRepository = new DepartmentRepository();
	SubjectRepository subjectRepository  = new SubjectRepository();
	
	 /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "XML / JSON " media type.
     *
     * @return List<DepartmentEntity> that will be returned as a Object List response.
	 * @throws SQLException 
     */
    @GET
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response getDepartments() throws SQLException {
    	List<DepartmentEntity> departments =  departmentRepository.getDepartments();
        return Response.status(200).entity(departments).build();
    }
	
	/**
     * Method handling HTTP POST requests. The returned object will be sent
     * to the client as "XML / JSON " media type.
     *
     * @return DepartmentEntity that will be returned as a Object List response.
	 * @throws SQLException 
     */
	@POST
	@Path("addDepartment")
	@Produces(value = {MediaType.APPLICATION_JSON})
	@Consumes(value = {MediaType.APPLICATION_JSON})
	public Response addDepartment( DepartmentEntity departmentEntity) throws SQLException {
		departmentRepository.addDepartment(departmentEntity);
		subjectRepository.addSubjects(departmentEntity.getSubjects());
        return Response.status(200).entity("Department Data Added Succesfully").build();
    }

}
