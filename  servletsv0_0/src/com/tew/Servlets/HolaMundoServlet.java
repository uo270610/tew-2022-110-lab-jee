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
 * Servlet implementation class HolaMundoServlet
 */
@WebServlet(name = "HolaMundo", urlPatterns = { "/HolaMundoCordial" })
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    /** autogenerado doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	*/
    
    
    //proporcionados por profes
    public void doGet (HttpServletRequest request, HttpServletResponse response)
    		 throws IOException, ServletException {
    	
    	response.setCharacterEncoding("UTF-8");
   	 	response.setContentType("text/html");
   	 	PrintWriter out = response.getWriter();
   	 	out.println("<HTML>");
   	 	out.println("<HEAD><TITLE>Hola Mundo!</TITLE></HEAD>");
   	 	out.println("<BODY>");
    	 
    	 
    	 
    	 String nombre = (String) request.getParameter("NombreUsuario");
    	 @SuppressWarnings("unchecked")
    	 Vector<String> listado = 
    	 (Vector<String>)request.getSession().getAttribute("listado");
    	 if (listado == null){
    	 listado = new Vector<String>();
    	 }
    	 if ( nombre != null ){
    	 out.println("<br>Hola "+nombre+"<br>");
    	 listado.addElement(nombre);
    	 }
    	 request.getSession().setAttribute("listado",listado);
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
    	 // Establecemos el contador como atributo del context bajo el nombre 
    	 // contador. En caso de que ya existiera, sobreescribiría la referencia
    	 // existente con la nueva.
    	 getServletContext().setAttribute("contador",new Integer(contador.intValue()+1));
    	 out.println("<br><br>" + contador +" visitas");
    	 
    	 
    	 out.println("<a href=\"index.html\">volver</a>");

    	 
    	 
    	 
    	 out.println("</BODY></HTML>");
    		}

    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    /** autogenerado doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	*/
    
    //proporcionados por profes
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    		 throws IOException, ServletException {
    		 doGet(request,response );
    		}

    
    
    

}
