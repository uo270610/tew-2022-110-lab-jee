package com.tew.persistence;

import com.tew.persistence.AlumnoDao;

/**
 * Interfaz de la factoria que suministra implementaciones reales de la fachada 
 * de persistencia para cada Entidad del Modelo (en este caso solo hay 
 * una: Alumno; pero en futuras versiones habr�� m��s)
 *  
 * @author Enrique
 *
 */
public interface PersistenceFactory {
	
	AlumnoDao createAlumnoDao();
	
	// ... otros m��todos factoria para Daos de otras entidades del modelo ...
}

