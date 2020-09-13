package Entity;

import java.lang.*;

public class Patient{
	
	private String pName ;
	private String pId;
	private int age;
	private String gender ;
	private  int phnNum;
	private String address;
	private String disease;
	
	public Patient() {}
	public Patient(String pName,String pId,int age ,String gender,int phnNum, String address,String disease)
	{
		this.pName=pName;
		this.pId=pId;
		this.age=age;
		this.gender=gender;
		this.phnNum=phnNum;
		this.address=address;
		this.disease=disease;
	}
	
	public void setName(String pName){this.pName=pName;}
	public void setId (String pId){this.pId=pId;}
	public void setAge(int age){this.age=age;}
	public void setGender(String gender ){this.gender=gender;}
	public  void setPhoneNumber(int phnNum){this.phnNum=phnNum;}
	public void setAddress(String  address){this.address=address;}
	public void setDisease(String disease){this.disease=disease;}
	
	public String getName()	{	return pName;}
	public String getId(){return pId;}
	public int  getAge(){return age;}
	public String getGender(){return gender;}
	public int getPhoneNumber(){return phnNum ;}
	public String getAddress(){return address;}
	public String getDisease(){return disease;}
	
}