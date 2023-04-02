package jdbctest;

import java.util.Scanner;
import java.sql.*;

public class Question3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter contact no: ");
		long cont = sc.nextLong();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql@123");
		String query = "delete from product_info where contact = ?";
		
		
			
			pstmt=con.prepareStatement(query);
			pstmt.setLong(1, cont);
			int count = pstmt.executeUpdate();
					
			System.out.println("Product Deleted successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
