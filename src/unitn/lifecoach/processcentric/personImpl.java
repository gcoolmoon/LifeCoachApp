package unitn.lifecoach.processcentric;

import javax.jws.WebService;
import javax.swing.text.html.parser.Entity;
import javax.ws.rs.client.Client;   
//import javax.ws.rs.client.Entity;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;    
import java.util.Scanner;

import javax.ws.rs.core.MediaType;


@WebService(endpointInterface = "introsde.ws.HelloWorld")
public class personImpl implements person {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Scanner b = new Scanner(System.in); 
	static javax.ws.rs.core.Response resp = null;
	static ClientConfig clientConfig = new ClientConfig();
	static javax.ws.rs.client.Client client = ClientBuilder.newClient(clientConfig);	
	static WebTarget service = client.target("http://localhost:6902/lifecoach");
	
	private static void deleteMethod(String path) {
		resp =service.path(path).request().accept(MediaType.APPLICATION_JSON).delete();
		System.out.println("=> Result: "+ resp.getStatus()+ " \n=> HTTP Status: "+ resp.getStatus()+ "\n\n"+  resp.readEntity(String.class));
		}

		private static void putMethod(String path, String data) {
		resp =service.path(path).request().accept(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.json(data));
		System.out.println("=> Result: "+ resp.getStatus()+ " \n=> HTTP Status: "+ resp.getStatus()+ "\n\n"+  resp.readEntity(String.class));
		}

		private static void postMethod(String path, String data) {
		resp =service.path(path).request().accept(MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.json(data));
		System.out.println("=> Result: "+ resp.getStatus()+ " \n=> HTTP Status: "+ resp.getStatus()+ "\n\n"+  resp.readEntity(String.class));
		}

		private static void getMethod(String path) {
		resp =service.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println("=> Result: "+ resp.getStatus()+ " \n=> HTTP Status: "+ resp.getStatus()+ "\n\n"+  resp.readEntity(String.class));
		}


	@Override
	public Entity getPeople(String input) {
		// TODO Auto-generated method stub
		
		return resp.readEntity(String.class);
	}

	@Override
	public boolean registerHealthMeasure(String input) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerLifeStyle(String input) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerReminder(String input) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setGoals(String input) {
		// TODO Auto-generated method stub
		return false;
	}

}
