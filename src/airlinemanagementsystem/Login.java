package airlinemanagementsystem;

import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JButton submit,reset,close;
	JTextField usernameVal;
	JPasswordField passwordVal;
	public Login() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel username=new JLabel("Username");
		username.setBounds(20,20,100,20);
		add(username);
		usernameVal=new JTextField();
		usernameVal.setBounds(130,20,200,20);
		add(usernameVal);
		
		JLabel password=new JLabel("Password");
		password.setBounds(20,60,100,20);
		add(password);
		passwordVal=new JPasswordField();
		passwordVal.setBounds(130,60,200,20);
		add(passwordVal);
		
		reset=new JButton("Reset");
		reset.setBounds(40,120,120,20);
		reset.addActionListener(this);
		add(reset);
		
		submit=new JButton("Submit");
		submit.setBounds(190,120,120,20);
		submit.addActionListener(this);
		add(submit);
		
		close=new JButton("Close");
		close.setBounds(120,160,120,20);
		close.addActionListener(this);
		add(close);
		
		setSize(400,300);
		setLocation(600,250);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit) {
			String uname=usernameVal.getText();
			String pass=passwordVal.getText();
			
			try {
				Conn conn=new Conn();
				
				Connection con=conn.CreateConn();
				Statement stmt=con.createStatement();
				
				String query="Select * from login where username='"+uname+"' and password='"+pass+"'";
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next()) {
					new Home();
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Username of Password");
				}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else if(e.getSource()==close) {
			setVisible(false);
		}else if(e.getSource()==reset) {
			usernameVal.setText("");
			passwordVal.setText("");
		}
		
	}
	public static void main(String[] args) {
		new Login();

	}



}
