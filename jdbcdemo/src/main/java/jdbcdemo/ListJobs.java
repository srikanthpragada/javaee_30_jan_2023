package jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListJobs {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/jan30","root","mysql");
        
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from jobs");
		
		while(rs.next()) {
			System.out.printf("%-20s %6d\n", 
					rs.getString("title"), rs.getInt("minsal"));
		}

		st.close();
		con.close();
	}

}
