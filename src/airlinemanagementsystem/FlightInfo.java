package airlinemanagementsystem;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FlightInfo extends JFrame{

	public FlightInfo() {

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JTable table=new JTable();
		
		try {
			Conn conn=new Conn();
			Connection con=conn.CreateConn();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from flight");
			
//			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			List<List<String>> list=new ArrayList<>();
			while(rs.next()) {
				List<String> temp=new ArrayList<>();
				for(int i=1;i<=4;i++)temp.add(rs.getString(i));
				list.add(temp);
			}
			int len=list.size();
			String data[][]=new String[len][4];
			for(int i=0;i<len;i++) {
				for(int j=0;j<4;j++)data[i][j]=list.get(i).get(j);
			}
			
			String[] headings= {"Flight Code","Flight Name","Source","Destination"};
		
			DefaultTableModel model=new DefaultTableModel(data,headings);
			table.setModel(model);
			table.setBounds(0,0,800,500);
			add(table);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(0,0,800,500);
		add(jsp);
		
		setSize(800,500);
		setLocation(400,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new FlightInfo();

	}

}
