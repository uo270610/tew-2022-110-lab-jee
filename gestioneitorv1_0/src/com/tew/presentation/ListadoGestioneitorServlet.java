package com.tew.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tew.business.AlumnosService;
import com.tew.infrastructure.Factories;
import com.tew.model.Alumno;

/**
 * Este servlet recibe las peticiones e:
 *    - invoca a la capa de negocio
 *    - coloca los datos resultado en la request
 *    - deriva a la JSP la formación de la vista  
 * 
 * De ser necesario tambi��n podr��a:
 * 	  - recuperar los datos de la request
 * 	  - pasarselos a la capa de negocio
 * 	  - si salta alguna excepci��n en la invocaci��n a la capa de negocio 
 * 		gestionarla para notific��rselo al usuario de forma adecuada
 * 
 * @author Enrique
 */
@WebServlet(name = "listado", urlPatterns = { "/listado" })
public class ListadoGestioneitorServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		AlumnosService service;
		List<Alumno> alumnos = null;
		try {
			// Acceso a la implementacion de la capa de negocio 
			// a trav��s de la factor��a
			service = Factories.services.createAlumnosService();
			
			alumnos = service.getAlumnos();
			// Se pone disponible el listado de alumnos para el JSP
			request.setAttribute("alumnos", alumnos);
			// Redireccion a la vista
			forwardTo("indexConServlet.jsp", request, response);

		} catch (Exception e) {
			e.printStackTrace();

			// Se redirigir��a a la p��gina de error
			//forwardTo("error.jsp", req, res);
		}
	}

	private void forwardTo(String page, HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(page);
		
		dispatcher.forward(req, res);
	}

	private static final long serialVersionUID = -5431719543391955571L;
}
