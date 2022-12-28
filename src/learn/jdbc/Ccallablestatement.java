package learn.jdbc;
import java.sql.*;
import java.util.Scanner;

public class Ccallablestatement {

	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String oracleJDBCurl="jdbc:oracle:thin:@localhost:1521:xe";
		
		String username="system";
		String password="system";
		
		Connection cn=DriverManager.getConnection(oracleJDBCurl,username,password);
		
		
		CallableStatement cs=cn.prepareCall("{call INSERT_JAVA(?,?,?,?,?,?)}");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter eid: ");
		int eid=sc.nextInt();
		
		System.out.println("Enter ename: ");
		String ename=sc.next();
		
		System.out.println("Enter esalary: ");
		int esalary=sc.nextInt();
		
		System.out.println("Enter COMPANY ID: ");
		int cid=sc.nextInt();
		
		System.out.println("Enter COMPNAY NAME: ");
		String cname=sc.next();
		
		System.out.println("Enter COMPNAY LOCATION ID: ");
		int clocationid=sc.nextInt();
		
		cs.setInt(1,eid);
		cs.setString(2,ename);
		cs.setInt(3,esalary);
		
		cs.setInt(4,cid);
		cs.setString(5,cname);
		cs.setInt(6,clocationid);
		
		cs.execute();
		
		cs.close();
		cn.close();
		
	
		
		
		

	}

}
