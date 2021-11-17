package com.tew.persistence;

import java.util.List;

import com.tew.model.Alumno;
import com.tew.persistence.exception.AlreadyPersistedException;
import com.tew.persistence.exception.NotPersistedException;

/**
 * Interfaz de la fachada a servicios de persistencia para la entidad Alumno.
 * 
 * En esta versi��n aparecen los otros m��todos b��sicos de un servicio 
 * de persistencia
 * 
 * @author alb
 *
 */
public interface AlumnoDao {

	List<Alumno> getAlumnos();
	void save(Alumno a) throws AlreadyPersistedException;
	void update(Alumno a) throws NotPersistedException;
	void delete(Long id) throws NotPersistedException;
	Alumno findById(Long id);

}