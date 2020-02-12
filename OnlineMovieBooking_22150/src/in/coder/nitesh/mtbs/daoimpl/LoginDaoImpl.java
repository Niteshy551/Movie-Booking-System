package in.coder.nitesh.mtbs.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.coder.nitesh.mtbs.dao.LoginDao;
import in.coder.nitesh.mtbs.utility.DbConnection;

public class LoginDaoImpl implements LoginDao
{
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String sqlQuery;
	
	
	@Override
	public boolean isAdmin(String adminEmailId, String adminPassword) 
	{
		con=DbConnection.getMyConnection();
		sqlQuery="select * from admin_22150 where adminEmailId=? and adminPassword=?";
		try {
			ps=con.prepareStatement(sqlQuery);
			
			ps.setString(1, adminEmailId);
			ps.setString(2, adminPassword);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isCustomer(String custEmailId, String custPassword) 
	{
		con=DbConnection.getMyConnection();
		sqlQuery="select * from customer_22150 where custEmailId=? and custPassword=?";
		try {
			ps=con.prepareStatement(sqlQuery);
			
			ps.setString(1, custEmailId);
			ps.setString(2, custPassword);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isCustPassword(String custEmailId, String custPassword) 
	{
		con=DbConnection.getMyConnection();
		sqlQuery="select * from customer_22150 where custEmailId=? and custPassword=?";
		try {
			ps=con.prepareStatement(sqlQuery);
			
			ps.setString(1, custEmailId);
			ps.setString(2, custPassword);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changePassword(String custEmailId, String oldPassword, String newPassword) {
		con=DbConnection.getMyConnection();
		sqlQuery="update admin_22150 set adminPassword=? where adminEmailId=? and adminpassword=?;";
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1, newPassword);
			ps.setString(2, custEmailId);
			ps.setString(3, oldPassword);
			System.out.println(ps);
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			else 
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		return false;
	}

	@Override
	public boolean forgetPassword(String custEmailId, String custContactNo, String custPassword) 
	{
		con=DbConnection.getMyConnection();
		sqlQuery="update customer_22150 set custPassword=? where custEmailId=? and custContactNo=?;";
		
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1, custPassword);
			ps.setString(2, custEmailId);
			ps.setString(3, custContactNo);
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
}
