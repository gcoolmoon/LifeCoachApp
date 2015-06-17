package unitn.lifecoach.processcentric;

//import unitn.lifecoach.model.*;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface person {

	 //method 1
    @WebMethod(operationName="getPeopleList")
    @WebResult(name="people") 
    public String getPeople(@WebParam(name="path") String input);
    
    //method 2
    @WebMethod(operationName="registerHealthMeasure")
    @WebResult(name="healthMeasure") 
    public boolean registerHealthMeasure(@WebParam(name="healthMeasure") String input);
    
    //method 3
    @WebMethod(operationName="registerLifeStyle")
    @WebResult(name="lifeStyle") 
    public boolean registerLifeStyle(@WebParam(name="lifeStyle") String input);
	
    //method 4
    @WebMethod(operationName="registerReminder")
    @WebResult(name="reminder") 
    public boolean registerReminder(@WebParam(name="reminder") String input);
    
  //method 5
    @WebMethod(operationName="setGoals")
    @WebResult(name="goals") 
    public boolean setGoals(@WebParam(name="goals") String input);
    
}
