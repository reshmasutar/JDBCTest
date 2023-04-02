package jdbctest;

import java.util.ArrayList;
import java.util.Scanner;


import java.sql.*;

public class Question1 {
	
	static Connection con = null;
	
	
	static{
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter choice: \n1:INSERT RECORD \n2:DISPLAY RECORD:");
		int choice = sc.nextInt();
		
		if(choice==1){
			insertRecord();			
		}else if(choice==2){
			display();
		}else{
			System.out.println("invalid choice");
		}

	}
	
	public static void insertRecord(){
		PreparedStatement pstmt = null;
		String query="insert into demo_info(user,pass,age,contact,city) values(?,?,?,?,?)";
		int count=0;
	
		System.out.println("Enter Username: ");
		String user= sc.next();
		System.out.println("Enter Password: ");
		String pass= sc.next();
		System.out.println("Enter Age: ");
		int age= sc.nextInt();
		System.out.println("Enter Contact: ");
		Long cont = sc.nextLong();
		System.out.println("Enter City: ");
		String city= sc.next();
		
		try {
			pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, user);
		pstmt.setString(2, pass);
		pstmt.setInt(3, age);
		pstmt.setLong(4, cont);
		pstmt.setString(5, city);
		count = pstmt.executeUpdate();
		System.out.println("RECORED INSERTED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public static void display(){
	Statement stmt = null;
	ResultSet rs = null;
	
	String query = "select * from demo_info";
	
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
	
	stmt = con.createStatement();
	rs = stmt.executeQuery(query);
	System.out.println("SRN\t\tUSERNAME\t\tPASSWORD\t\tAGE\t\tCONTACT\t\tCITY");
	System.out.println("===========================================================================================================================");
	while(rs.next()){
		int srn=rs.getInt(1);
		String user = rs.getString(2);
		String pass = rs.getString(3);
		int age = rs.getInt(4);
		long cont = rs.getLong(5) ;
		String city = rs.getString(6);
		
		System.out.println(srn+"\t\t"+user+"\t\t"+pass+"\t\t"+age+"\t\t"+cont+"\t\t"+city);
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

}
