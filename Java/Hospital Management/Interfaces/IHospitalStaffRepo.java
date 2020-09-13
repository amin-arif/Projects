package Interfaces;

import java.lang.*;

import Entity.*;

public interface IHospitalStaffRepo
{
	public void insertInDB(HospitalStaff hs);
	public void deleteFromDB(String Id);
	public void updateInDB(HospitalStaff hs);
	public HospitalStaff searchHospitalStaff(String Id);
	public String[][] getAllHospitalStaff();
}