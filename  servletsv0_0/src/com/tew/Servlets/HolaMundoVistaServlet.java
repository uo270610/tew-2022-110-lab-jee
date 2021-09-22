package com.tew.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundoVistaServlet
 */
@WebServlet(name = "HolaMundoVista", urlPatterns = { "/HolaMundoVista" })
public class HolaMundoVistaServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundoVistaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
   	 	response.setContentType("text/html");
   	 	PrintWriter out = response.getWriter();
   	 	out.println("<HTML>");
   	 	out.println("<HEAD><TITLE>Hola Mundo!</TITLE></HEAD>");
   	 	out.println("<BODY>");
   	 	
   	 	
   	    String nombre = (String) request.getParameter("NombreUsuario");
   	    
   	    if ( nombre != null ){
   	 	out.println("<br>Hola "+nombre+"<br>");
   	    }
   	 	
   	    @SuppressWarnings("unchecked")
	    Vector<String> listado = 
	    (Vector<String>)request.getSession().getAttribute("listado");

   	    out.println("Bienvenido a mi primera página web!");
	    out.println("<br>");
	    out.println("Contigo, hoy me han visitado:<br>");
	    
	    for ( int i = 0 ; i < listado.size() ; i++ ){
	    
	    	out.println("<br>"+(String)listado.elementAt(i));
	    }
	    
	    Integer contador= (Integer) getServletContext().getAttribute("contador");
   	    if ( contador == null ){
   	    contador = new Integer(0);
   	    }
	    
	    
	    out.println("<br><br>" + contador +" visitas");
	    
	    out.println("<a href=\"index.html\">volver</a>");
	    
	    out.println("</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
