package Frames;
import Repository.*;
import Entity.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;




public class ReceptionistPortal extends JFrame implements ActionListener
{
	private JLabel pIdLabel, pNameLabel, pAgeLabel, pGenderLabel,pDisLabel,pPhoneLabel,pAddressLabel;
	private JTextField pIdTF, pNameTF, pAgeTF, pGenderTF,pDisTF,pPhoneTF,pAddressTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn,logoutBtn, appBtn;
	private JPanel panel;
	private Color backColor;
	private JTable rTable;
	private JScrollPane rTableSP;
	
	
	
	private User user;
	private PatientRepo pr;
	private UserRepo ur;
	
	
	public ReceptionistPortal(User user)
	{
		super("Receptionist Frame");
		this.setSize(920,620);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backColor = new Color(140, 240, 130);
		
		this.user = user;
		pr = new PatientRepo();
		ur = new UserRepo();
		
		backColor = new Color(140, 240, 130);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(backColor);
		
		
		String data[][] = {{"", "", "", "","","",""}};
		
		String head[] = {"PId", "Name", "Address", "Disease","Gender","Age","Phone"};
		
		rTable = new JTable(data,head);
		rTableSP = new JScrollPane(rTable);
		rTableSP.setBounds(350, 100, 450, 150);
		rTable.setEnabled(false);
		panel.add(rTableSP);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(backColor);
		
		pIdLabel = new JLabel("ID :");
		pIdLabel.setBounds(100,100,100,30);
		panel.add(pIdLabel);
		
		pIdTF = new JTextField();
		pIdTF.setBounds(220,100,100,30);
		panel.add(pIdTF);
		
		pNameLabel = new JLabel("Name :");
		pNameLabel.setBounds(100,150,100,30);
		panel.add(pNameLabel);
		
		pNameTF  = new JTextField();
		pNameTF.setBounds(220,150,100,30);
		panel.add(pNameTF);
		
		pAgeLabel = new JLabel("Age: ");
		pAgeLabel.setBounds(100,200,100,30);
		panel.add(pAgeLabel);
		
		pAgeTF = new JTextField();
		pAgeTF.setBounds(220,200,100,30);
		panel.add(pAgeTF);
		
		pGenderLabel = new JLabel("Gender: ");
		pGenderLabel.setBounds(100,250,100,30);
		panel.add(pGenderLabel);
		
		pGenderTF = new JTextField();
		pGenderTF.setBounds(220,250,100,30);
		panel.add(pGenderTF);
		
		pDisLabel = new JLabel("Disease Name:");
		pDisLabel.setBounds(100,300,100,30);
		panel.add(pDisLabel);
		
		pDisTF  = new JTextField();
		pDisTF.setBounds(220,300,100,30);
		panel.add(pDisTF);
		
		pPhoneLabel = new JLabel("Phone: ");
		pPhoneLabel.setBounds(100,350,100,30);
		panel.add(pPhoneLabel);
		
		pPhoneTF = new JTextField();
		pPhoneTF.setBounds(220,350,100,30);
		panel.add(pPhoneTF);
		
		pAddressLabel = new JLabel("Address: ");
		pAddressLabel.setBounds(100,400,100,30);
		panel.add(pAddressLabel);
		
		pAddressTF = new JTextField();
		pAddressTF.setBounds(220,400,100,30);
		panel.add(pAddressTF);
		
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
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,450,80,30);
		deleteBtn.addActionListener(this);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,450,80,30);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(600,450,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(650,20,80,30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		appBtn = new JButton("Set Appointment");
		appBtn.setBounds(650, 500, 150, 40);
		appBtn.addActionListener(this);
		panel.add(appBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!pIdTF.getText().equals("") || !pIdTF.getText().equals(null))
			{
				Patient p = pr.searchPatient(pIdTF.getText());
				if(p!= null)
				{  
					pNameTF.setText(p.getName());
					pIdTF.setText(p.getId());
					pDisTF.setText(p.getDisease());
					pAgeTF.setText(p.getAge()+"");
					pPhoneTF.setText(p.getPhoneNumber()+"");
					pAddressTF.setText(p.getAddress());
					pGenderTF.setText(p.getGender());
					
					
					pIdTF.setEnabled(false);
					pNameTF.setEnabled(true);
					pDisTF.setEnabled(true);
					pAgeTF.setEnabled(true);
					pAddressTF.setEnabled(true);
					pPhoneTF.setEnabled(true);
					pGenderTF.setEnabled(true);
					
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
			Patient p = new Patient();
			/*User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;*/
			
			p.setId(pIdTF.getText());
			p.setName(pNameTF.getText());
			p.setDisease(pDisTF.getText());
			p.setAddress(pAddressTF.getText());
			p.setPhoneNumber(Integer.parseInt(pPhoneTF.getText()));
			p.setAge(Integer.parseInt(pAgeTF.getText()));
			p.setGender(pGenderTF.getText());
			
			/*u.setUserId(pIdTF.getText());
			u.setPassword(x+"");
			u.setStatus(2);*/
			
			
			pr.insertInDB(p);
			//ur.insertUser(u);
			
			//JOptionPane.showMessageDialog(this, "Inserted, Id: "+pIdTF.getText()+"and Password: "+x);
			
			pIdTF.setText("");
			pNameTF.setText("");
			pDisTF.setText("");
			pAgeTF.setText("");
			pPhoneTF.setText("");
			pAddressTF.setText("");
			pGenderTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			pIdTF.setText("");
			pNameTF.setText("");
			pDisTF.setText("");
			pAgeTF.setText("");
			pPhoneTF.setText("");
			pAddressTF.setText("");
			pGenderTF.setText("");
			
			pIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Patient p = new Patient();
			
			p.setId(pIdTF.getText());
			p.setName(pNameTF.getText());
			p.setDisease(pDisTF.getText());
			p.setAddress(pAddressTF.getText());
			p.setGender(pGenderTF.getText());
			p.setAge(Integer.parseInt(pAgeTF.getText()));
			p.setPhoneNumber(Integer.parseInt(pPhoneTF.getText()));
			
			pr.updateInDB(p);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			pIdTF.setText("");
			pNameTF.setText("");
			pDisTF.setText("");
			pAgeTF.setText("");
			pPhoneTF.setText("");
			pAddressTF.setText("");
			pGenderTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
	
			pIdTF.setEnabled(true);
			pNameTF.setEnabled(true);
			pDisTF.setEnabled(true);
			pAgeTF.setEnabled(true);
			pAddressTF.setEnabled(true);
			pPhoneTF.setEnabled(true);
			pGenderTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			pr.deleteFromDB(pIdTF.getText());
			ur.deleteUser(pIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			pIdTF.setText("");
			pNameTF.setText("");
			pDisTF.setText("");
			pAgeTF.setText("");
			pPhoneTF.setText("");
			pAddressTF.setText("");
			pGenderTF.setText("");
			
			pIdTF.setEnabled(true);
			pNameTF.setEnabled(true);
			pDisTF.setEnabled(true);
			pAgeTF.setEnabled(true);
			pAddressTF.setEnabled(true);
			pPhoneTF.setEnabled(true);
			pGenderTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = pr.getAllPatient();
			String head[] = {"PId", "Name", "Address", "Disease","Gender","Age","Phone"};
			
			panel.remove(rTableSP);
			
			rTable = new JTable(data,head);
			rTable.setEnabled(false);
			rTableSP = new JScrollPane(rTable);
			rTableSP.setBounds(350, 100, 450, 275);
			panel.add(rTableSP);
			
			panel.revalidate();
			panel.repaint();
			
			
			
		}
		else if (command.equals(appBtn.getText()))
		{  
			
			
			String id = pIdTF.getText();
			/*String age = pAgeTF.getText();
			String name = pNameTF.getText();
			String gender = pGenderTF.getText();
			String disease = pDisTF.getText();
			String phone = pPhoneTF.getText();
			String address = pAddressTF.getText();*/
			
			
			AppointmentFrame af=new AppointmentFrame(id);
			af.setVisible(true);
			this.setVisible(false);
			
			
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