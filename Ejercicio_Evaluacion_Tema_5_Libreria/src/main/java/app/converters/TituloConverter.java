package app.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import app.beans.LibreriaBean;
import app.modelo.Libro;

/*Clase que nos convierte el objeto introducido por pantalla en un String, y de String lo convierte a un objeto.*/
@FacesConverter(value="tituloConverter")
public class TituloConverter implements Converter{
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                LibreriaBean service = (LibreriaBean) fc.getExternalContext().getApplicationMap().get("libreriaBean");
                return service.getMisLibros().get(Integer.parseInt(value) - 1);
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid book."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Libro) object).getId());
        }
        else {
            return null;
        }
    }   
}
