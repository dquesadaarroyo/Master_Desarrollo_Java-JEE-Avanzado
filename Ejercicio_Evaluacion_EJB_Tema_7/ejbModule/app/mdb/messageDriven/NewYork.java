package app.mdb.messageDriven;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import app.mdb.modelo.Persona;

/**
 * Message-Driven Bean implementation class for: NewYork
 * Clase con la que recogemos el mensaje enviado. Para que sean envios tipo Productor-Suscriptor, lo configuramos
 * como un topic
 */
@MessageDriven(mappedName = "topic/test", activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/test"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "clientId", propertyValue = "SubscriptorNewYork"),
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "SubscriptorNewYork")
})
public class NewYork implements MessageListener {

    /**
     * Default constructor. 
     */
    public NewYork() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
		try {
			System.out.println("Estamos en el método onMessage de la clase New York,"
							+ "del proyecto EJB Ejercicio_Evaluacion_EJB_Tema_7");
			if (message instanceof TextMessage) {
				System.out.println("Tema (Topic): Recibo un TextMessage en New York a las " + new Date());
				TextMessage msg = (TextMessage) message;
				System.out.println("El mensaje en New York es: " + msg.getText());
			} else if (message instanceof ObjectMessage) {
				System.out.println("Tema (Topic): Recibo un ObjectMessage en New York a las " + new Date());
				ObjectMessage msg = (ObjectMessage) message;
				Persona persona = (Persona) msg.getObject();
				System.out.println("Detalle cliente en New York: ");
				System.out.println("Nombre en New York: " + persona.getNombre());
				System.out.println("Apellidos en New York: " + persona.getApellido1() + " " + persona.getApellido2());
				System.out.println("Teléfono en New York: " + persona.getTelefono());
				System.out.println("Notas en New York: " + persona.getNotas());
			} else {
				System.out
						.println("No es un mensaje valido para este Topic MDB en New York");
			}

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void creado() {
		System.out.println("INVOCADO: PostConstruct en New York");
	}

	@PreDestroy
	public void destruido() {
		System.out.println("INVOCADO: PreDestroy en New York");
	}

}
