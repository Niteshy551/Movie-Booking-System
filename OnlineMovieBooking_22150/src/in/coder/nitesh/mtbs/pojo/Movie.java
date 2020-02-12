package in.coder.nitesh.mtbs.pojo;

import java.io.InputStream;

public class Movie 
{
	private int movieId;
	private String movieName;
	private String movieType;
	private String movieLanguage;
	private String movieCast;
	private String movieProducer;
	private String movieDirector;
	private String movieDuration;
	private String releaseDate;
	private String movieDescription;
	private String movieReview;
	private InputStream movieImage;
	
	public Movie() 
	{
		super();
	}

	public Movie(int movieId, String movieName, String movieType, String movieLanguage, String movieCast,
			String movieProducer, String movieDirector, String movieDuration, String releaseDate,
			String movieDescription, String movieReview ,InputStream movieImage) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieLanguage = movieLanguage;
		this.movieCast = movieCast;
		this.movieProducer = movieProducer;
		this.movieDirector = movieDirector;
		this.movieDuration = movieDuration;
		this.releaseDate = releaseDate;
		this.movieDescription = movieDescription;
		this.movieReview = movieReview;
		this.movieImage=movieImage;
	}

	public Movie(String movieName, String movieType, String movieLanguage, String movieCast, String movieProducer,
			String movieDirector, String movieDuration, String releaseDate, String movieDescription,
			String movieReview,InputStream movieImage) {
		super();
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieLanguage = movieLanguage;
		this.movieCast = movieCast;
		this.movieProducer = movieProducer;
		this.movieDirector = movieDirector;
		this.movieDuration = movieDuration;
		this.releaseDate = releaseDate;
		this.movieDescription = movieDescription;
		this.movieReview = movieReview;
		this.movieImage=movieImage;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieCast() {
		return movieCast;
	}

	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}

	public String getMovieProducer() {
		return movieProducer;
	}

	public void setMovieProducer(String movieProducer) {
		this.movieProducer = movieProducer;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public String getMovieReview() {
		return movieReview;
	}

	public void setMovieReview(String movieReview) {
		this.movieReview = movieReview;
	}

	public InputStream getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(InputStream movieImage) {
		this.movieImage = movieImage;
	}

	@Override
	public String toString() {
		return "Movie Id= " + movieId + ", Movie Name = " + movieName + ", Movie Type= " + movieType
				+ ", Movie Language= " + movieLanguage + ", Movie Cast= " + movieCast + ", Movie Producer= " + movieProducer
				+ ", Movie Director= " + movieDirector + ", Movie Duration= " + movieDuration + ", Release Date= "
				+ releaseDate + ", Movie Description= " + movieDescription + ", Reviews= " + movieReview ;
	}
}
