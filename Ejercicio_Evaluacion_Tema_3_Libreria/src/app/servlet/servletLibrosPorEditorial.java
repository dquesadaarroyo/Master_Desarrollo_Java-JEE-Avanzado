package app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.excepciones.LibroNoEncontradoException;
import app.modelo.Libro;
import app.negocio.GestionLibreria;
import app.negocio.ItfzGestionLibreria;

/**
 * Servlet implementation class servletLibrosPorEditorial
 */
@WebServlet(description = "Servlet con el que obtendremos todos los libros de una editorial de nuestra base de datos", name = "servletLibrosPorEditorial", urlPatterns = { "/servletLibrosPorEditorial" })
public class servletLibrosPorEditorial extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ItfzGestionLibreria miGestion = new GestionLibreria();

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/xml; charset=UTF-8");
			try (PrintWriter out = response.getWriter()) {

			List<Libro> misLibros = null;
			long idEditorial = Long.parseLong(request.getParameter("editorial"));
			
	        StringBuilder sb = new StringBuilder("<?xml version='1.0' ?>");
	        sb.append("<libro>");
	        
	        misLibros = miGestion.consultarLibroPorEditorial(idEditorial);
	        for (Libro l : misLibros) {
	        	
	        	sb.append("<datos_libro>");
	        	sb.append("<isbn>").append(l.getIsbn()).append("</isbn>");
	        	sb.append("<titulo>").append(l.getTitulo()).append("</titulo>");
	        	sb.append("<precio>").append(l.getPrecio()).append("</precio>");
	        	sb.append("</datos_libro>");
	        	
	        }
	        
	        sb.append("</libro>");

			System.out.println(sb);

			out.println(sb);

		} catch (LibroNoEncontradoException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
