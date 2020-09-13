package Entity;

import java.lang.*;

class Receptionist{
	
	
	private String rName ;
	private String rId;
	private int age;
	private String gender ;
	private int phnNum;
	private String address;
	private String email;
	
	public Receptionist() {}
	public Receptionist(String rName,String rId,int age ,String gender,int phnNum, String address,String email)
	{
		this.rName=rName;
		this.rId=rId;
		this.age=age;
		this.gender=gender;
		this.phnNum=phnNum;
		this.address=address;
		this.email=email;
	}
	
	public void setName(String pName){this.rName=rName;}
	public void setId (String rId){this.rId=rId;}
	public void setAge(int age){this.age=age;}
	public void setGender(String gender ){this.gender=gender;}
	public  void setPhoneNumber(int phnNum){this.phnNum=phnNum;}
	public void setAddress(String  address){this.address=address;}
	public void setEmail(String email){this.email=email;}
	
	public String getName()	{	return rName;}
	public String getId(){return rId;}
	public int  getAge(){return age;}
	public String getGender(){return gender;}
	public int getPhoneNumber(){return phnNum ;}
	public String getAddress(){return address;}
	public String getEmail(){return email;}
	
}