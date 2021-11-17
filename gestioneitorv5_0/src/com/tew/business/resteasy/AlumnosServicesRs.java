package com.tew.business.resteasy;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.tew.business.AlumnosService;
import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Alumno;

// URL en la que el web service responder�
@Path("/AlumnosServicesRs")
public interface AlumnosServicesRs extends AlumnosService{

   // responde a peticiones GET
   @GET
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   public List<Alumno> getAlumnos();
	
   
   @GET
   // paramentro indicado en la URL, utilizado el m�todo con @PathParam
   @Path("{id}")
   // formato en el que los datos se retornan en el m�todo
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   Alumno findById(@PathParam("id") Long id) throws EntityNotFoundException;
	
   // responde a peticiones DELETE
   @DELETE
   // paramentro indicado en la URL
   @Path("{id}")
   void deleteAlumno(@PathParam("id") Long id) throws EntityNotFoundException;

   // responde a peticiones PUT
   @PUT
   @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   void saveAlumno(Alumno alumno) throws EntityAlreadyExistsException;
	
   // responde a peticiones POST
   @POST
   // formato en que los datos se reciben en el m�todo
   @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   void updateAlumno(Alumno alumno) throws EntityNotFoundException;
}	
