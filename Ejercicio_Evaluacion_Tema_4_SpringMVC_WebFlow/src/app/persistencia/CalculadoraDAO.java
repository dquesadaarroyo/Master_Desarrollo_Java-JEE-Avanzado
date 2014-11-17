package app.persistencia;

import org.springframework.stereotype.Component;

@Component(value="calculadoraDAO")
public class CalculadoraDAO {
	
	public boolean validaDivisor(int numero){
		if(numero == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validaOperacion(String operacion){
		if("/".equals(operacion)){
			return true;
		}else{
			return false;
		}
	}
	
	public double calcular(double n1, double n2, String op){
		double resultado = 0;
		
		switch (op) {
		case "+":
			resultado = n1 + n2;
			break;

		case "-":
			resultado = n1 - n2;
			break;

		case "x":
			resultado = n1 * n2;
			break;

		case "/":
			resultado = n1 / n2;
			break;

		}
		
		return resultado;
	}
}
