package in.coder.nitesh.mtbs.pojo;

public class Show 
{
	private int showId;
	
	private int movieId;
	private Movie movie;
	private String theatreName;
	private String screenName;
	private String showType;
	private String showDate;
	private String showStartTime;
	private String showEndTime;
	private double price;
	
	public Show() 
	{
		super();
	}

	public Show(int movieId, String theatreName, String screenName, String showType, String showDate,
			String showStartTime, String showEndTime, double price) {
		super();
		this.movieId = movieId;
		this.theatreName = theatreName;
		this.screenName = screenName;
		this.showType = showType;
		this.showDate = showDate;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.price = price;
	}

	public Show(int showId, int movieId, String theatreName, String screenName, String showType, String showDate,
			String showStartTime, String showEndTime, double price) {
		super();
		this.showId = showId;
		this.movieId = movieId;
		this.theatreName = theatreName;
		this.screenName = screenName;
		this.showType = showType;
		this.showDate = showDate;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.price = price;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public String getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(String showStartTime) {
		this.showStartTime = showStartTime;
	}

	public String getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(String showEndTime) {
		this.showEndTime = showEndTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", movie=" + movie + ", theatreName=" + theatreName + ", screenName="
				+ screenName + ", showType=" + showType + ", showDate=" + showDate + ", showStartTime=" + showStartTime
				+ ", showEndTime=" + showEndTime + ", price=" + price + "]";
	}
	
	
	
	
	
}
