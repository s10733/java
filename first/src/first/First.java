package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class First {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/bok";

	static final String USER = "root";
	static final String PASS = "";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			System.out.println("Creating statement..");
			stmt = conn.createStatement();
			String sql;
			sql = "Select imie, nazwisko from klient";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String imie = rs.getString("imie");
				String nazwisko = rs.getString("nazwisko");
				
				System.out.println("Imiê: "+ imie + " Nazwisko: "+nazwisko);
				
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
			if (stmt!=null) {
				
					stmt.close();
				}
			}catch (SQLException se2) {
					// TODO Auto-generated catch block
					se2.printStackTrace();
					}
			try {
			if(conn!=null){
				
				conn.close();
			}
				} catch (SQLException se) {
					// TODO Auto-generated catch block
					se.printStackTrace();
				}
			}
		}
		
	}


