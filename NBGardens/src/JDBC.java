import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mydb";

	static final String USER = "root";
	static final String PASS = "netbuilder";

	Connection conn = null;
	Statement stmt = null;

	public void accessBD() {

		try {
			Class.forName( "JDBC");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			readItemDB();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) { }
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	} 

	void readItemDB(){
		try{
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql2 = "SELECT id, name";
			ResultSet rs = stmt.executeQuery(sql2);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println("ID: " + id + ", name: " + name);
			}
			rs.close();
		} catch(Exception e){

		}finally{

		}
	}







}
