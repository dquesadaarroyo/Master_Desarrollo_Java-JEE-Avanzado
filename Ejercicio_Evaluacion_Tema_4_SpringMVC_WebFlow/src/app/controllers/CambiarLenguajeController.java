package app.controllers;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping("/cambiarLenguajeController")
public class CambiarLenguajeController{
	 
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        try {
            RequestContextUtils.getLocaleResolver(request).setLocale(request, response, new Locale(request.getParameter("siteLanguage")));
        } catch (Exception ex) {
        }
 
        return new ModelAndView("inicioCalc");
    }


}