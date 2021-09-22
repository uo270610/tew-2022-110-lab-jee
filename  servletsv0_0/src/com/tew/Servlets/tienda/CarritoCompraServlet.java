package com.tew.Servlets.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarritoCompraServlet
 */
@WebServlet(name = "CarritoCompraServlet", urlPatterns = { "/CarritoCompraServlet" })
public class CarritoCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 3L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarritoCompraServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Carrito de compra</TITLE></HEAD>");
		out.println("<BODY>");

		out.println("Bienvenido a mi web de compras!");
		out.println("<br>");
		out.println("Elige los productos que desees tantas veces como desees");
		out.println("<br>");

		out.println("<form action=\"http://localhost:8080/servletsv0_0/CarritoCompraServlet\" method=post> <SELECT NAME=\"producto\" SIZE=\"1\">\r\n"
				+ " <OPTION VALUE=\"001\">Peras</OPTION>\r\n" + " <OPTION VALUE=\"002\">Manzanas</OPTION>\r\n"
				+ " <OPTION VALUE=\"003\">Platanos</OPTION>\r\n" + " <OPTION VALUE=\"004\">Fresas</OPTION>\r\n"
				+ " <OPTION VALUE=\"005\">Melocotones</OPTION>\r\n" + " <OPTION VALUE=\"006\">Uvas</OPTION>\r\n"
				+ " <OPTION VALUE=\"007\">Chuches</OPTION>\r\n" + " <OPTION VALUE=\"008\">Churros</OPTION>\r\n"
				+ " <OPTION VALUE=\"009\">Gofres</OPTION>\r\n" + " <OPTION VALUE=\"010\">Donuts</OPTION>\r\n"
				+ "</SELECT>");

		// Comprobamos si existe el objeto "carrito" en sesión.
		// Si no existe, lo creamos vacío. Será de tipo HashMap
		@SuppressWarnings("unchecked")
		HashMap<String, Integer> carrito = (HashMap<String, Integer>) request.getSession().getAttribute("carrito");
		if (carrito == null) {
			carrito = new HashMap<String, Integer>();
		}
		// Añadimos el producto recibido al carrito de la compra (en caso de que no sea
		// nulo!)
		String producto = request.getParameter("producto");
		if (producto != null) {
			Integer cantidad = (Integer) carrito.get(producto);
			if (cantidad == null)
				cantidad = new Integer(1);
			else
				cantidad = new Integer(cantidad.intValue() + 1);
			// Y añadimos el producto al carrito
			carrito.put(producto, cantidad);
		}
		// Añadimos el carrito a la sesión
		request.getSession().setAttribute("carrito", carrito);

		out.println("<input type=submit value=añadir al carrito...>");
		out.println("</form>");
		out.println("<br>");

		out.println("Carrito");
		out.println("<br>");

		Set<String> productos = carrito.keySet();
		Iterator<String> iter = productos.iterator();
		out.println("entro en el while :");
		while (iter.hasNext()) {

			String elemento = (String) iter.next();
			Integer cantidad = (Integer) carrito.get(elemento);
			out.println("Del elemento :");
			out.println(elemento);
			out.println(" tienes en el carrito: ");
			out.println(cantidad);
		}

		out.println("<br>");
		out.println("<a href=\"index.html\">volver</a>");

		out.println("</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		/**
		 * response.setCharacterEncoding("UTF-8"); response.setContentType("text/html");
		 * PrintWriter out = response.getWriter(); //Comprobamos si existe el objeto
		 * "carrito" en sesión. //Si no existe, lo creamos vacío. Será de tipo
		 * HashMap @SuppressWarnings("unchecked") HashMap<String,Integer> carrito =
		 * (HashMap<String,Integer>)request.getSession().getAttribute("carrito"); if (
		 * carrito == null ) { carrito = new HashMap<String, Integer>(); } //Añadimos el
		 * producto recibido al carrito de la compra (en caso de que no sea nulo!)
		 * String producto = request.getParameter("producto"); if ( producto != null ){
		 * Integer cantidad = (Integer) carrito.get(producto); if ( cantidad == null )
		 * cantidad = new Integer ( 1 ); else cantidad = new Integer (
		 * cantidad.intValue() + 1 ); //Y añadimos el producto al carrito
		 * carrito.put(producto, cantidad); } //Añadimos el carrito a la sesión
		 * request.getSession().setAttribute("carrito",carrito);
		 * 
		 * 
		 * out.println("<input type=submit value=añadir al carrito...>");
		 * out.println("<br>
		 * ");
		 * 
		 * out.println("Carrito"); out.println("<br>
		 * ");
		 * 
		 * Set<String> productos = carrito.keySet(); Iterator<String> iter =
		 * productos.iterator(); while ( iter.hasNext() ) { String elemento =
		 * (String)iter.next(); Integer cantidad = (Integer) carrito.get(elemento);
		 * out.println("Del elemento :"); out.println(elemento); out.println(" tienes en
		 * el carrito: "); out.println(cantidad); }
		 **/
	}

}
