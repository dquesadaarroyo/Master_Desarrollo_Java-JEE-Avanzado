package app.controllers;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import app.mdb.modelo.Persona;

public class JMSController {
	
	private JmsTemplate jmsTemplate;
	private Destination destino;
	private Persona miPersona = new Persona();

	public JMSController() {

	}

	public JMSController(JmsTemplate jmsTemplate, Destination destino) {
		this.jmsTemplate = jmsTemplate;
		this.destino = destino;
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public Destination getDestino() {
		return destino;
	}
	
	public void setDestino(Destination destino) {
		this.destino = destino;
	}

	public Persona getMiPersona() {
		return miPersona;
	}

	public void setMiPersona(Persona miPersona) {
		this.miPersona = miPersona;
	}

	/**
	 * Método con el que enviamos un mensaje con los datos de la persona introducida en el formulario a los suscriptores que 
	 * haya conectados en ese momento. En nuestro caso habrá dos suscriptores, New York e Inglaterra.
	 * @return
	 */
	public String enviarMensaje() {

		System.out.println("Estamos en el método doGet de la clase JMSController,"
				+ "del proyecto Ejercicio_Evaluacion_Tema_7" + miPersona.toString());

		jmsTemplate.send(destino, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(miPersona);
			}
		});

		System.out.println("2. Enviando ObjectMessage a la Queue");

		return "mostrarMensaje";
	}
	
	
}
