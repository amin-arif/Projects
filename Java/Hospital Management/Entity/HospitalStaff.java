package Entity;

import java.lang.*;

public class HospitalStaff{
	
	private String name ;
	private String id;
	private double salary;
	private  int phnNum;
	private String address;
	private String designation;
	private String department;
	
	public HospitalStaff() {}
	public HospitalStaff(String name,String id,double salary,int phnNum,String address,String designation,String department)
	{
		this.name=name;
		this.id=id;
		this.phnNum=phnNum;
		this.address=address;
		this.designation=designation;
		this.salary = salary;
		this.department=department;
	}
	
	public void setName(String name){this.name=name;}
	public void setId (String id){this.id=id;}
	public void setSalary(double salary){this.salary=salary;}
	public void setPhoneNumber(int phnNum){this.phnNum=phnNum;}
	public void setAddress(String  address){this.address=address;}
	public void setDesignation(String designation){this.designation=designation;}
	public void setDepartment(String department){this.department=department;}
	
	public String getName()	{	return name;}
	public String getId(){return id;}
	public double  getSalary(){return salary;}
	public int getPhoneNumber(){return phnNum ;}
	public String getAddress(){return address;}
	public String getDesignation(){return designation;}
	public String getDepartment (){return department;}
	
}