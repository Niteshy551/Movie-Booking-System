package in.coder.nitesh.mtbs.dao;
import java.util.List;
import in.coder.nitesh.mtbs.pojo.Booking;

public interface BookingDao 
{
	Booking bookShow(int showId, String custEmailId, String bookingSeats);
	boolean cancelShow(int BookingId);
	List<Booking>getAllBookedShow();
	List<Booking> getAllMyBookedShow(String custEmailId);
	List<String> getAllBookSeats(int showId);
}
