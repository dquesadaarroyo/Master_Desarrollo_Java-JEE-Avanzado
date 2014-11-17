package app.modelo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component(value="calculadora")
public class Calculadora implements Serializable{

	private static final long serialVersionUID = 1L;

	private double numero1;
	private double numero2;
	private String operacion;
	
	public Calculadora(){
		
	}
	
	public Calculadora(double numero1, double numero2, String operacion) {
		super();
		this.numero1 = numero1;
		this.numero2 = numero2;
		this.operacion = operacion;
	}

	public double getNumero1() {
		return numero1;
	}

	public void setNumero1(double numero1) {
		this.numero1 = numero1;
	}

	public double getNumero2() {
		return numero2;
	}

	public void setNumero2(double numero2) {
		this.numero2 = numero2;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	
	
	@Override
	public String toString() {
		return "Calculadora [numero1=" + numero1 + ", numero2=" + numero2
				+ ", operacion=" + operacion + "]";
	}

}
