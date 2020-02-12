package in.coder.nitesh.mtbs.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.coder.nitesh.mtbs.dao.MovieDao;
import in.coder.nitesh.mtbs.pojo.Movie;
import in.coder.nitesh.mtbs.utility.DbConnection;

public class MovieDaoImpl implements MovieDao {
	
	Connection con=null; 		 //For Connection
	PreparedStatement ps=null;   //For Execute the Query
	ResultSet rs=null;  		 //To Store Query Result
	String sqlQuery=null;		//For store Query

	@Override
	public boolean addMovie(Movie movie) {
		sqlQuery="insert into movie_22150(movieName,movieType,movieLanguage,"
				+ "movieCast,movieProducer,movieDirector,movieDuration,releaseDate,"
				+ "movieDescription,movieReview,movieImage) values (?,?,?,?,?,?,?,?,?,?,?)";
		
		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1, movie.getMovieName());
			ps.setString(2, movie.getMovieType());
			ps.setString(3, movie.getMovieLanguage());
			ps.setString(4, movie.getMovieCast());
			ps.setString(5, movie.getMovieProducer());
			ps.setString(6, movie.getMovieDirector());
			ps.setString(7, movie.getMovieDuration());
			ps.setString(8, movie.getReleaseDate());
			ps.setString(9, movie.getMovieDescription());
			ps.setString(10,movie.getMovieReview());
			ps.setBinaryStream(11,movie.getMovieImage());
			
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
	public boolean updateMovie(Movie movie) {
		sqlQuery="update movie_22150 set movieName=?,movieType=?,movieLanguage=?,  "+
								" movieCast=?,movieProducer=?,movieDirector=?,movieDuration=?,releaseDate=?, " +
								" movieDescription=?,movieReview=?,movieImage=? where movieId=?";

		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1, movie.getMovieName());
			ps.setString(2, movie.getMovieType());
			ps.setString(3, movie.getMovieLanguage());
			ps.setString(4, movie.getMovieCast());
			ps.setString(5, movie.getMovieProducer());
			ps.setString(6, movie.getMovieDirector());
			ps.setString(7, movie.getMovieDuration());
			ps.setString(8, movie.getReleaseDate());
			ps.setString(9, movie.getMovieDescription());
			ps.setString(10,movie.getMovieReview());
			ps.setBinaryStream(11,movie.getMovieImage());
			ps.setInt(12, movie.getMovieId());
			
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
	
	public boolean deleteMovie(int movieId) {
		sqlQuery="delete from movie_22150 where movieId=?;";
		
		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setInt(1,movieId);
			
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
	public List<Movie> showAllMovie() {
		sqlQuery="select * from movie_22150";
		ArrayList<Movie> movielist=new ArrayList();
		
		try {
			con=DbConnection.getMyConnection();
			ps=con.prepareStatement(sqlQuery);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Movie movie=new Movie();
				movie.setMovieId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieType(rs.getString(3));
				movie.setMovieLanguage(rs.getString(4));
				movie.setMovieCast(rs.getString(5));
				movie.setMovieProducer(rs.getString(6));
				movie.setMovieDirector(rs.getString(7));
				movie.setMovieDuration(rs.getString(8));
				movie.setReleaseDate(rs.getString(9));
				movie.setMovieDescription(rs.getString(10));
				movie.setMovieReview(rs.getString(11));
				movie.setMovieImage(rs.getBinaryStream(12));
				movielist.add(movie);
			}
			return movielist;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Movie searchMovieById(int movieId) {
		sqlQuery="select * from movie_22150 where movieId=?;";
		
			con=DbConnection.getMyConnection();
			try {
				ps=con.prepareStatement(sqlQuery);
				ps.setInt(1,movieId);
				rs=ps.executeQuery();
				
				while(rs.next())
				{
					Movie movie=new Movie();
					movie.setMovieId(rs.getInt(1));
					movie.setMovieName(rs.getString(2));
					movie.setMovieType(rs.getString(3));
					movie.setMovieLanguage(rs.getString(4));
					movie.setMovieCast(rs.getString(5));
					movie.setMovieProducer(rs.getString(6));
					movie.setMovieDirector(rs.getString(7));
					movie.setMovieDuration(rs.getString(8));
					movie.setReleaseDate(rs.getString(9));
					movie.setMovieDescription(rs.getString(10));
					movie.setMovieReview(rs.getString(11));
					movie.setMovieImage(rs.getBinaryStream(12));
					return movie;
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	@Override
	public Movie searchMovieByName(String movieName) {
		sqlQuery="select * from movie_22150 where movieName=?;";
		
		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1,movieName);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Movie movie=new Movie();
				movie.setMovieId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieType(rs.getString(3));
				movie.setMovieLanguage(rs.getString(4));
				movie.setMovieCast(rs.getString(5));
				movie.setMovieProducer(rs.getString(6));
				movie.setMovieDirector(rs.getString(7));
				movie.setMovieDuration(rs.getString(8));
				movie.setReleaseDate(rs.getString(9));
				movie.setMovieDescription(rs.getString(10));
				movie.setMovieReview(rs.getString(11));
				movie.setMovieImage(rs.getBinaryStream(12));
				return movie;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Movie> upcomingMovie() {
		return null;
	}

	@Override
	public List<Movie> searchByDirector(String movieDirector) {
		sqlQuery="select * from movie_22150 where movieDirector=?;";
		
		con=DbConnection.getMyConnection();
		ArrayList<Movie> movielist=new ArrayList();
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1,movieDirector);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Movie movie=new Movie();
				movie.setMovieId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieType(rs.getString(3));
				movie.setMovieLanguage(rs.getString(4));
				movie.setMovieCast(rs.getString(5));
				movie.setMovieProducer(rs.getString(6));
				movie.setMovieDirector(rs.getString(7));
				movie.setMovieDuration(rs.getString(8));
				movie.setReleaseDate(rs.getString(9));
				movie.setMovieDescription(rs.getString(10));
				movie.setMovieReview(rs.getString(11));
				
				movielist.add(movie);
			}
			return movielist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Movie> searchMovieByProducer(String movieProducer) {
		sqlQuery="select * from movie_22150 where movieProducer=?;";
		
		con=DbConnection.getMyConnection();
		try {
			ArrayList<Movie> movielist=new ArrayList<Movie>();
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1,movieProducer);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Movie movie=new Movie();
				movie.setMovieId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieType(rs.getString(3));
				movie.setMovieLanguage(rs.getString(4));
				movie.setMovieCast(rs.getString(5));
				movie.setMovieProducer(rs.getString(6));
				movie.setMovieDirector(rs.getString(7));
				movie.setMovieDuration(rs.getString(8));
				movie.setReleaseDate(rs.getString(9));
				movie.setMovieDescription(rs.getString(10));
				movie.setMovieReview(rs.getString(11));
				movie.setMovieImage(rs.getBinaryStream(12));
				
				movielist.add(movie);
			}
			return movielist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Movie> searchMovieByType(String movieType) {
		sqlQuery="select * from movie_22150 where movieType=?;";
		ArrayList<Movie> movielist=new ArrayList<Movie>();
		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1,movieType);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Movie movie=new Movie();
				movie.setMovieId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieType(rs.getString(3));
				movie.setMovieLanguage(rs.getString(4));
				movie.setMovieCast(rs.getString(5));
				movie.setMovieProducer(rs.getString(6));
				movie.setMovieDirector(rs.getString(7));
				movie.setMovieDuration(rs.getString(8));
				movie.setReleaseDate(rs.getString(9));
				movie.setMovieDescription(rs.getString(10));
				movie.setMovieReview(rs.getString(11));
				movielist.add(movie);
			}
			return movielist;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}
	@Override
	public List<Movie> searchMovieByLanguage(String movieLanguage) {
		sqlQuery="select * from movie_22150 where movieLanguage=?;";
		con=DbConnection.getMyConnection();
		try {
			ps=con.prepareStatement(sqlQuery);
			ArrayList<Movie> movielist=new ArrayList<Movie>();
			ps.setString(1,movieLanguage);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Movie movie=new Movie();
				movie.setMovieId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieType(rs.getString(3));
				movie.setMovieLanguage(rs.getString(4));
				movie.setMovieCast(rs.getString(5));
				movie.setMovieProducer(rs.getString(6));
				movie.setMovieDirector(rs.getString(7));
				movie.setMovieDuration(rs.getString(8));
				movie.setReleaseDate(rs.getString(9));
				movie.setMovieDescription(rs.getString(10));
				movie.setMovieReview(rs.getString(11));
				movie.setMovieImage(rs.getBinaryStream(12));
				movielist.add(movie);
			}
			return movielist;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Movie> searchMovieByCast(String movieCast) {
		sqlQuery="select * from movie_22150 where movieCast like ?";
		
		ArrayList<Movie> movielist=new ArrayList<Movie>();
		con=DbConnection.getMyConnection();
		
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1,"%"+movieCast+"%");
			rs=ps.executeQuery();
			while(rs.next())
			{
				Movie movie=new Movie();
				movie.setMovieId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieType(rs.getString(3));
				movie.setMovieLanguage(rs.getString(4));
				movie.setMovieCast(rs.getString(5));
				movie.setMovieProducer(rs.getString(6));
				movie.setMovieDirector(rs.getString(7));
				movie.setMovieDuration(rs.getString(8));
				movie.setReleaseDate(rs.getString(9));
				movie.setMovieDescription(rs.getString(10));
				movie.setMovieReview(rs.getString(11));
				movie.setMovieImage(rs.getBinaryStream(12));
				movielist.add(movie);
			}
			return movielist;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
