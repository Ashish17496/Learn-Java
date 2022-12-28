package learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String oracleJDBCURL = "jdbc:oracle:thin:@localhost:1521:xe";
		
		String username="system";
		String password="system";
		
		
		Connection co = DriverManager.getConnection(oracleJDBCURL,username,password);
		
		String sql="insert into java(eid,ename,esalary)values(11,'kaju',5000)";
		Statement s=co.createStatement();
	}

}
