package jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection
				           ("jdbc:mysql://localhost:3306/jan30","root","mysql");
		// System.out.println(con.getClass());
		System.out.println("Connected To JAN30 Database of MySQL!");
		con.close();
	}
}
