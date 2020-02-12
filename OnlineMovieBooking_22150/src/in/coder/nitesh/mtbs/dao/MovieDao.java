package in.coder.nitesh.mtbs.dao;

import java.util.List;

import in.coder.nitesh.mtbs.pojo.Movie;

public interface MovieDao 
{
	boolean addMovie(Movie movie);
	boolean updateMovie(Movie movie);
	boolean deleteMovie(int movieId);
	List<Movie> showAllMovie();
	Movie searchMovieById(int movieId);
	Movie searchMovieByName(String movieName);
	List<Movie> upcomingMovie();
	List<Movie> searchByDirector(String movieDirector);
	List<Movie> searchMovieByProducer(String movieProducer);
	List<Movie> searchMovieByType(String movieType);
	List<Movie> searchMovieByLanguage(String movieLanguage);
	List<Movie> searchMovieByCast(String movieCast);
	
}
