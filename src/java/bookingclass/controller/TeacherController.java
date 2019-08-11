package bookingclass.controller;

import bookingclass.entity.Teacher;
import dao.TeacherDaoImpl;
import viewInterface.ITeacher;

/**
 *
 * @author Aldana
 */


public class TeacherController implements ITeacher {
    TeacherDaoImpl data = new TeacherDaoImpl();
    
    
    @Override
    public boolean registerTeacher (Teacher t){
        return data.insertTeacher(t);
    }
    
    @Override
    public boolean checkTeacher(String email) {
        boolean registeredTeacher = data.checkUser(email);//Password request to DB
        return registeredTeacher; 
    }

    
    @Override
    public boolean checkTeacherPassword(String email, String password) {
        String correctPass = data.checkPass(email);//Password request to DB
        
        if (password.equals(correctPass)) {
            return true;

        }
        return false;
        
    }
}
