package Interfaces;

import java.lang.*;

import Entity.*;

public interface IAppointmentRepo
{
	
	public void insertInDB(Patient p,String d,String combo,String name);
	public Patient searchPatient(String id);
	
}