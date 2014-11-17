package app.webservice.config;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class ClientMain {

	public static void main(String[] args) {
		
		HttpClient httpClient = null;
		
		try {
			// Configuraci—n Freemarker
			Configuration cfg = new Configuration();
			// Cargar plantilla
			Template template;
			template = cfg.getTemplate("src/template.ftl");
			// Modelo de datos
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("idPersona", "1");
			// Crear mensaje SOAP HTTP
			StringWriter out = new StringWriter();
			template.process(data, out);
			String strRequest = out.getBuffer().toString();
			System.out.println("template -->   " + strRequest);

			// Crear la llamada al servidor
			httpClient = new DefaultHttpClient();
			
			HttpPost postRequest = new HttpPost("http://localhost:9876/personaInfo");
			
			StringEntity input = new StringEntity(strRequest);
			input.setContentType("text/xml");
			postRequest.setEntity(input);
			
			// Tratar respuesta del servidor
			HttpResponse response = httpClient.execute(postRequest);
			
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Error : C—digo de error HTTP : " + 
				response.getStatusLine().getStatusCode());
			}
			
			System.out.println("response -->   " + response.toString());
			
			//Obtener informaci—n de la respuesta
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			Document XMLDoc = factory.newDocumentBuilder().parse(response.getEntity().getContent());
			XPath xpath = XPathFactory.newInstance().newXPath();
			XPathExpression expr = xpath.compile("//return/nombPerso");
			String result = String.class.cast(expr.evaluate(XMLDoc, XPathConstants.STRING));
			System.out.println("Resultado: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
