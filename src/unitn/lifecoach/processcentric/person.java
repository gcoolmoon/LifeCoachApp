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

import org.json.simple.parser.ParseException;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface person {

	
	@WebMethod(operationName="AddNewPerson")
    @WebResult(name="Newperson") 
    public Boolean AddNewPerson( @WebParam(name="person") String data);
	 //method 1
    @WebMethod(operationName="getPeopleList")
    @WebResult(name="people") 
    public String getPeople() throws ParseException;
    
    //method 2
    @WebMethod(operationName="registerHealthMeasure")
    @WebResult(name="healthMeasure") 
    public boolean registerHealthMeasure(@WebParam(name="person") int personId, @WebParam(name="data") String data);
    
    //method 3
    @WebMethod(operationName="registerLifeStyle")
    @WebResult(name="lifeStyle") 
    public boolean registerLifeStyle(@WebParam(name="lifeStyle") String input, @WebParam(name="data") String data);
	
    //method 4
    @WebMethod(operationName="registerReminder")
    @WebResult(name="reminder") 
    public boolean registerReminder(@WebParam(name="reminder") String input);
    
  //method 5
    @WebMethod(operationName="setGoals")
    @WebResult(name="goals") 
    public boolean setGoals(@WebParam(name="goals") String input);

    @WebMethod(operationName="Getmotivation")
    @WebResult(name="motivation") 
   	public String Getmotivation();
    
    @WebMethod(operationName="GetCurrentMeasure")
    @WebResult(name="currentMeasure") 
   	public String GetCurrentMeasure(@WebParam(name="person") int personId, @WebParam(name="measuretype") int MeasureTypeId);
    
    @WebMethod(operationName="GetAllCurrentMeasure")
    @WebResult(name="allCurrentMeasure") 
   	public String GetAllCurrentMeasure(@WebParam(name="person") int personId);
    
    @WebMethod(operationName="GetAllCareGivers")
    @WebResult(name="caregivers") 
   	public String GetAllCareGiver();
    
    
    @WebMethod(operationName="registerCareGiver")
    @WebResult(name="caregiver") 
    public boolean registerCareGiver(@WebParam(name="caregiver") String input);
    
    @WebMethod(operationName="registerPersonGoal")
    @WebResult(name="personGoal") 
    public boolean registerPersonGoal(@WebParam(name="person")int personId, @WebParam(name="goal") String data);
    
    @WebMethod(operationName="addNewCurrentMeasure")
    @WebResult(name="currentMeasure") 
    public boolean registerCurrentMeasure(@WebParam(name="person") int personId, @WebParam(name="measure") String measure);
    
    @WebMethod(operationName="getPersonalGoal")
    @WebResult(name="PersonalGoal") 
    public String getPersonalGoal(@WebParam(name="person") int personId,
    		@WebParam(name="measureType") int measureTypeId);
    
    @WebMethod(operationName="getAllPersonalGoals")
    @WebResult(name="PersonalGoal") 
    public String getAllPersonalGoals(@WebParam(name="person") int personId);
    
    @WebMethod(operationName="getMeasureDefinition")
    @WebResult(name="MeasureDefinition") 
    public String getMeasureDefinition();
    
    @WebMethod(operationName="getMeasureHistory")
    @WebResult(name="MeasureHistory") 
    public String getMeasureHistory(@WebParam(name="person") int personId,
    		@WebParam(name="measureType") int measureTypeId);
    
    
    @WebMethod(operationName="getReminder")
    @WebResult(name="Reminder") 
    public String getReminder(@WebParam(name="person") int personId);
    
    @WebMethod(operationName="AddReminder")
    @WebResult(name="Reminder") 
    public String AddReminder(@WebParam(name="person") int personId, @WebParam(name="reminder")String data);
    
    @WebMethod(operationName="TrackGoal")
    @WebResult(name="trackgoal") 
    public String TrackGoal(@WebParam(name="person") int personId, 
    		@WebParam(name="measureType") int measureTypeId);
    
    @WebMethod(operationName="EmailReminder")
    @WebResult(name="emailreminder") 
    public String EmailReminder(@WebParam(name="person") int personId);
    
    @WebMethod(operationName="PostTweet")
    @WebResult(name="posttweet") 
    public String PostTweet(@WebParam(name="message") int message);
}
