package com.tew.presentation;

import java.util.List;

import com.tew.business.AlumnosService;
import com.tew.infrastructure.Factories;
import com.tew.model.Alumno;

public class GestioneitorBean implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AlumnosService service;
	

	public GestioneitorBean() {

		// Acceso a la implementacion de la capa de negocio
		// a través de la factoría
		service = Factories.services.createAlumnosService();
	};

	public List<Alumno> getListado() {
	    List<Alumno> listado = null;
		try {

			listado = service.getAlumnos();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return listado;
	}
}
