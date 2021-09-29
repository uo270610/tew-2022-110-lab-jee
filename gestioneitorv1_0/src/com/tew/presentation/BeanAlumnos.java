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
public static long getSerialversionuid() {
	return serialVersionUID;
}
}
