package com.tew.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
    	 String nombre = (String) request.getParameter("NombreUsuario");
    	 response.setCharacterEncoding("UTF-8");
    	 response.setContentType("text/html");
    	 PrintWriter out = response.getWriter();
    	 out.println("<HTML>");
    	 out.println("<HEAD><TITLE>Hola Mundo!</TITLE></HEAD>");
    	 out.println("<BODY>");
    	 
    	 if ( nombre != null ){
    	 out.println("<br>Hola "+nombre+"<br>");
    	 }
    	 out.println("Bienvenido a mi primera página Web!");
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
