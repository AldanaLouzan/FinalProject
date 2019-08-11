package viewInterface;

import bookingclass.entity.Classes;
import java.sql.ResultSet;
import java.text.ParseException;


public interface IClass {
    public ResultSet checkClassAvailable(String classType, String date) throws ParseException;
    public int selectTime (int classId);
    public int quantityStudents (String typeClass, int groupQuantity, int previousQuantity);
    public int previousQuantityStudents (int classID);
    public boolean bookClass (Classes c);
}
