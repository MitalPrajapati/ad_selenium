package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Insert_data_to_database {
	public static void main(String[] args) throws Throwable  {
		
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "root");
		
		Statement stmt = conn.createStatement();
		String query = "insert into selenium (id,first_name,last_name,address)values('3','rath','nith','blore')";;
		
		int result = stmt.executeUpdate(query);
		
		if (result==1) {
			System.out.println("data is added");
		} else {
			System.out.println("data is not added");
		}
		conn.close();		
	}
}
