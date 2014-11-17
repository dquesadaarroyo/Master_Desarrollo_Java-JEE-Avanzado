package app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.modelo.Autor;
import app.negocio.GestionLibreria;
import app.negocio.ItfzGestionLibreria;

/**
 * Servlet implementation class servletAutor
 */
@WebServlet(description = "Servlet con el que obtendremos todos los autores de nuestra base de datos", 
			name="servletAutor",urlPatterns = { "/servletAutor" })
public class servletAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ItfzGestionLibreria miGestion = new GestionLibreria();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
		response.setContentType("text/html; charset=UTF-8");
	    try (PrintWriter out = response.getWriter()) {

	    	List<Autor> misAutores = null;
	        
	        StringBuilder sb = new StringBuilder("[");
	        for(Autor a : miGestion.consultarAutores()){
	        	sb.append("{'id':");
	        	sb.append(a.getId());
	        	sb.append(",'nombre':'");
	        	sb.append(a.getNombre());
	        	sb.append("'},");
			}
	        
	        sb.replace(sb.length() - 1, sb.length(), "]");
	        
	        System.out.println(sb);
	        
	        out.println(sb);
	        
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
