package unitn.lifecoach.processcentric;

import javax.jws.WebService;
import javax.swing.text.html.parser.Entity;
import javax.ws.rs.client.Client;   
//import javax.ws.rs.client.Entity;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.*;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;    
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import javax.ws.rs.core.MediaType;


@WebService(endpointInterface = "unitn.lifecoach.processcentric.person")
public class personImpl implements person {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Scanner b = new Scanner(System.in); 
	static javax.ws.rs.core.Response resp = null;
	static ClientConfig clientConfig = new ClientConfig();
	static javax.ws.rs.client.Client client = ClientBuilder.newClient(clientConfig);	
	static WebTarget service = client.target("http://api.theysaidso.com/");
	
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

	private static String getMethod(String path) {
		resp =service.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		//System.out.println("=> Result: "+ resp.getStatus()+ " \n=> HTTP Status: "+ resp.getStatus()+ "\n\n"+  resp.readEntity(String.class));
		return resp.readEntity(String.class);
	}

	

	@Override
	public String getPeople() throws ParseException {
		// TODO Auto-generated method stub
		/*resp =service.path("caregiver").request().accept(MediaType.Appli).get();
		System.out.println("=> Result: "+ resp.getStatus()+ " \n=> HTTP Status: "+ resp.getStatus()+ "\n\n"+  resp.readEntity(String.class));
		*/
		//JSONObject
		String s =getMethod("qod.json");
		org.json.JSONObject jsonObject = new org.json.JSONObject(s);

		String quote = jsonObject.getJSONObject("contents").getString("quote");
		
		//array. = JSONArray.
		//array.add(obj);
        System.out.println(quote);
		return quote;
		//return "Hello World";
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
	
	@Override
	public String Getmotivation()
	{
		String path = "healthmeasurementhistory/motivation"; 
		resp =service.path(path).request().accept(MediaType.APPLICATION_JSON).get();
		org.json.JSONObject jsonObject = new org.json.JSONObject(resp.readEntity(String.class));

		String quote = jsonObject.getJSONObject("contents").getString("quote");
		return quote;
	}

}
