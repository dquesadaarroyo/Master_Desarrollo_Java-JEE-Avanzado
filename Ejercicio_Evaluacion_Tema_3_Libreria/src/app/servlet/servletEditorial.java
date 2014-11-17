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
import app.modelo.Editorial;
import app.negocio.GestionLibreria;
import app.negocio.ItfzGestionLibreria;

/**
 * Servlet implementation class servletEditorial
 */
@WebServlet(description = "Servlet con el que obtendremos todas las editoriales de nuestra base de datos", 
name="servletEditorial",urlPatterns = { "/servletEditorial" })
public class servletEditorial extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ItfzGestionLibreria miGestion = new GestionLibreria();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
    	response.setContentType("text/html; charset=UTF-8");
	    try (PrintWriter out = response.getWriter()) {

	    	List<Editorial> misEditoriales = null;
	        
	        StringBuilder sb = new StringBuilder("[");
	        for(Editorial e : miGestion.consultarEditoriales()){
	        	sb.append("{'id':");
	        	sb.append(e.getId());
	        	sb.append(",'nombre':'");
	        	sb.append(e.getNombre());
	        	sb.append("','nif':'");
	        	sb.append(e.getNif());
	        	sb.append("','id_direccion':");
	        	sb.append(e.getDireccion().getId());
	        	sb.append(",'calle_direccion':'");
	        	sb.append(e.getDireccion().getCalle());
	        	sb.append("','CP_direccion':");
	        	sb.append(e.getDireccion().getCp());
	        	sb.append(",'numero_direccion':");
	        	sb.append(e.getDireccion().getNumero());
	        	sb.append(",'poblacion_direccion':'");
	        	sb.append(e.getDireccion().getPoblacion());
	        	sb.append("','provincia_direccion':'");
	        	sb.append(e.getDireccion().getProvincia());
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
