package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener{
	JLabel genderVal,sourceVal,nationalityVal,nameVal,name,heading,nationality,subHeading;
	JLabel pnrNumber,source,gender,destination,flightName,flightCode;
	JLabel flightNameVal,flightCodeVal,date,destinationVal,dateVal;
	JTextField pnrNumberVal;
//	JComboBox ,destinationVal;
	JButton fetchBtn,fetchFlightBtn;
	JDateChooser dateChooser;
	
	public BoardingPass() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		heading=new JLabel("AIR INDIA");
		heading.setBounds(380,10,450,35);
		heading.setFont(new Font("Tahoma",Font.PLAIN,32));
//		heading.setForeground(Color.BLUE);
		add(heading);
		
		subHeading=new JLabel("Boarding Pass");
		subHeading.setBounds(360,50,300,30);
		subHeading.setFont(new Font("Tahoma",Font.PLAIN,24));
		subHeading.setForeground(Color.BLUE);
		add(subHeading);
		
		pnrNumber=new JLabel("PNR Number");
		pnrNumber.setBounds(60,100,200,20);
		pnrNumber.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(pnrNumber);
		pnrNumberVal=new JTextField();
		pnrNumberVal.setBounds(220,100,150,25);
		add(pnrNumberVal);
		
		fetchBtn=new JButton("Enter");
		fetchBtn.setBorderPainted(false);
		fetchBtn.setOpaque(true);
		fetchBtn.setBackground(Color.BLACK);
		fetchBtn.setForeground(Color.WHITE);
		fetchBtn.setBounds(380,100,130,25);
		fetchBtn.addActionListener(this);
		add(fetchBtn);
		
		name=new JLabel("Name");
		name.setBounds(60,140,150,25);
		name.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(name);
		nameVal=new JLabel();
		nameVal.setBounds(220,140,150,25);
		add(nameVal);
		
		nationality=new JLabel("Nationality");
		nationality.setBounds(60,180,200,20);
		nationality.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(nationality);
		nationalityVal=new JLabel();
		nationalityVal.setBounds(220,180,150,25);
		add(nationalityVal);
		
		
		source=new JLabel("Source");
		source.setBounds(60,220,200,20);
		source.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(source);
		sourceVal=new JLabel();
		sourceVal.setBounds(220,220,150,25);
		add(sourceVal);
		
		destination=new JLabel("Destination");
		destination.setBounds(340,220,200,20);
		destination.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(destination);
		destinationVal=new JLabel();
		destinationVal.setBounds(480,220,150,25);
		add(destinationVal);
		
		flightName=new JLabel("Flight Name");
		flightName.setBounds(60,260,200,20);
		flightName.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(flightName);
		flightNameVal=new JLabel();
		flightNameVal.setBounds(220,260,150,25);
		add(flightNameVal);
		
		flightCode=new JLabel("Flight Code");
		flightCode.setBounds(340,260,200,25);
		flightCode.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(flightCode);
		flightCodeVal=new JLabel();
		flightCodeVal.setBounds(480,260,150,20);
		add(flightCodeVal);
		
		date=new JLabel("Date");
		date.setBounds(60,300,200,25);
		date.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(date);
		dateVal=new JLabel();
		dateVal.setBounds(218,303,150,20);
		add(dateVal);


		ImageIcon img=new ImageIcon(BoardingPass.class.getResource("icons/airindia.png"));
		Image imgMain=img.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
		ImageIcon img1=new ImageIcon(imgMain);
		JLabel image=new JLabel(img1);
		image.setBounds(600,100,400,250);
		add(image);
		
		setSize(1100,500);
		setLocation(300,150);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==fetchBtn) {
			String aadhar=pnrNumberVal.getText();
			
			try {
				Conn conn=new Conn();
				Connection con=conn.CreateConn();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("Select * from reservation where PNR='"+pnrNumberVal.getText()+"';");
				
				if(rs.next()) {
					nameVal.setText(rs.getString("name"));
					nationalityVal.setText(rs.getString("nationality"));
					sourceVal.setText(rs.getString("src"));
					destinationVal.setText(rs.getString("des"));
					flightNameVal.setText(rs.getString("flightName"));
					flightCodeVal.setText(rs.getString("flightCode"));
					
//					Date d=new Date();
//					SimpleDateFormat fmt=new SimpleDateFormat("dd-MMM-yyy");
					dateVal.setText(rs.getString("ddate"));
				}else {
					JOptionPane.showMessageDialog(null, "Please enter correct PNR number");
				}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		

		
	}
	public static void main(String []args) {
		new BoardingPass();
	}

}
