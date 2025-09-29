package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Home extends JFrame implements ActionListener{
	
	public Home() {
		setLayout(null);
		
		ImageIcon img=new ImageIcon(Home.class.getResource("icons/front.jpg"));
		JLabel bg=new JLabel(img);
		bg.setBounds(0,0,1920,1080);
		add(bg);
		
		//Heading
		
		JLabel heading=new JLabel("AIR INDIA WELCOMES YOU!");
		heading.setBounds(700,20,1000,80);
		heading.setForeground(Color.BLUE);
		heading.setFont(new Font("Tahoma",Font.PLAIN,36));
		bg.add(heading);
		
		
		// Menubar
		
		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		
		// Menu Details
		JMenu details=new JMenu("Details");
		JMenuItem flightDetails=new JMenuItem("Flight Details");
		flightDetails.addActionListener(this);
		details.add(flightDetails);
		JMenuItem customerDetails=new JMenuItem("Add Customer Details");
		customerDetails.addActionListener(this);
		details.add(customerDetails);
		JMenuItem bookFlight=new JMenuItem("Book Flight");
		bookFlight.addActionListener(this);
		details.add(bookFlight);
		JMenuItem journeyDetails=new JMenuItem("Journey Details");
		journeyDetails.addActionListener(this);
		details.add(journeyDetails);
		JMenuItem ticketCancellation=new JMenuItem("Cancel Tickets");
		ticketCancellation.addActionListener(this);
		details.add(ticketCancellation);
		
		JMenu ticket=new JMenu("Ticket");
		JMenuItem boardingPass=new JMenuItem("Boarding Pass");
		boardingPass.addActionListener(this);
		ticket.add(boardingPass);
		
		
		menuBar.add(details);
		menuBar.add(ticket);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String text=e.getActionCommand();
		if(text.equals("Flight Details")) {
			new FlightInfo();
		}else if(text.equals("Add Customer Details")) {
			new AddCustomer();
		}else if(text.equals("Book Flight")) {
			new BookFlight();
		}else if(text.equals("Journey Details")) {
			new JourneyDetails();
		}else if(text.equals("Cancel Tickets")) {
			new CancelFlight();
		}else if(text.equals("Boarding Pass")) {
			new BoardingPass();
		}
		
	}
	public static void main(String[] args) {
		new Home();

	}

}
