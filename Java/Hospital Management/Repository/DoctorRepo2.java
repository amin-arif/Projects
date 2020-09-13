package Repository;
import Entity.*;
import Interfaces.*;

import java.lang.*;
import java.util.ArrayList;



public class DoctorRepo2 implements IDoctorRepo2
{	
	DatabaseConnection dbc;
	
	public DoctorRepo2()
	{
		dbc = new DatabaseConnection();
	}
	
	public String[][] getAllPatient()
	
	{
		ArrayList<PatientList2> ar = new ArrayList<PatientList2>();
		String query = "SELECT * FROM Patientlist2;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String date = dbc.result.getString("Date");
				String pId = dbc.result.getString("PId");
				String name = dbc.result.getString("Name");
				String disease = dbc.result.getString("Disease");
				String doctor = dbc.result.getString("Appointed_With");
				
				
				PatientList2 pl = new PatientList2(date,pId,name,disease,doctor);
				
				ar.add(pl);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((PatientList2)obj[i]).getDate();
		    data[i][1] = ((PatientList2)obj[i]).getId();
			data[i][2] = ((PatientList2)obj[i]).getName();
			data[i][3] = ((PatientList2)obj[i]).getDisease();
			data[i][4] = ((PatientList2)obj[i]).getDoctor();
			


		}
		return data;
	
		
	}
	
}	
	