package in.coder.nitesh.mtbs.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection 
{
	//It is a utility class,So we don't need to create of this class
	private static Connection con=null;
	static {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mtbs_22150", "root","root");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private DbConnection() 
	{
		super();
	}
	
	public static Connection getMyConnection()
	{
		return con;
	}
	public static void main(String[] args) 
	{
		Connection con=getMyConnection();
		if(con!=null)
		{
			System.out.println("Connected...");
		}
		else
			System.out.println("Not Connected");
		
	}

}
