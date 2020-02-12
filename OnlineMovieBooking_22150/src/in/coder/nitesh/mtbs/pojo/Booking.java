package in.coder.nitesh.mtbs.pojo;

public class Booking 
{
	private int bookingId;
	private int showId;
	private Show show;
	private String custFName,custLName,custEmailId,bookingDate,bookingSeats,bookingStatus;
	private double totalAmmount;
	
	public Booking() 
	{
		super();
	}

	public Booking(int showId, String custFName, String custLName, String custEmailId, String booingDate,
			String bookingSeats, String bookingStatus, double totalAmmount) {
		super();
		this.showId = showId;
		this.custFName = custFName;
		this.custLName = custLName;
		this.custEmailId = custEmailId;
		this.bookingDate = booingDate;
		this.bookingSeats = bookingSeats;
		this.bookingStatus = bookingStatus;
		this.totalAmmount = totalAmmount;
	}

	public Booking(int bookingId, int showId, String custFName, String custLName, String custEmailId, String booingDate,
			String bookingSeats, String bookingStatus, double totalAmmount) {
		super();
		this.bookingId = bookingId;
		this.showId = showId;
		this.custFName = custFName;
		this.custLName = custLName;
		this.custEmailId = custEmailId;
		this.bookingDate = booingDate;
		this.bookingSeats = bookingSeats;
		this.bookingStatus = bookingStatus;
		this.totalAmmount = totalAmmount;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public String getCustFName() {
		return custFName;
	}

	public void setCustFName(String custFName) {
		this.custFName = custFName;
	}

	public String getCustLName() {
		return custLName;
	}

	public void setCustLName(String custLName) {
		this.custLName = custLName;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingSeats() {
		return bookingSeats;
	}

	public void setBookingSeats(String bookingSeats) {
		this.bookingSeats = bookingSeats;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public double getTotalAmmount() {
		return totalAmmount;
	}

	public void setTotalAmmount(double totalAmmount) {
		this.totalAmmount = totalAmmount;
	}

	@Override
	public String toString() {
		return "Booking Id = " + bookingId + ", Show Id = " + showId + ", Show = " + show + ", Customer FName=" + custFName
				+ ", Customer LName = " + custLName + ", Customer EmailId=" + custEmailId + ", Booking Date=" + bookingDate
				+ ", Booking Seats = " + bookingSeats + ", BookingStatus= " + bookingStatus + ", TotalAmmount="
				+ totalAmmount;
	}
	
	
	
}
