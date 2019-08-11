package iDao;

import bookingclass.entity.Teacher;

/**
 *
 * @author Aldana
 */
public interface ITeacherDao {
    public boolean insertTeacher(Teacher t);
    public boolean checkUser(String email);
    public String checkPass (String email); 
    
}
