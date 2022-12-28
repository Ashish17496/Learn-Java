package learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * This is Demo Application
 * */
public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String oracleJDBCURL = "jdbc:oracle:thin:@localhost:1521:xe";
		
		String username="system";
		String password="system";		
		Connection c = DriverManager.getConnection(oracleJDBCURL,username,password);
		System.out.println(c);
		
		String sql="insert into java(eid,ename,esalary)values(12,'raju',3000)";
		String sql2="insert into java(eid,ename,esalary)values(13,'kaju',4000)";
		Connection con;
		Statement s=c.createStatement();
		int row=s.executeUpdate(sql);
		System.out.println(row);		
		
	}

}


