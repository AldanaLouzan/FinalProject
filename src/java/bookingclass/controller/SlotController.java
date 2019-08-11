package bookingclass.controller;

import bookingclass.entity.Classes;
import bookingclass.entity.Slot;
import dao.SlotDaoImpl;
import java.sql.ResultSet;
import java.util.Date;
import viewInterface.ISlot;

/**
 *
 * @author Aldana
 */
public class SlotController implements ISlot {
     SlotDaoImpl data = new SlotDaoImpl();
    
     @Override
    public Slot booking (Classes c, int studentID, String subject, String comment){
        
        Slot slotBooked = new Slot();
        
        slotBooked.setClasses(c);
        slotBooked.setStudentID(studentID);
        slotBooked.setComment(comment);
        slotBooked.setPrice(calculatePrice(c.getType()));
        slotBooked.setStatus("pending");
        slotBooked.setSubject(defineSubject(subject));
        
        return slotBooked;
        
    }
    
     @Override
    public String defineSubject(String subject) {
        String value = null;
        if ("Mathematics".equals(subject)) {
            value = "Maths";
        } else if ("Physics".equals(subject)) {
            value = "Physics";
        } else {
            value = "Chemistry";
        }

        return value;
    }
    
     @Override
    public int calculatePrice(String classType){
        int price = 0;
        if ("private".equals(classType)){
            price = 50;
        }else if ("semiprivate".equals(classType)){
            price = 40;
        }else{
            price = 35;
        }
        return price;
        
    }
    
     @Override
    public boolean bookSlot (Slot s){
        
        boolean booking = data.insertNewSlot(s);
        return booking;
    }
    
    public ResultSet selectSlotJoinClasses(Date d){    
    
        ResultSet rs;
        rs = data.selectSlotJoinClasses(d);
        
        return rs;
        
    }

    @Override
    public int getIdSlotByParameters(Slot s) {
        return data.getIdSlotByParameters(s);
    }
    
}
