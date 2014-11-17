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
 * Servlet implementation class servletAutoCompletarTitulo
 */
@WebServlet(description = "Servlet con el que autocompletamos los titulos", 
			name="servletAutoCompletarTitulo",urlPatterns = { "/servletAutoCompletarTitulo" })
public class servletAutoCompletarTitulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ItfzGestionLibreria miGestion = new GestionLibreria();

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			
			List<Libro> misLibros = null;
			misLibros = miGestion.autoCompletaTitulo(request.getParameter("texto"));
			
			String result = "<ul style=\"list-style: none\">";
			
			for (Libro l : misLibros) {			
                result += "<li>" + l.getTitulo() + "</li>";
            }

            result += "</ul>";
            System.out.println(result);
            out.println(result);
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
