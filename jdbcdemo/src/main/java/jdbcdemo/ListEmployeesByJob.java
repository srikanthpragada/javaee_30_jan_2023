package jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ListEmployeesByJob {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/jan30","root","mysql");
        
		PreparedStatement ps = con.prepareStatement("select * from employees where job = ?");
        ps.setString(1,"ppro");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.printf("%-20s %6d\n", 
					rs.getString("fullname"), rs.getInt("salary"));
		}

		ps.close();
		con.close();
	}

}
