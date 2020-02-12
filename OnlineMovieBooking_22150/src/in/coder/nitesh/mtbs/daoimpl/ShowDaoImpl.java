package in.coder.nitesh.mtbs.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.coder.nitesh.mtbs.dao.ShowDao;
import in.coder.nitesh.mtbs.pojo.Customer;
import in.coder.nitesh.mtbs.pojo.Movie;
import in.coder.nitesh.mtbs.pojo.Show;
import in.coder.nitesh.mtbs.utility.DbConnection;

public class ShowDaoImpl implements ShowDao 
{

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String sqlQuery=null;
	@Override
	
	
	public boolean addShow(Show show) {
		sqlQuery=" insert into show_22150 (movieId,theatreName,screenName,showType,"
				+ " showDate,showStartTime,showEndTime,showPrice) values(?,?,?,?,?,?,?,?)";
		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			
			ps.setInt(1, show.getMovieId());
			ps.setString(2, show.getTheatreName());
			ps.setString(3, show.getScreenName());
			ps.setString(4, show.getShowType());
			ps.setString(5, show.getShowDate());
			ps.setString(6, show.getShowStartTime());
			ps.setString(7, show.getShowEndTime());
			ps.setDouble(8, show.getPrice());
			
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
	public boolean updateShow(Show show) {
		
		sqlQuery=" update show_22150 set movieId=?,theatreName=?,screenName=?,showType=?,"
				+ " showDate=?,showStartTime=?,showEndTime=?,showPrice=? where showId=?";
		con=DbConnection.getMyConnection();
		
		try {
			ps=con.prepareStatement(sqlQuery);
			
			ps.setInt(1, show.getMovieId());
			ps.setString(2, show.getTheatreName());
			ps.setString(3, show.getScreenName());
			ps.setString(4, show.getShowType());
			ps.setString(5, show.getShowDate());
			ps.setString(6, show.getShowStartTime());
			ps.setString(7, show.getShowEndTime());
			ps.setDouble(8, show.getPrice());
			ps.setInt(9, show.getShowId());
			
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
	public boolean deleteShow(int showId) {
		
		sqlQuery="delete from show_22150 where showId=?;";
		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setInt(1,showId);
			
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
	public List<Show> showAllShow() {
		
		sqlQuery="select * from show_22150";
		List<Show> showlist=new ArrayList();
		con=DbConnection.getMyConnection();
		
		try {
			ps=con.prepareStatement(sqlQuery);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				Show show=new Show();
				show.setShowId(rs.getInt(1));
				show.setMovieId(rs.getInt(2));
				Movie movie=new MovieDaoImpl().searchMovieById(rs.getInt("movieId"));
				show.setMovie(movie);
				show.setTheatreName(rs.getString(3));
				show.setScreenName(rs.getString(4));
				show.setShowType(rs.getString(5));
				show.setShowDate(rs.getString(6));
				show.setShowStartTime(rs.getString(7));
				show.setShowEndTime(rs.getString(8));
				show.setPrice(rs.getDouble(9));
				showlist.add(show);
			}
			return showlist;
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return null;
	}

	@Override
	public Show showById(int showId) {
		
		sqlQuery=" select * from show_22150 where showId=?;";
		
		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setInt(1,showId);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Show show=new Show();
				show.setShowId(rs.getInt(1));
				show.setMovieId(rs.getInt(2));
				Movie movie=new MovieDaoImpl().searchMovieById(rs.getInt("movieId"));
				show.setMovie(movie);
				show.setTheatreName(rs.getString(3));
				show.setScreenName(rs.getString(4));
				show.setShowType(rs.getString(5));
				show.setShowDate(rs.getString(6));
				show.setShowStartTime(rs.getString(7));
				show.setShowEndTime(rs.getString(8));
				show.setPrice(rs.getDouble(9));
				return show;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Show> showByMovie(int movieId) 
	{
		List<Show> showlist=new ArrayList();
		sqlQuery="select * from show_22150 where movieId=?;";
		
		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setInt(1,movieId);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Show show=new Show();
				show.setShowId(rs.getInt(1));
				show.setMovieId(rs.getInt(2));
				Movie movie=new MovieDaoImpl().searchMovieById(rs.getInt("movieId"));
				show.setMovie(movie);
				show.setTheatreName(rs.getString(3));
				show.setScreenName(rs.getString(4));
				show.setShowType(rs.getString(5));
				show.setShowDate(rs.getString(6));
				show.setShowStartTime(rs.getString(7));
				show.setShowEndTime(rs.getString(8));
				show.setPrice(rs.getDouble(9));
				 showlist.add(show);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return showlist;
	}

}
