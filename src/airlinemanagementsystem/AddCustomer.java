package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
public class AddCustomer extends JFrame implements ActionListener{
	JLabel name,heading,nationality,aadharNumber,address,gender,phone;
	JTextField nameVal,nationalityVal,aadharNumberVal,addressVal,genderVal,phoneVal;
	JRadioButton male,female;
	public AddCustomer() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		heading=new JLabel("ADD CUSTOMER DETAILS");
		heading.setBounds(220,20,500,35);
		heading.setFont(new Font("Tahoma",Font.PLAIN,32));
		heading.setForeground(Color.BLUE);
		add(heading);
		
		name=new JLabel("Name");
		name.setBounds(60,80,150,25);
		name.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(name);
		nameVal=new JTextField();
		nameVal.setBounds(220,80,150,25);
		add(nameVal);
		
		nationality=new JLabel("Nationality");
		nationality.setBounds(60,120,200,20);
		nationality.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(nationality);
		nationalityVal=new JTextField();
		nationalityVal.setBounds(220,120,150,25);
		add(nationalityVal);
		
		
		aadharNumber=new JLabel("Aadhar Number");
		aadharNumber.setBounds(60,160,200,20);
		aadharNumber.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(aadharNumber);
		aadharNumberVal=new JTextField();
		aadharNumberVal.setBounds(220,160,150,25);
		add(aadharNumberVal);
		
		address=new JLabel("Address");
		address.setBounds(60,200,200,20);
		address.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(address);
		addressVal=new JTextField();
		addressVal.setBounds(220,200,150,25);
		add(addressVal);
		
		gender=new JLabel("Gender");
		gender.setBounds(60,240,200,20);
		gender.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(220,240,70,25);
		female=new JRadioButton("Female");
		female.setBounds(290,240,70,25);
		add(male);add(female);
		
		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		phone=new JLabel("Phone");
		phone.setBounds(60,280,200,20);
		phone.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(phone);
		phoneVal=new JTextField();
		phoneVal.setBounds(220,280,150,25);
		add(phoneVal);
		
		JButton save=new JButton("SAVE");
		save.setBorderPainted(false);
		save.setOpaque(true);
		save.setBackground(Color.BLACK);
		save.setForeground(Color.WHITE);
		save.setBounds(220,380,150,30);
		save.addActionListener(this);
		add(save);
		
		ImageIcon img=new ImageIcon((AddCustomer.class.getResource("icons/emp.png")));
		JLabel imageLb=new JLabel(img);
		imageLb.setBounds(450,80,280,400);
		add(imageLb);
		
		setSize(900,600);
		setLocation(300,150);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String name=nameVal.getText();
		String nationality=nationalityVal.getText();
		String phone=phoneVal.getText();
		String address=addressVal.getText();
		String aadhar=aadharNumberVal.getText();
		String gender=null;
		
		if(male.isSelected())gender="Male";
		else gender="Female";
		try {
			Conn conn=new Conn();
			Connection con=conn.CreateConn();
			Statement stmt=con.createStatement();
			String query="insert into passenger values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+aadhar+"','"+gender+"');";
			int inserted=stmt.executeUpdate(query);
			if(inserted>0) {
				nameVal.setText("");
				nationalityVal.setText("");
				phoneVal.setText("");
				addressVal.setText("");
				aadharNumberVal.setText("");
				male.setSelected(false);
				female.setSelected(false);
				JOptionPane.showMessageDialog(null, "Customer added successfully");
			}else {
				JOptionPane.showMessageDialog(null, "Customer could not be added");
			}
		}catch(Exception er) {
			er.printStackTrace();
		}
		
	}
	public static void main(String []args) {
		new AddCustomer();
	}

}
