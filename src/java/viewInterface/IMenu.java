package viewInterface;

import bookingclass.entity.Classes;
import bookingclass.entity.Slot;
import java.text.ParseException;
import java.util.Date;


public interface IMenu { 
    public int login(String email, String pass); 
    public Date chooseDate(String day) throws ParseException;
    public boolean confirmBooking (Classes c, Slot s);
}
