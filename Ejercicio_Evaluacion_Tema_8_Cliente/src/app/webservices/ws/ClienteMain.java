package app.webservices.ws;

import java.rmi.RemoteException;

public class ClienteMain {

	public static void main(String[] args) {
		System.out.println("Resultado cliente:");
		ItfzPersonaInfoWebService iface = new ItfzPersonaInfoWebServiceProxy("http://localhost:9876/personaInfo");
		try {
			System.out.println("Resultado cliente: " + iface.getPersonaInfo("1").getNombPerso());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}

}
