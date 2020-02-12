package in.coder.nitesh.mtbs.daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.coder.nitesh.mtbs.dao.BookingDao;
import in.coder.nitesh.mtbs.pojo.Booking;
import in.coder.nitesh.mtbs.pojo.Customer;
import in.coder.nitesh.mtbs.utility.DbConnection;

public class BookingDaoImpl implements BookingDao  
{
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String sqlQuery;
	

	

	@Override
	public Booking bookShow(int showId, String custEmailId, String bookingSeats) 
	{
		con=DbConnection.getMyConnection();
		String bookingDate;
		double totalAmmount;
		
		try {
			Date today=new Date();
			bookingDate=today.toString();
			String sqlQuery1="select showPrice from show_22150 where showId=? ";
			ps=con.prepareStatement(sqlQuery1);
			ps.setInt(1, showId);
			rs=ps.executeQuery();

			if(rs.next())
			{
				int noOfSeats=bookingSeats.split(",").length;
				double showPrice=rs.getDouble("showPrice");
				totalAmmount=showPrice*noOfSeats;
				sqlQuery="insert into booking_22150 (showId,custEmailId,bookingDate,bookingSeats,totalAmmount) values(?,?,?,?,?)";
				ps=con.prepareStatement(sqlQuery);
				ps.setInt(1,showId);
				ps.setString(2, custEmailId);
				ps.setString(3, bookingDate);
				ps.setString(4, bookingSeats);
				ps.setDouble(5, totalAmmount);
				int i=ps.executeUpdate();

				
				if(i>0)
				{
					String sqlQuery2="select * from booking_22150 where custEmailId=? and bookingDate=? ";
					ps=con.prepareStatement(sqlQuery2);
					ps.setString(1, custEmailId);
					ps.setString(2, bookingDate);
					rs=ps.executeQuery();
					
					if(rs.next())
					{
						Booking booking=new Booking();
						
						booking.setBookingId(rs.getInt(1));
						booking.setShowId(rs.getInt(2));
						booking.setCustEmailId(rs.getString(3));
						booking.setBookingDate(rs.getString(4));
						booking.setBookingSeats(rs.getString(5));
						booking.setTotalAmmount(rs.getDouble(6));
						booking.setBookingStatus(rs.getString(7));
						return booking;
					}
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean cancelShow(int bookingId) {
		con = DbConnection.getMyConnection();
		sqlQuery ="update booking_22150 set bookingStatus='Cancel' where bookingId=?";
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setInt(1,bookingId);
			
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
	public List<Booking> getAllBookedShow() {
		
		sqlQuery="select * from booking_22150";
		List<Booking> bookinglist=new ArrayList();
		con=DbConnection.getMyConnection();
		
		try {
			ps=con.prepareStatement(sqlQuery);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Booking booking=new Booking();
				
				booking.setBookingId(rs.getInt(1));
				booking.setShowId(rs.getInt(2));
				booking.setCustEmailId(rs.getString(3));
				booking.setBookingDate(rs.getString(4));
				booking.setBookingSeats(rs.getString(5));
				booking.setTotalAmmount(rs.getDouble(6));
				booking.setBookingStatus(rs.getString(7));
				
				bookinglist.add(booking);			
				}
			return bookinglist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Booking> getAllMyBookedShow(String custEmailId) {
		
		sqlQuery="select * from booking_22150 where custEmailId=?";
		List<Booking> bookinglist=new ArrayList();
		con=DbConnection.getMyConnection();
		
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1, custEmailId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Booking booking=new Booking();
				booking.setBookingId(rs.getInt(1));
				booking.setShowId(rs.getInt(2));
				//booking.setShow(rs.getString(3));
				booking.setBookingDate(rs.getString(4));
				booking.setBookingSeats(rs.getString(5));
				booking.setTotalAmmount(rs.getDouble(6));
				booking.setBookingStatus(rs.getString(7));
				
				bookinglist.add(booking);			
				}
			return bookinglist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> getAllBookSeats(int showId) 
	{
		sqlQuery="select bookingSeats from booking_22150 where showId=?";
		List<String> bookedSeats=new ArrayList();
		con=DbConnection.getMyConnection();
		
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setInt(1, showId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				String seats=rs.getString(1);
				String[] seatarray=seats.split(",");
				for(String s:seatarray)
				{
					bookedSeats.add(s);
				}
				
			}
		return (bookedSeats);
		}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}	
	
	
	
	
	
	