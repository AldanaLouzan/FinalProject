package bookingclass.controller;

import bookingclass.entity.Classes;
import dao.ClassesDaoImpl;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import viewInterface.IClass;

/**
 *
 * @author Aldana
 */
public class ClassController implements IClass {
    ClassesDaoImpl data = new ClassesDaoImpl();

   
    @Override
    public ResultSet checkClassAvailable(String classType, String date) throws ParseException{    
        Date d;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        d = sdf.parse(date);
        ResultSet rs;
        
        //Select depending on the type of class
        if ("private".equals(classType) || "ingroup".equals(classType)){
            rs = data.selectEmptyClass(d);
        }else{
            rs = data.selectSemiprivateClass(d);     //Select if class = semiprivate
        }
        return rs;
        
    }
    
    //public int selectTime (Classes c){
    @Override
    public int selectTime (int classId){
        int timeSelected;
        timeSelected = data.selectTimeChosen(classId);
        
        return timeSelected;
    }
    
   
    public int previousQuantityStudents (int classID){
        int previousQuantityStudents = data.checkQuantityStudents (classID);
        return previousQuantityStudents; 
    }
    
    public int quantityStudents (String typeClass, int groupQuantity, int previousQuantity){
        int quantityStudents = 0;
        if ("private".equals(typeClass)){
            quantityStudents = 1;
        }else if ("semiprivate".equals(typeClass)){
            quantityStudents = previousQuantity + 1;
        }else{
            quantityStudents = groupQuantity;
        }
        return quantityStudents; 
    }
    
    public boolean bookClass (Classes c){
        boolean booking = data.book(c);
        return booking;
        
    }

    
}
