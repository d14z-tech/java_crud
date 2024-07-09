import java.sql.*;
import java.util.*;

public class my_crud {

	public static void main(String[] args) {
		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/my_db";
		String USER = "root";
		String PASS = "";
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			
			String query = "CREATE TABLE IF NOT EXISTS users (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(255), email VARCHAR(255), idn VARCHAR(255), PRIMARY KEY (id))";
			stmt.executeUpdate(query);
			
			Scanner scan = new Scanner(System.in);
			
			//Add User
			System.out.print("Enter user name: ");
			String name = scan.nextLine();
			
			System.out.print("Enter user email: ");
			String email = scan.nextLine();
			
			System.out.print("Enter identification number: ");
			String idn = scan.nextLine();
			
			query = "INSERT INTO users (name, email, idn) VALUES ('" + name + "', '" + email + "', '" + idn +"')";
			
			stmt.executeUpdate(query);
			
			scan.close();
			stmt.close();
			conn.close();

		} catch(Exception e) {
			System.out.print("Error: " + e.getMessage());
		}
	}

}
