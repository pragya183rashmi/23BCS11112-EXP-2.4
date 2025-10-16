// Java Database Connectivity 

// In this program, I emplement the Java and MySQL Database connection
// based on the following 7 steps.
/*1. import  java.sql
 * 2.load and register the driver
 *3.create connection
 *4. create a statement
 *5. execute the querry
 *6. process result
 *7. close
 */

// In addition I send data(i.e an id number and a name for a student) into MySQL database
// I also fetch all data in the database and display them on the eclipse console 
import java.sql.*;

public class javaMySQLconnection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//Accessing driver from the JAR
		Class.forName("com.mysql.jdbc.Driver");
		
		// Creating a variable for the connection called "con" and to 
		//explicitly disable SSL by setting useSSL=false, or set useSSL=true
		String url="jdbc:mysql://localhost:3306/students?autoReconnect=true&useSSL=false";
		String uNme ="root";
		String psswd ="Vision20!";
		
		Connection con = DriverManager.getConnection(url,uNme,psswd);
		
		// New data to send in the database
		int idstData = 5;
		String stName = "Marcellin1";
		
		//A query to send dynamically id number and name in the database
		String query = "insert into students.stdata (idstData, stName) values (?,?)";
		//send the data to the database using preparedStatement
		PreparedStatement st1 = con.prepareStatement(query);
		st1.setInt(1, idstData);
		st1.setString(2, stName);
		int count = st1.executeUpdate();
		System.out.print(count + " row/s affected");
		System.out.println("");
		
		//Retrieving data from the mySql database
		String Query = "select* from students.stdata";
		Statement st = con.createStatement();
		ResultSet rs= st.executeQuery(Query);
		
		String userData = "";
		// Print all the data from the database
		while(rs.next()){
			userData = rs.getInt(1)+ ":" +rs.getString(2);
			System.out.println(userData);
		}
		st.close();
		con.close();
		
	}

	
}
