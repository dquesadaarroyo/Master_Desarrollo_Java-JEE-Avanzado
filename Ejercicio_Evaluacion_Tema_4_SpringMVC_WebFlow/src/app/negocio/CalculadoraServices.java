package app.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.modelo.Calculadora;
import app.persistencia.CalculadoraDAO;

@Component(value="calculadoraServices")
public class CalculadoraServices {
	
	@Autowired
	private CalculadoraDAO calculadoraDAO;
	
	public CalculadoraDAO getCalculadoraDAO() {
		return calculadoraDAO;
	}

	public void setCalculadoraDAO(CalculadoraDAO calculadoraDAO) {
		this.calculadoraDAO = calculadoraDAO;
	}
	
	
	
	public boolean validaDivisor(int numero){
		return calculadoraDAO.validaDivisor(numero);
	}
	
	public boolean validaOperacion(String operacion){
		return calculadoraDAO.validaOperacion(operacion);
	}
	
	public double calcular(double n1, double n2, String op){
		return calculadoraDAO.calcular(n1, n2, op);
	}

}
