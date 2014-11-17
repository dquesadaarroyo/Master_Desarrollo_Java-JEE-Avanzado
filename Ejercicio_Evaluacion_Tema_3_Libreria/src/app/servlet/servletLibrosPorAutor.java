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
 * Servlet implementation class servletAutor
 */
@WebServlet(description = "Servlet con el que obtendremos todos los libros de un autor de nuestra base de datos", 
			name="servletLibrosPorAutor",urlPatterns = { "/servletLibrosPorAutor" })
public class servletLibrosPorAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ItfzGestionLibreria miGestion = new GestionLibreria();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
		response.setContentType("text/html; charset=UTF-8");
	    try (PrintWriter out = response.getWriter()) {

	    	List<Libro> misLibros = null;
	        long idAutor = Long.parseLong(request.getParameter("autor"));
	        StringBuilder sb = new StringBuilder("[");
	        misLibros = miGestion.consultarLibroPorAutor(idAutor);
	        for(Libro l : misLibros){
	        	sb.append("{'isbn':");
	        	sb.append(l.getIsbn());
	        	sb.append(",'titulo':'");
	        	sb.append(l.getTitulo());
	        	sb.append("','precio':'");
	        	sb.append(l.getPrecio());
	        	sb.append("'},");
			}
	        
	        sb.replace(sb.length() - 1, sb.length(), "]");
	        
	        System.out.println(sb);
	        
	        out.println(sb);
	      
		} catch (LibroNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
