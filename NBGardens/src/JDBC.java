import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class JDBC {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mydb";

	static final String USER = "root";
	static final String PASS = "netbuilder";

	Connection conn = null;
	Statement stmt = null;
	ArrayList<CustomerOrder> co;

	public void accessBD() {
		co = new ArrayList<>();
		try {
			Class.forName("JDBC");
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
			String sql2 = "SELECT itemid, itemName FROM itemDB";
			System.out.println(sql2);
			ResultSet rs = stmt.executeQuery(sql2);
			System.out.println(rs);
			while (rs.next()) {
				int id = rs.getInt("itemid");
				String name = rs.getString("itemName");
				co.add(new CustomerOrder(id, name));
				System.out.println("Added from database");
			}
			rs.close();
		} catch(Exception e){
			e.printStackTrace();
		}finally{

		}
	}







}
