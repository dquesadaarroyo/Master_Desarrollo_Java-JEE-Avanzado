package app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.modelo.Libro;
import app.negocio.GestionLibreria;
import app.negocio.ItfzGestionLibreria;

/**
 * Servlet implementation class servletLibrosPorTitulo
 */
@WebServlet(description = "Servlet con el que mostramos los libros filtrando por el titulo", 
name="servletLibrosPorTitulo",urlPatterns = { "/servletLibrosPorTitulo" })
public class servletLibrosPorTitulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ItfzGestionLibreria miGestion = new GestionLibreria();

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			
			List<Libro> misLibros = null;
			System.out.println(request.getParameter("dato"));
			misLibros = miGestion.autoCompletaTitulo(request.getParameter("dato"));
			StringBuilder sb = new StringBuilder("[");

			for (Libro l : misLibros) {
				sb.append("{'isbn':");
				sb.append(l.getIsbn());
				sb.append(",'titulo':'");
				sb.append(l.getTitulo());
				sb.append("','precio':'");
				sb.append(l.getPrecio());
				sb.append("','descripcion':'");
				sb.append(l.getDescripcion());
				sb.append("'},");
			}

			sb.replace(sb.length() - 1, sb.length(), "]");

			System.out.println(sb);

			out.println(sb);
		}
	}  
    
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
