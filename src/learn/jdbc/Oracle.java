package learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Oracle {

	public static void main(String[] args) {
		try {
			int rowsInserted = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the User details.");

			System.out.println("Enter Id:");
			int id = sc.nextInt();

			System.out.println("Enter Name:");
			String name = sc.next();

			System.out.println("Enter Salary:");
			int salary = sc.nextInt();

			System.out.println("Do you wanted save via normal or prepared statement");
			String medium = sc.next();
			if (null != medium && medium.equalsIgnoreCase("normal")) {
				rowsInserted = insertDataViaNormalStatement(id, name, salary);
			} else if (null != medium && (medium.contains("prep") || medium.contains("Prep"))) {
				rowsInserted = insertDataViaPreparedStatement(id, name, salary);
			} else {
				System.out.println("Please choose correct medium !!!!");
			}
			System.out.println("No of rows inserted: " + rowsInserted);
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static int insertDataViaPreparedStatement(int id, String name, int esalary) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		String oracleJDBCURL = "jdbc:oracle:thin:@localhost:1521:xe";

		String username = "system";
		String password = "system";

		Connection cn = DriverManager.getConnection(oracleJDBCURL, username, password);
		// System.out.println(cn);
		// insert into java(eid,ename,esalary) values(?,?,?)"
		String sql = "insert into java values(?,?,?)";
		PreparedStatement smt = cn.prepareStatement(sql);

		smt.setInt(1, id);
		smt.setString(2, name);
		smt.setInt(3, esalary);

		int row = smt.executeUpdate();
		System.out.println("User Details saved via prepared statement");
		return row;
	}

	public static int insertDataViaNormalStatement(int id, String name, int esalary) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		String oracleJDBCURL = "jdbc:oracle:thin:@localhost:1521:xe";

		String username = "system";
		String password = "system";

		Connection cn = DriverManager.getConnection(oracleJDBCURL, username, password);
		// System.out.println(cn);

		String sql = "insert into java(eid,ename,esalary) values(" + id + ",\'" + name + "\'," + esalary + ")";
		Statement s = cn.createStatement();
		int data = s.executeUpdate(sql);
		System.out.println("User Details saved vai normal statement");

		return data;

	}
}
