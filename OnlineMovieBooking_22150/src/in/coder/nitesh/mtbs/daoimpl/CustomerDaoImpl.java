package in.coder.nitesh.mtbs.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.coder.nitesh.mtbs.dao.CustomerDao;
import in.coder.nitesh.mtbs.pojo.Customer;
import in.coder.nitesh.mtbs.pojo.Movie;
import in.coder.nitesh.mtbs.utility.DbConnection;

public class CustomerDaoImpl implements CustomerDao {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String sqlQuery;

	@Override
	public boolean addCustomer(Customer cust) {
		sqlQuery= " insert into customer_22150(custFName,custLName,custEmailId,"
				+ " custPassword,custContactNo,custAddress)values(?,?,?,?,?,?)";
		
		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1, cust.getCustFName());
			ps.setString(2, cust.getCustLName());
			ps.setString(3, cust.getCustEmailId());
			ps.setString(4, cust.getCustPassword());
			ps.setString(5, cust.getCustContactNo());
			ps.setString(6, cust.getCustAddress());
			
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

	@Override
	public boolean updateCustomer(Customer cust) {
		sqlQuery= " update customer_22150 set custFName=?,custLName=?,custEmailId=?,"
				+ " custPassword=?,custContactNo=?,custAddress=? where custId=? ";
		
		con=DbConnection.getMyConnection();
		
			try {
				ps=con.prepareStatement(sqlQuery);
				
				ps.setString(1, cust.getCustFName());
				ps.setString(2, cust.getCustLName());
				ps.setString(3, cust.getCustEmailId());
				ps.setString(4, cust.getCustPassword());
				ps.setString(5, cust.getCustContactNo());
				ps.setString(6, cust.getCustAddress());
				ps.setInt(7, cust.getCustId());
				
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

	@Override
	public boolean deleteCustomer(int custId) {
		sqlQuery="delete from customer_22150 where custId=?;";
		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setInt(1,custId);
			
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

	@Override
	public List<Customer> showAllCustomer() {
		
		sqlQuery="select * from customer_22150";
		List<Customer> custlist=new ArrayList();
		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Customer cust=new Customer();
				cust.setCustId(rs.getInt(1));
				cust.setCustFName(rs.getString(2));
				cust.setCustLName(rs.getString(3));
				cust.setCustEmailId(rs.getString(4));
				cust.setCustPassword(rs.getString(5));
				cust.setCustContactNo(rs.getString(6));
				cust.setCustAddress(rs.getString(7));
				custlist.add(cust);
			}
			return custlist;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer searchCustomerById(int custId) {
		
		sqlQuery="select * from customer_22150 where custId=?;";
		
		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setInt(1,custId);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Customer cust=new Customer();
				cust.setCustId(rs.getInt(1));
				cust.setCustFName(rs.getString(2));
				cust.setCustLName(rs.getString(3));
				cust.setCustEmailId(rs.getString(4));
				cust.setCustPassword(rs.getString(5));
				cust.setCustContactNo(rs.getString(6));
				cust.setCustAddress(rs.getString(7));
				return cust;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer searchCustomerByEmailId(String custEmailId) {
		sqlQuery="select* from customer_22150 where custEmailId=?";
		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1,custEmailId);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Customer cust=new Customer();
				cust.setCustId(rs.getInt(1));
				cust.setCustFName(rs.getString(2));
				cust.setCustLName(rs.getString(3));
				cust.setCustEmailId(rs.getString(4));
				cust.setCustPassword(rs.getString(5));
				cust.setCustContactNo(rs.getString(6));
				cust.setCustAddress(rs.getString(7));
				return cust;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
