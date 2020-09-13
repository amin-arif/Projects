package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Repository.*;
import Entity.*;

public class AppointmentFrame extends JFrame implements ActionListener
{
	private JLabel appLabel,appLabel1,doclab;
	private JTextField dateTF,docTF;
	private JButton backBtn,nextBtn;
	private JComboBox combo;
	private JPanel panel;
	private Color backColor;
	private Font myFont1,myFont2;
	private String id;
	private AppointmentRepo ar;
	private User user;
	
	public AppointmentFrame(String id)
	{
	
		super("Appointment Frame");
		this.setSize(920,620);

		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backColor = new Color(140, 240, 130);
		myFont2=new Font ("Impact",Font.PLAIN,30);
		this.id=id;
		this.user=user;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(backColor);
		ar=new AppointmentRepo();
		
		appLabel=new JLabel("Select Department:");
		appLabel.setBounds(100,100,100,35);
		panel.add(appLabel);
		
		appLabel1=new JLabel("Type Date:");
		appLabel1.setBounds(100,155,100,35);
		panel.add(appLabel1);
		
		
		
		String items[] = {"medicine", "eye","skin","psychology"};
		
		combo = new JComboBox(items);
		combo.setBounds(250, 100, 100, 35);
		panel.add(combo);
		
		dateTF=new JTextField();
		dateTF.setBounds(250,155,100,35);
		panel.add(dateTF);
		
		doclab=new JLabel("Type Doctor Name:");
		doclab.setBounds(100,210,100,35);
		panel.add(doclab);
		
		docTF=new JTextField();
		docTF.setBounds(250,210,100,35);
		panel.add(docTF);
		
		nextBtn=new JButton("Next");
		nextBtn.setBounds(350,300,100,55);
		nextBtn.addActionListener(this);
		panel.add(nextBtn);
		
		backBtn=new JButton("Back");
		backBtn.setBounds(200,300,100,55);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		this.add(panel);
	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if (command.equals(nextBtn.getText()))
		{
			/*String name = nameTF.getText();
			String pass = passPF.getText();
			
			String radioText = null;
			String checkText = null;
			
			
			if(r1.isSelected()){radioText = r1.getText();}
			else if(r2.isSelected()){radioText = r2.getText();}
			else if(r3.isSelected()){radioText = r3.getText();}
			else{}
			
			if(c1.isSelected()){checkText = c1.getText();}
			else if(c2.isSelected()){checkText = c2.getText();}
			else if(c3.isSelected()){checkText = c3.getText();}
			else{}*/
			
			String comboText = combo.getSelectedItem().toString();
			String date=dateTF.getText();
			String name=docTF.getText();
			Patient p=ar.searchPatient(id);
			ar.insertInDB(p,date,comboText,name);
			
			JOptionPane.showMessageDialog(this,"Patient is appointed");
			dateTF.setText("");
			docTF.setText("");
			

			
			
		}
		
		else if(command.equals(backBtn.getText()))
		{
			ReceptionistPortal rp=new ReceptionistPortal(user);
			rp.setVisible(true);
			this.setVisible(false);
			
			
		}
		else{}
		
	}

	
	
}