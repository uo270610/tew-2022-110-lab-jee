
	package com.tew.business.resteasy;
	import java.util.List;
	import javax.ws.rs.*;
	import javax.ws.rs.core.MediaType;
	import com.tew.business.AlumnosService;
	import com.tew.business.exception.EntityAlreadyExistsException;
	import com.tew.business.exception.EntityNotFoundException;
	import com.tew.model.Alumno;
	@Path("/AlumnosServicesRs")
	public interface AlumnosServicesRs extends AlumnosService{
	 @GET
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 public List<Alumno> getAlumnos();
	 @GET
	 @Path("{id}")
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 Alumno findById(@PathParam("id") Long id) throws EntityNotFoundException;
	 @DELETE
	 @Path("{id}")
	 void deleteAlumno(@PathParam("id") Long id) throws EntityNotFoundException;
	 @PUT
	 @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 void saveAlumno(Alumno alumno) throws EntityAlreadyExistsException;
	 @POST
	 @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 void updateAlumno(Alumno alumno) throws EntityNotFoundException;
	}
	 
	

