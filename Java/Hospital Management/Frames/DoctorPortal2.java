package Frames;
import Repository.*;
import Entity.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class DoctorPortal2 extends JFrame implements ActionListener
{
	private JLabel nameLabel;
	private JTextField nameTF;
	private JButton logoutBtn,patientInfo;
	private JPanel panel;
	private JTable pTable;
	private JScrollPane pTableSP;
	private DoctorRepo2 dr;
	private Color backColor;
	private Font myFont1,myFont2,myFont3;
	
	User user;
	
	public DoctorPortal2(User user)
	{
		super("Doctor Portal");
		this.setSize(920,620);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.user = user;
		backColor = new Color(140, 240, 130);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(backColor);
		
		dr=new DoctorRepo2();
		
		String data[][] = {{"", "", "", "",""}};
		
		String head[] = {"Date","PId", "Name", "Disease","Appointed_With"};
		
		pTable = new JTable(data,head);
		pTableSP = new JScrollPane(pTable);
		pTableSP.setBounds(100, 100, 500, 150);
		pTable.setEnabled(false);
		panel.add(pTableSP);
		
		
		logoutBtn=new JButton("Logout");
		logoutBtn.setBounds(800,20, 80, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
	
		
		patientInfo =new JButton("Patient Info");
		patientInfo.setBounds(125, 350, 150, 40); 
		patientInfo.addActionListener(this);
		panel.add(patientInfo);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if (command.equals(patientInfo.getText()))
		{	
			String data[][] = dr.getAllPatient();
			String head[] = {"Date", "PId", "Name", "Disease","Appointed_With"};
			
			panel.remove(pTableSP);
			
			pTable = new JTable(data,head);
			pTable.setEnabled(false);
			pTableSP = new JScrollPane(pTable);
			pTableSP.setBounds(100, 100, 500, 150);
			panel.add(pTableSP);
			
			panel.revalidate();
			panel.repaint();
			
			
		}
		
		
		else if(command.equals(logoutBtn.getText()))
		{
			Login lg=new Login();
			lg.setVisible(true);
			this.setVisible(false);
			
		}
		else{}
		
	}	
}
	