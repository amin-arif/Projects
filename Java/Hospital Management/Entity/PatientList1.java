package Entity;

import java.lang.*;

public class PatientList1{
	
	private String date ;
	private String pId;
	private String name;
	private String disease ;
	private String doctor;

	
	public PatientList1() {}
	public PatientList1(String date,String pId,String name ,String disease,String doctor)
	{
		this.name=name;
		this.pId=pId;
		this.disease=disease;
		this.date=date;
		this.doctor=doctor;

	
	}
	
	public void setName(String name){this.name=name;}
	public void setId (String pId){this.pId=pId;}
	public void setDate(String date){this.date=date;}
	public void setDisease(String disease ){this.disease=disease;}
	public void setDoctor(String doctor ){this.doctor=doctor;}
	
	
	public String getName()	{	return name;}
	public String getId(){return pId;}
	public String getDisease(){return disease;}
	public String getDate(){return date;}
	public String getDoctor(){return doctor;}
	
}