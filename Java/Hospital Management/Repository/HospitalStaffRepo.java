package Repository;
import Entity.*;
import Interfaces.*;

import java.lang.*;
import java.util.ArrayList;


public class HospitalStaffRepo implements IHospitalStaffRepo
{	
	DatabaseConnection dbc;
	
	public HospitalStaffRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(HospitalStaff hs)
	
	{
		String query = "INSERT INTO hospitalstaff VALUES ('"+hs.getId()+"','"+hs.getName()+"','"+hs.getDesignation()+"',"+hs.getSalary()+","+hs.getPhoneNumber()+",'"+hs.getAddress()+"','"+hs.getDepartment()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		
	}
	
	public void deleteFromDB(String id)
	
	{
				String query = "DELETE from hospitalstaff WHERE StaffId ='"+id+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
		
	}
	
	public void updateInDB(HospitalStaff hs)
	
	{
		String query = "UPDATE hospitalstaff SET Name='"+hs.getName()+"',StaffId= '"+hs.getId()+"',Salary= "+hs.getSalary()+",Phone= '"+hs.getPhoneNumber()+"',Address= '"+hs.getAddress()+"',Designation='"+hs.getDesignation()+"',Department='"+hs.getDepartment()+"' WHERE StaffId='"+hs.getId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		
	}
	
	public HospitalStaff searchHospitalStaff(String Id)
	
	{
		HospitalStaff hs = null;
		String query = "SELECT `StaffId`,`Name`, `Designation`,`Salary`,`Phone`,`Address`,`Department` FROM `hospitalstaff` WHERE `StaffId`='"+Id+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("Name");
				String id = dbc.result.getString("StaffId");
				double salary = dbc.result.getDouble("Salary");
				int phnNum = dbc.result.getInt("Phone");
				String address= dbc.result.getString("Address");
				String designation = dbc.result.getString("Designation");
				String department = dbc.result.getString("Department");

				
				hs = new HospitalStaff();
				hs.setId(id);
				hs.setName(name);
				hs.setSalary(salary);
				hs.setPhoneNumber(phnNum);
				hs.setAddress(address);
				hs.setDesignation(designation);
				hs.setDepartment(department);
				
				
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return hs;
		
	}
	
	public String[][] getAllHospitalStaff()
	
	{
		ArrayList<HospitalStaff> ar = new ArrayList<HospitalStaff>();
		String query = "SELECT * FROM hospitalstaff;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String id = dbc.result.getString("staffId");
				String name = dbc.result.getString("Name");
				String designation = dbc.result.getString("Designation");
				double salary = dbc.result.getDouble("Salary");
				int phnNum = dbc.result.getInt("Phone");
				String address = dbc.result.getString("Address");
				String department = dbc.result.getString("Department");
				
				HospitalStaff hs = new HospitalStaff(name,id,salary,phnNum,address,designation,department);
				
				ar.add(hs);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][7];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((HospitalStaff)obj[i]).getId();
			data[i][1] = ((HospitalStaff)obj[i]).getName();
			data[i][2] = ((HospitalStaff)obj[i]).getDesignation();
			data[i][3] = (((HospitalStaff)obj[i]).getSalary())+"";
			data[i][4] = ((HospitalStaff)obj[i]).getPhoneNumber()+"";
			data[i][5] = ((HospitalStaff)obj[i]).getAddress();
			data[i][6] = ((HospitalStaff)obj[i]).getDepartment();
			


		}
		return data;
	
		
	}
	
}