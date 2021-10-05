package com.tew.presentation;
import java.io.Serializable;
import javax.faces.bean.*;
import javax.faces.event.ActionEvent;

import com.tew.business.AlumnosService;
import com.tew.infrastructure.Factories;
import com.tew.model.Alumno;

@ManagedBean
@SessionScoped
public class BeanAlumnos implements Serializable{
  private static final long serialVersionUID = 55555L;
  // Se añade este atributo de entidad para recibir el alumno concreto seleccionado 
  // de la tabla o de un formulario. 
  // Es necesario inicializarlo para que al entrar desde el formulario de 
  // AltaForm.xhtml se puedan dejar los valores en un objeto existente.
 
private Alumno alumno = new Alumno();
  public Alumno getAlumno() {
	return alumno;
}
public void setAlumno(Alumno alumno) {
	this.alumno = alumno;
}
public Alumno[] getAlumnos() {
	return alumnos;
}
public void setAlumnos(Alumno[] alumnos) {
	this.alumnos = alumnos;
}
private Alumno[] alumnos = null;
  public BeanAlumnos(){
    iniciaAlumno(null);
  }
  public void iniciaAlumno(ActionEvent event) {
    alumno.setId(null);
    alumno.setIduser("IdUser");
    alumno.setNombre("Nombre");
    alumno.setApellidos("Apellidos");
    alumno.setEmail("email@domain.com"); 
  }
  
  
  public String listado() {
	    AlumnosService service;
	    try {
	      // Acceso a la implementacion de la capa de negocio 
	      // a través de la factoría
	      service = Factories.services.createAlumnosService();
	      // Asi le damos información a toArray para poder hacer el casting a Alumno[]
	      alumnos = (Alumno [])service.getAlumnos().toArray(new Alumno[0]);
	      return "exito";
	    } catch (Exception e) {
	      e.printStackTrace();  
	      return "error";
	    }
	  }
	  public String edit() {
	    AlumnosService service;
	    try {
	      // Acceso a la implementacion de la capa de negocio 
	      // a través de la factoría
	      service = Factories.services.createAlumnosService();
	      //Recargamos el alumno en la tabla de la base de datos por si hubiera cambios.
	      alumno = service.findById(alumno.getId());
	      return "exito";
	    } catch (Exception e) {
	       e.printStackTrace();  
	       return "error";
	    }
	  }
	  public String salva() {
	    AlumnosService service;
	    try {
	      // Acceso a la implementacion de la capa de negocio 
	      // a través de la factoría
	      service = Factories.services.createAlumnosService();
	      //Salvamos o actualizamos el alumno segun sea una operacion de alta o de edición
	      if (alumno.getId() == null) {
	        service.saveAlumno(alumno);
	      }
	      else {
	        service.updateAlumno(alumno); 
	      }
	      //Actualizamos el javabean de alumnos inyectado en la tabla
	      alumnos = (Alumno [])service.getAlumnos().toArray(new Alumno[0]);
	      return "exito";
	    } catch (Exception e) {
	      e.printStackTrace();
	      return "error";
	    }
	  }
	  public String baja() {
		    AlumnosService service;
		    try {
		      // Acceso a la implementacion de la capa de negocio 
		      // a través de la factoría
		      service = Factories.services.createAlumnosService();
		      //Salvamos o actualizamos el alumno segun sea una operacion de alta o de edición
		      
		      service.deleteAlumno(alumno.getId()); 
		      
		      //Actualizamos el javabean de alumnos inyectado en la tabla
		      alumnos = (Alumno [])service.getAlumnos().toArray(new Alumno[0]);
		      return "exito";
		    } catch (Exception e) {
		      e.printStackTrace();
		      return "error";
		    }
		  }

}
