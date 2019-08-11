
package iDao;

import bookingclass.entity.Slot;
import java.sql.ResultSet;
import java.util.Date;
/**
 *
 * @author Aldana
 */

public interface ISlotDao {
    public boolean insertNewSlot (Slot s);
    public ResultSet selectSlotJoinClasses(Date d);
    public Slot getSlot(int slotId);
    public int getIdSlotByParameters(Slot s);
}
