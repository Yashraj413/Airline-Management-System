package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class CancelFlight extends JFrame implements ActionListener{
	JLabel genderVal,flightCodeVal,CancellationVal,nameVal,name,heading,Cancellation;
	JLabel pnrNumber,flightCode,gender,source,destination,flightName;
	JLabel flightNameVal,date,dateVal;
	JTextField pnrNumberVal;
	JComboBox sourceVal,destinationVal;
	JButton fetchBtn,cancel;
	JDateChooser dateChooser;
	
	public CancelFlight() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		heading=new JLabel("Cancel FLIGHT");
		heading.setBounds(180,20,250,35);
		heading.setFont(new Font("Tahoma",Font.PLAIN,32));
		heading.setForeground(Color.BLUE);
		add(heading);
		
		ImageIcon img=new ImageIcon(CancelFlight.class.getResource("icons/cancel.jpg"));
		Image imgMain=img.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon img1=new ImageIcon(imgMain);
		JLabel image=new JLabel(img1);
		image.setBounds(550,100,250,250);
		add(image);
				
		pnrNumber=new JLabel("PNR Number");
		pnrNumber.setBounds(60,80,200,20);
		pnrNumber.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(pnrNumber);
		pnrNumberVal=new JTextField();
		pnrNumberVal.setBounds(220,80,150,25);
		add(pnrNumberVal);
		
		fetchBtn=new JButton("Fetch Details");
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

		Random random=new Random();
		Cancellation=new JLabel("Cancellation No");
		Cancellation.setBounds(60,160,200,20);
		Cancellation.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(Cancellation);
		CancellationVal=new JLabel(""+random.nextInt(1000000));
		CancellationVal.setBounds(220,160,150,25);
		add(CancellationVal);
		
		
		flightCode=new JLabel("Flight Code");
		flightCode.setBounds(60,200,200,20);
		flightCode.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(flightCode);
		flightCodeVal=new JLabel();
		flightCodeVal.setBounds(220,200,150,25);
		add(flightCodeVal);
		
		date=new JLabel("Date");
		date.setBounds(60,240,200,20);
		date.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(date);
		
		dateVal=new JLabel();
		dateVal.setBounds(220,240,150,25);
		add(dateVal);
		
		
		
//		dateChooser=new JDateChooser();
//		dateChooser.setBounds(220,440,150,25);
//		add(dateChooser);
		
		cancel=new JButton("Cancel Flight");
		cancel.setBorderPainted(false);
		cancel.setOpaque(true);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(220,300,150,30);
		cancel.addActionListener(this);
		add(cancel);
		
//		ImageIcon im1g=new ImageIcon((CancelFlight.class.getResource("icons/details.jpg")));
//		Image img2=img.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
//		ImageIcon img3=new ImageIcon(img2);
//		JLabel imageLb=new JLabel(img3);
//		imageLb.setBounds(550,80,500,410);
//		add(imageLb);
		
		setSize(900,500);
		setLocation(350,150);
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
//					CancellationVal.setText(rs.getString("Cancellation"));
					flightCodeVal.setText(rs.getString("flightCode"));
//					genderVal.setText(rs.getString("gender"));
					Date d=new Date();
					SimpleDateFormat fmt=new SimpleDateFormat("dd-MM-yyyy");
					dateVal.setText(fmt.format(d));
				}else {
					JOptionPane.showMessageDialog(null, "Please enter check PNR number");
				}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else if(e.getSource()==cancel){
			try {
				Conn conn=new Conn();
				Connection con=conn.CreateConn();
				Statement stmt=con.createStatement();
				int rows=stmt.executeUpdate("Delete from reservation where PNR='"+pnrNumberVal.getText()+"';");
				
				if(rows>0) {
					JOptionPane.showMessageDialog(null, "Flight Cancelled Succefully");
				}else {
					JOptionPane.showMessageDialog(null, "No flight found");
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	public static void main(String []args) {
		new CancelFlight();
	}

}
