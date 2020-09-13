package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Repository.*;
import Entity.*;


public class AdminPortal extends JFrame implements ActionListener
{
	private JLabel titleLabel,adIdLabel, adNameLabel, adDesignationLabel, adSalaryLabel,adPhoneLabel,adAddressLabel,adDepLab;
	private JTextField adIdTF, adNameTF, adDesignationTF, adSalaryTF,adPhoneTF,adAddressTF,adDepTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn,logoutBtn;
	private JPanel panel;
	private JTable adTable;
	private JScrollPane adTableSP;
	private Color backColor;
	private Font myFont1,myFont2;
	
	private User user;
	private HospitalStaffRepo hr;
	private UserRepo ur;
	
	
	public AdminPortal(User user)
	{
		super("Admin Portal");
		this.setSize(920,620);

		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backColor = new Color(140, 240, 130);
		myFont2=new Font ("Impact",Font.PLAIN,30);
		this.user = user;
		
		hr = new HospitalStaffRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(backColor);
		
		
		String data[][] = {{"", "", "", "","","",""}};
		
		String head[] = {"StaffId", "Name", "Designation", "Salary","Phone","Address","Department"};
		
		adTable = new JTable(data,head);
		adTableSP = new JScrollPane(adTable);
		adTableSP.setBounds(350, 100, 520, 275);
		adTable.setEnabled(false);
		panel.add(adTableSP);
		
		titleLabel = new JLabel("Admin Office");
		titleLabel.setBounds(20,20,200,50);
		titleLabel.setFont(myFont2);
		panel.add(titleLabel);
		
		adIdLabel = new JLabel("ID :");
		adIdLabel.setBounds(100,100,100,30);
		panel.add(adIdLabel);
		
		adIdTF = new JTextField();
		adIdTF.setBounds(220,100,100,30);
		panel.add(adIdTF);
		
		adNameLabel = new JLabel("Name :");
		adNameLabel.setBounds(100,150,100,30);
		panel.add(adNameLabel);
		
		adNameTF = new JTextField();
		adNameTF.setBounds(220,150,100,30);
		panel.add(adNameTF);
		
		adDesignationLabel = new JLabel("Designation: ");
		adDesignationLabel.setBounds(100,200,100,30);
		panel.add(adDesignationLabel);
		
		adDesignationTF = new JTextField();
		adDesignationTF.setBounds(220,200,100,30);
		panel.add(adDesignationTF);
		
		adSalaryLabel = new JLabel("Salary: ");
		adSalaryLabel.setBounds(100,250,100,30);
		panel.add(adSalaryLabel);
		
		adSalaryTF = new JTextField();
		adSalaryTF.setBounds(220,250,100,30);
		panel.add(adSalaryTF);
		
		adPhoneLabel = new JLabel("Phone: ");
		adPhoneLabel.setBounds(100,300,100,30);
		panel.add(adPhoneLabel);
		
		adPhoneTF = new JTextField();
		adPhoneTF.setBounds(220,300,100,30);
		panel.add(adPhoneTF);
		
		adAddressLabel = new JLabel("Address: ");
		adAddressLabel.setBounds(100,350,100,30);
		panel.add(adAddressLabel);
	
		adAddressTF = new JTextField();
		adAddressTF.setBounds(220,350,100,30);
		panel.add(adAddressTF);
		
	    adDepLab=new JLabel("Department");
		adDepLab.setBounds(100,400,100,30);
		panel.add(adDepLab);
		
		adDepTF=new JTextField();
		adDepTF.setBounds(220,400,100,30);
		panel.add(adDepTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,450,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,450,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,450,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,450,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,450,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,410,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
	
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(800,20, 80, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!adIdTF.getText().equals("") || !adIdTF.getText().equals(null))
			{
				HospitalStaff hs = hr.searchHospitalStaff(adIdTF.getText());
				if(hs!= null)
				{  
					adNameTF.setText(hs.getName());
					adDesignationTF.setText(hs.getDesignation());
					adSalaryTF.setText(hs.getSalary()+"");
					adPhoneTF.setText(hs.getPhoneNumber()+"");
					adAddressTF.setText(hs.getAddress());
					adDepTF.setText(hs.getDepartment());
					
					
					adIdTF.setEnabled(false);
					adNameTF.setEnabled(true);
					adDesignationTF.setEnabled(true);
					adSalaryTF.setEnabled(true);
					adAddressTF.setEnabled(true);
					adPhoneTF.setEnabled(true);
					adDepTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			HospitalStaff hs = new HospitalStaff();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			hs.setId(adIdTF.getText());
			hs.setName(adNameTF.getText());
			hs.setDesignation(adDesignationTF.getText());
			hs.setSalary(Double.parseDouble(adSalaryTF.getText()));
			hs.setAddress(adAddressTF.getText());
			hs.setDepartment(adDepTF.getText());
			hs.setPhoneNumber(Integer.parseInt(adPhoneTF.getText()));
			
			u.setUserId(adIdTF.getText());
			u.setDepartment(adDepTF.getText());
			u.setPassword(x+"");
			
			if(((adDesignationTF.getText()).equals("Admin")) || ((adDesignationTF.getText()).equals("admin")))
			{
				u.setStatus(0);
			}
			else if(((adDesignationTF.getText()).equals("Doctor")) || ((adDesignationTF.getText()).equals("doctor")))
			{
				u.setStatus(1);
			
			}
			else
			{
				u.setStatus(2);
			}
			
			hr.insertInDB(hs);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+adIdTF.getText()+"and Password: "+x);
			
			adIdTF.setText("");
			adNameTF.setText("");
			adDesignationTF.setText("");
			adSalaryTF.setText("");
			adPhoneTF.setText("");
			adAddressTF.setText("");
			adDepTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			adIdTF.setText("");
			adNameTF.setText("");
			adDesignationTF.setText("");
			adSalaryTF.setText("");
			adPhoneTF.setText("");
			adAddressTF.setText("");
			adDepTF.setText("");
			
			adIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			HospitalStaff hs = new HospitalStaff();
			
			hs.setId(adIdTF.getText());
			hs.setName(adNameTF.getText());
			hs.setDesignation(adDesignationTF.getText());
			hs.setSalary(Double.parseDouble(adSalaryTF.getText()));
			hs.setAddress(adAddressTF.getText());
			hs.setDepartment(adDepTF.getText());
			hs.setPhoneNumber(Integer.parseInt(adPhoneTF.getText()));
			
			hr.updateInDB(hs);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			adIdTF.setText("");
			adNameTF.setText("");
			adDesignationTF.setText("");
			adSalaryTF.setText("");
			adPhoneTF.setText("");
			adAddressTF.setText("");
			adDepTF.setText("");

			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			adIdTF.setEnabled(true);
			adNameTF.setEnabled(true);
			adDesignationTF.setEnabled(true);
			adSalaryTF.setEnabled(true);
			adPhoneTF.setEnabled(true);
			adAddressTF.setEnabled(true);
			adDepTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			hr.deleteFromDB(adIdTF.getText());
			ur.deleteUser(adIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			adIdTF.setText("");
			adNameTF.setText("");
			adDesignationTF.setText("");
			adSalaryTF.setText("");
			adPhoneTF.setText("");
			adAddressTF.setText("");
			adDepTF.setText("");
			
			adIdTF.setEnabled(true);
			adNameTF.setEnabled(true);
			adDesignationTF.setEnabled(true);
			adSalaryTF.setEnabled(true);
			adPhoneTF.setEnabled(true);
			adAddressTF.setEnabled(true);
			adDepTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = hr.getAllHospitalStaff();
			String head[] = {"StaffId", "Name", "Designation", "Salary","Phone","Address","Department"};
			
			panel.remove(adTableSP);
			
			adTable = new JTable(data,head);
			adTable.setEnabled(false);
			adTableSP = new JScrollPane(adTable);
			adTableSP.setBounds(350, 100, 520, 275);
			panel.add(adTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(logoutBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}