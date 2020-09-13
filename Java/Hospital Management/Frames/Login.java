package Frames;
import Entity.*;
import Repository.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener
{
	private JLabel nameLabel, passLabel,loginLabel1;
	private JTextField nameTF,userTF;
	private JPasswordField passPF;
	private JButton loginBtn, exitBtn;
	private JRadioButton doctor, admin, receptionist;
	private ButtonGroup bg;
	private JPanel panel;
	private Color backColor;
	private Font myFont1,myFont2;
	private HospitalStaffRepo hr;
	
	
	
	public Login()
	{
		super("Login to Your Account");
		this.setSize(920,620);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		backColor = new Color(140, 240, 130);
		myFont1 = new Font("Copperplate Gothic Bold", Font.PLAIN, 20);
		myFont2=new Font ("Impact",Font.PLAIN,30);
		
		
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(backColor);
		
		nameLabel = new JLabel("Hospital Managment System");
		nameLabel.setBounds(20,20,400,50);
		nameLabel.setFont(myFont2);
		panel.add(nameLabel);
		
		
		loginLabel1 = new JLabel("User Name:");
		loginLabel1.setBounds(280,220,120,30);
		panel.add(loginLabel1);
		
		nameTF = new JTextField();
		nameTF.setBounds(350, 220, 115,30);
		panel.add(nameTF);
		
		passLabel = new JLabel("Password:");
		passLabel.setBounds(280,270, 100, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(350,270, 115, 30);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(280, 330, 80, 30);
	    loginBtn.addActionListener(this);  
		panel.add(loginBtn);
		
		/*doctor = new JRadioButton("Admin");
		doctor.setBounds(490,210, 80, 30);
		doctor.setOpaque(false);
		panel.add(doctor);
		
		admin = new JRadioButton("Doctor");
		admin.setBounds(490, 255, 100, 30);
		admin.setOpaque(false);
		panel.add(admin);
		
		receptionist = new JRadioButton("Receptionist");
		receptionist.setBounds(490, 300, 100, 30);
		receptionist.setOpaque(false);
		panel.add(receptionist);
		
		
		bg = new ButtonGroup();
		bg.add(doctor);
		bg.add(admin);
		bg.add(receptionist);
		*/
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(385, 330, 80, 30);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
	
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			

			UserRepo ur = new UserRepo();
			User user = ur.getUser(nameTF.getText(), passPF.getText());
			
			if(user != null)
			{
			
				if(user.getStatus() == 0)
				{
				    AdminPortal ap= new AdminPortal(user);
					ap.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getStatus() == 1)
				{


					if ((user.getDepartment()).equals("medicine"))
					{
						DoctorPortal dp = new DoctorPortal(user);
						dp.setVisible(true);
						this.setVisible(false);
					}
					
					else if ((user.getDepartment()).equals("eye") )
					{
						
						DoctorPortal1 dp = new DoctorPortal1(user);
						dp.setVisible(true);
						this.setVisible(false);
			

					}
					
					else if ((user.getDepartment()).equals("skin") )
					{
					DoctorPortal2 dp = new DoctorPortal2(user);
					dp.setVisible(true);
					this.setVisible(false);
					}
					
					else if ((user.getDepartment()).equals("psychology") )
					{
					DoctorPortal3 dp = new DoctorPortal3(user);
					dp.setVisible(true);
					this.setVisible(false);
					}
					
					else{}
					
					
				}
				else if(user.getStatus() == 2)
				{
					ReceptionistPortal rp=new ReceptionistPortal(user);
					rp.setVisible(true);
					this.setVisible(false);
				}
				else{}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
			
		}
		else if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		/*else if(command.equals(regBtn.getText()))
		{
			RegistrationFrame rf = new RegistrationFrame(this);
			rf.setVisible(true);
			this.setVisible(false);
		}*/
		else{}
	}
		
}