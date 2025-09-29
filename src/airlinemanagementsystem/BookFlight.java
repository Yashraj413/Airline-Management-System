package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
	JLabel genderVal,addressVal,nationalityVal,nameVal,name,heading,nationality;
	JLabel aadharNumber,address,gender,source,destination,flightName,flightCode;
	JLabel flightNameVal,flightCodeVal,date;
	JTextField aadharNumberVal;
	JComboBox sourceVal,destinationVal;
	JButton fetchBtn,fetchFlightBtn;
	JDateChooser dateChooser;
	
	public BookFlight() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		heading=new JLabel("BOOK FLIGHT");
		heading.setBounds(420,20,500,35);
		heading.setFont(new Font("Tahoma",Font.PLAIN,32));
		heading.setForeground(Color.BLUE);
		add(heading);
		
		aadharNumber=new JLabel("Aadhar Number");
		aadharNumber.setBounds(60,80,200,20);
		aadharNumber.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(aadharNumber);
		aadharNumberVal=new JTextField();
		aadharNumberVal.setBounds(220,80,150,25);
		add(aadharNumberVal);
		
		fetchBtn=new JButton("Fetch User");
		fetchBtn.setBorderPainted(false);
		fetchBtn.setOpaque(true);
		fetchBtn.setBackground(Color.BLACK);
		fetchBtn.setForeground(Color.WHITE);
		fetchBtn.setBounds(380,80,130,25);
		fetchBtn.addActionListener(this);
		add(fetchBtn);
		
		name=new JLabel("Name");
		name.setBounds(60,120,150,25);
		name.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(name);
		nameVal=new JLabel();
		nameVal.setBounds(220,120,150,25);
		add(nameVal);
		
		nationality=new JLabel("Nationality");
		nationality.setBounds(60,160,200,20);
		nationality.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(nationality);
		nationalityVal=new JLabel();
		nationalityVal.setBounds(220,160,150,25);
		add(nationalityVal);
		
		
		address=new JLabel("Address");
		address.setBounds(60,200,200,20);
		address.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(address);
		addressVal=new JLabel();
		addressVal.setBounds(220,200,150,25);
		add(addressVal);
		
		gender=new JLabel("Gender");
		gender.setBounds(60,240,200,20);
		gender.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(gender);
		
		genderVal=new JLabel();
		genderVal.setBounds(220,240,150,25);
		add(genderVal);

		List<String> tempDest=new ArrayList<>();
		List<String> tempSource=new ArrayList<>();
		
		try {
			Conn conn=new Conn();
			Connection con=conn.CreateConn();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from flight");
			
			while(rs.next()) {
				tempDest.add(rs.getString(4));
				tempSource.add(rs.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String SourceCities[]=new String[tempSource.size()];
		String DestinationCities[]=new String[tempDest.size()];
		for(int i=0;i<tempDest.size();i++) {
			SourceCities[i]=tempSource.get(i);
			DestinationCities[i]=tempDest.get(i);
		}
		
		source=new JLabel("Source");
		source.setBounds(60,280,200,20);
		source.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(source);
	
		sourceVal=new JComboBox(SourceCities);
		sourceVal.setBounds(220,280,150,25);
		add(sourceVal);
		
		destination=new JLabel("Destination");
		destination.setBounds(60,320,200,20);
		destination.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(destination);
		destinationVal=new JComboBox(DestinationCities);
		destinationVal.setBounds(220,320,150,25);
		add(destinationVal);
		
		fetchFlightBtn=new JButton("Fetch Flights");
		fetchFlightBtn.setBorderPainted(false);
		fetchFlightBtn.setOpaque(true);
		fetchFlightBtn.setBackground(Color.BLACK);
		fetchFlightBtn.setForeground(Color.WHITE);
		fetchFlightBtn.setBounds(380,320,130,25);
		fetchFlightBtn.addActionListener(this);
		add(fetchFlightBtn);
		
//		try {
//			Conn conn=new Conn();
//			Connection con=conn.CreateConn();
//			Statement stmt=con.createStatement();
//			int rows=stmt.executeUpdate("insert into");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		flightName=new JLabel("Flight Name");
		flightName.setBounds(60,360,200,20);
		flightName.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(flightName);
		flightNameVal=new JLabel();
		flightNameVal.setBounds(220,360,150,25);
		add(flightNameVal);
		
		flightCode=new JLabel("Flight Code");
		flightCode.setBounds(60,400,200,20);
		flightCode.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(flightCode);
		flightCodeVal=new JLabel();
		flightCodeVal.setBounds(220,400,150,25);
		add(flightCodeVal);
		
		date=new JLabel("Date of Travel");
		date.setBounds(60,440,200,20);
		date.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(date);
		
		dateChooser=new JDateChooser();
		dateChooser.setBounds(220,440,150,25);
		add(dateChooser);
		
		JButton save=new JButton("Book Flight");
		save.setBorderPainted(false);
		save.setOpaque(true);
		save.setBackground(Color.BLACK);
		save.setForeground(Color.WHITE);
		save.setBounds(220,500,150,30);
		save.addActionListener(this);
		add(save);
		
		ImageIcon img=new ImageIcon((BookFlight.class.getResource("icons/details.jpg")));
		Image img2=img.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
		ImageIcon img3=new ImageIcon(img2);
		JLabel imageLb=new JLabel(img3);
		imageLb.setBounds(550,80,500,410);
		add(imageLb);
		
		setSize(1100,700);
		setLocation(300,150);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==fetchBtn) {
			String aadhar=aadharNumberVal.getText();
			
			try {
				Conn conn=new Conn();
				Connection con=conn.CreateConn();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("Select * from passenger where aadhar='"+aadhar+"';");
				
				if(rs.next()) {
					nameVal.setText(rs.getString("name"));
					nationalityVal.setText(rs.getString("nationality"));
					addressVal.setText(rs.getString("address"));
					genderVal.setText(rs.getString("gender"));
				}else {
					JOptionPane.showMessageDialog(null, "Please enter correct aadhar number");
				}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else if(e.getSource()==fetchFlightBtn){
			String src=(String)sourceVal.getSelectedItem();
			String des=(String)destinationVal.getSelectedItem();
			try {
				Conn conn=new Conn();
				Connection con=conn.CreateConn();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("Select * from flight where source='"+src+"' and destination='"+des+"';");
				
				if(rs.next()) {
					flightNameVal.setText(rs.getString("f_name"));
					flightCodeVal.setText(rs.getString("f_code"));
				}else {
					JOptionPane.showMessageDialog(null, "No flight found");
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else {
			String aadhar=aadharNumberVal.getText();
			String name=nameVal.getText();
			String nationality=nationalityVal.getText();
			String flightName=flightNameVal.getText();
			String flightCode=flightCodeVal.getText();
			String src=(String)sourceVal.getSelectedItem();
			String des=(String)destinationVal.getSelectedItem();
			String date=((JTextField)(dateChooser.getDateEditor().getUiComponent())).getText();
			
			Random random=new Random();
			try {
				Conn conn=new Conn();
				Connection con=conn.CreateConn();
				Statement stmt=con.createStatement();
				int booked=stmt.executeUpdate("insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"','"+aadhar+"','"+name+"','"+nationality+"','"+flightName+"','"+flightCode+"','"+src+"','"+des+"','"+date+"');");
			
				if(booked>0) {
					JOptionPane.showMessageDialog(null, "Ticket booked successfully");
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Booking Failed");
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		

		
	}
	public static void main(String []args) {
		new BookFlight();
	}

}
