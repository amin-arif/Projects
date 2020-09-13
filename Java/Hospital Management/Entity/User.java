package Entity;

import java.lang.*;

public class User
{
	private String userId;
	private String password;
	private int status;
	private String department;
	
	public User(){}
	public User(String userId, String password, int status,String department)
	{
		this.userId = userId;
		this.password = password;
		this.status = status;
		this.department=department;
	}
	
	public void setUserId(String userId){this.userId = userId;}
	public void setPassword(String password){this.password = password;}
	public void setStatus(int status){this.status = status;}
	public void setDepartment(String department){this.department=department;}
	
	public String getUserId(){return userId;}
	public String getPassword(){return password;}
	public int getStatus(){return status;}
	public String getDepartment(){return department;}
}