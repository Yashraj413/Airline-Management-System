package airlinemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class JourneyDetails extends JFrame implements ActionListener{

	JTable table;
	JTextField pnrVal;
	JButton show;
	public JourneyDetails() {

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel pnr=new JLabel("PNR Details");
		pnr.setFont(new Font("Tahoma",Font.PLAIN,16));
		pnr.setBounds(50,50,100,25);
		add(pnr);
		
		pnrVal=new JTextField();
		pnrVal.setBounds(160,50,120,25);
		add(pnrVal);
		
		show=new JButton("Show Details");
		show.setBackground(Color.BLACK);
		show.setForeground(getForeground());
		show.setBounds(290,50,120,25);
		show.addActionListener(this);
		add(show);
		
		table=new JTable();
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(0,100,800,150);
		jsp.setBackground(Color.WHITE);
		add(jsp);
		
		setSize(800,500);
		setLocation(400,150);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Conn conn=new Conn();
			Connection con=conn.CreateConn();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from reservation where PNR='"+pnrVal.getText()+"';");
			
			if(!rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "No Information found");
				return;
			}else {
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			
//			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new JourneyDetails();

	}


}
