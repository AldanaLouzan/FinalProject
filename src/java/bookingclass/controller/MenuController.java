package bookingclass.controller;


import bookingclass.entity.Classes;
import bookingclass.entity.Slot;
import bookingclass.entity.Student;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import viewInterface.IMenu;

/**
 *
 * @author Aldana
 */

public class MenuController implements IMenu {

    //Variables to manage the interaction with user
    String choice = null;
    Scanner scan = new Scanner(System.in);
    Scanner kb = new Scanner(System.in);

    StudentController sc = new StudentController();
    ParentController pc = new ParentController();
    ClassController cCon = new ClassController();
    SlotController slotC = new SlotController();
    TeacherController tt = new TeacherController();
    BookingController bk = new BookingController();


    @Override
    public int login(String email, String pass) {
        int value;
        boolean checkTeacher = tt.checkTeacher(email);
        
        if (checkTeacher == true) {
            boolean checkTeacherPass = tt.checkTeacherPassword(email, pass);
            if (checkTeacherPass == true) {
                value = 1;  //Access to Teacher Account
            } else {
                value = 0;  //Password wrong
            }
        } else {
            boolean checkUser = sc.checkUser(email);
            boolean checkPass = sc.checkUserPassword(email, pass);

            if (checkUser == true && checkPass == true) {
                value = 2;  // Access to Student Accoun
            } else {
                value = 0;  //Password or user wrong
            }
            }
        return value;
    }

    //Select and set Class Date
    @Override
    public Date chooseDate(String day) throws ParseException {
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");       
        
        date = sdf.parse(day);
     
        return date;
    }

    
    
    @Override
    public boolean confirmBooking (Classes c, Slot s) {
        int idStudent;
        int idSlot;
        Student stu=null;
        Slot slot=null;
        boolean value;
        if (cCon.bookClass(c) == true && slotC.bookSlot(s)== true){
            //value = true;
            idStudent = s.getStudentID();
            stu = sc.getStudent(idStudent);
            idSlot = slotC.getIdSlotByParameters(s);
            s.setIdSlot(idSlot);
            //Persist Booking. BookingController
            boolean success = bk.insertNewBooking(c,s,stu);
            if (success==true)
            {
                value=true;
            }
            else
            {
                value=false;
            }
        }else{
            value = false;
        }
        return value;
    }   
}
