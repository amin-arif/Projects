package Repository;

import java.lang.*;
import java.util.ArrayList;
import Entity.*;
import Interfaces.*;

public class PatientRepo implements IPatientRepo
{	
	DatabaseConnection dbc;
	
	public PatientRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Patient p)
	
	{
		String query = "INSERT INTO patient VALUES ('"+p.getId()+"','"+p.getName()+"','"+p.getAddress()+"','"+p.getDisease()+"','"+p.getGender()+"',"+p.getAge()+","+p.getPhoneNumber()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		
	}
	
	public void deleteFromDB(String pId)
	
	{
				String query = "DELETE from patient WHERE PId='"+pId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
		
	}
	
	public void updateInDB(Patient p)
	
	{
		String query = "UPDATE patient SET Name='"+p.getName()+"', Gender= '"+p.getGender()+"',Phone= "+p.getPhoneNumber()+",Address= '"+p.getAddress()+"',Age= "+p.getAge()+", Disease = '"+p.getDisease()+"' WHERE PId='"+p.getId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		
	}
	
	public Patient searchPatient(String pId)
	
	{
		Patient p = null;
		String query = "SELECT `Name`,`Address`,`Disease`, `Gender`,`Age`,`Phone`  FROM `patient` WHERE `PId`='"+pId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("Name");
				int age = dbc.result.getInt("Age");
				String gender = dbc.result.getString("Gender");
				int phoneNumber = dbc.result.getInt("Phone");
				String address= dbc.result.getString("Address");
				String disease = dbc.result.getString("Disease");

				
				p = new Patient();
				p.setId(pId);
				p.setName(name);
				p.setAge(age);
				p.setGender(gender);
				p.setPhoneNumber(phoneNumber);
				p.setAddress(address);
				p.setDisease(disease);
				
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return p;
		
	}
	
	public String[][] getAllPatient()
	
	{
		ArrayList<Patient> ar = new ArrayList<Patient>();
		String query = "SELECT * FROM patient;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String pId = dbc.result.getString("pId");
				String pName = dbc.result.getString("Name");
				String address = dbc.result.getString("Address");
				int age = dbc.result.getInt("Age");
				String disease=dbc.result.getString("Disease");
				int phnNum=dbc.result.getInt("Phone");
				String gender=dbc.result.getString("Gender");
				
				Patient p = new Patient(pName,pId,age,gender,phnNum,address,disease);
				ar.add(p);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][7];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Patient)obj[i]).getId();
			data[i][1] = ((Patient)obj[i]).getName();
			data[i][2] = ((Patient)obj[i]).getAddress();
			data[i][3] = ((Patient)obj[i]).getDisease();
			data[i][4] = ((Patient)obj[i]).getGender();
			data[i][5] = ((Patient)obj[i]).getAge()+"";
			data[i][6] = ((Patient)obj[i]).getPhoneNumber()+"";
		}
		return data;
	
		
	}
	
	
	
}