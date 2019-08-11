package iDao;

import bookingclass.entity.Booking;
import bookingclass.entity.Classes;
import bookingclass.entity.Slot;
import bookingclass.entity.Student;
import java.sql.ResultSet;

/**
 *
 * @author Aldana
 */

public interface IBookingDao {
    public Booking getBooking(int bookingId);
    public boolean insertNewBooking(Classes c, Slot sl, Student stu);
    public ResultSet getAllBookings();
}
