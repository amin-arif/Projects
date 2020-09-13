package Repository;
import Entity.*;
import Interfaces.*;

import java.lang.*;
import java.util.ArrayList;

public class AppointmentRepo implements IAppointmentRepo
{
	
		
	DatabaseConnection dbc;
	
	public AppointmentRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Patient p,String d,String combo,String name)
	
	{   if (combo == "medicine"){
		String query = "INSERT INTO Patientlist VALUES ('"+d+"','"+p.getId()+"','"+p.getName()+"','"+p.getDisease()+"','"+name+"');";
		
	
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		}
		
		else if (combo == "eye"){
		String query = "INSERT INTO Patientlist1 VALUES ('"+d+"','"+p.getId()+"','"+p.getName()+"','"+p.getDisease()+"','"+name+"');";
		
	
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		}
		
		else if (combo == "skin"){
		String query = "INSERT INTO Patientlist2 VALUES ('"+d+"','"+p.getId()+"','"+p.getName()+"','"+p.getDisease()+"','"+name+"');";
		
	
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		}
		
		else if (combo == "psychology"){
		String query = "INSERT INTO Patientlist3 VALUES ('"+d+"','"+p.getId()+"','"+p.getName()+"','"+p.getDisease()+"','"+name+"');";
		
	
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		}
		
		else{}
		
		
		
	}
	
	public Patient searchPatient(String Id)
	
	{
		Patient p = null;
		String query = "SELECT `PId`,`Name`, `Disease` FROM `Patient` WHERE `PId`='"+Id+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("Name");
				String id = dbc.result.getString("PId");
	
				String disease = dbc.result.getString("Disease");

				
				p= new Patient();
				p.setId(id);
				p.setName(name);
				p.setDisease(disease);
			
				
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return p;
		
	}
	
}