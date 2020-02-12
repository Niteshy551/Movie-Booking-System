package in.coder.nitesh.mtbs.dao;

import java.util.List;

import in.coder.nitesh.mtbs.pojo.Show;

public interface ShowDao 
{
	boolean addShow(Show show);
	boolean updateShow(Show show);
	boolean deleteShow(int showId);
	List<Show> showAllShow();
	Show showById(int showId);
	//List<Show> showByType();
	List<Show> showByMovie(int movieId);
	//List<Show> showByTheatre();
	//List<Show> showByPrice();
	

}
