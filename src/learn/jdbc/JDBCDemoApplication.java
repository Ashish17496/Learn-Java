/**
 * https://www.oracle.com/in/database/technologies/appdev/jdbc-downloads.html
 */
package learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Ashish.Mishra
 *
 */
public class JDBCDemoApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection connection = null;
		// 1) load the driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		try {
			// 2) Open a connection
			String oracleJDBCURL = "jdbc:oracle:thin:@localhost:1521:xe";
			// String mysqlJDBCURL = "jdbc:mysql://localhost:3306/sonoo";
			String userName = "system";
			String password = "system";
			connection = DriverManager.getConnection(oracleJDBCURL, userName, password);
			// 3) Create statement
			Statement statement = connection.createStatement();
			// 4) execute query
			ResultSet rs = statement.executeQuery("select company_name from company");
			// 5) process resultset
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("No of columns: "+ rsmd.getColumnCount());
			
			int i=1;
			while(i<=rsmd.getColumnCount()) {
				System.out.println("Col Index: "+i+", Col Name:"+rsmd.getColumnName(i)+", Col Type:"+rsmd.getColumnTypeName(i));
				i++;
			}
			System.out.println("----------------------------");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			// 6) close statement and connection
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
