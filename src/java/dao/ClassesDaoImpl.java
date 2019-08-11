package dao;

import static bookingclass.connectionDb.DBConnection.getConnection;
import bookingclass.entity.Classes;
import iDao.IClassesDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Aldana
 */
public class ClassesDaoImpl implements IClassesDao {

  PreparedStatement pst;
    Statement st;
    ResultSet rs;

    //Obtain time available for classes type = private or type = in-group 
  @Override
    public ResultSet selectEmptyClass(Date d){
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        LocalDate choosenDate = LocalDate.of(year, month, date);

        Connection con = null;

        String sql = "SELECT * "
                + "FROM classes "
                + "WHERE type = 'empty' "
                + "AND date = '" + choosenDate + "';";

        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
 
        } catch (Exception e) {
            System.err.println(e);
        }
        return rs;

    }

    //Obtain time available for classes type = private or type = in-group 
  @Override
    public ResultSet selectSemiprivateClass(Date d) {
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        LocalDate choosenDate = LocalDate.of(year, month, date);

        Connection con = null;

        String sql = "SELECT * "
                + "FROM classes "
                + "WHERE type = 'empty' "
                + "OR (type = 'semiprivate' AND quantity_students < 4) "
                + "AND date = '" + choosenDate + "';";

        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
           
        } catch (Exception e) {
            System.err.println(e);
        }
        return rs;

    }
    
  @Override
    public int selectTimeChosen (int classId){
        int timeChosen=0;
        Connection con = null;
        
        String sql = "SELECT time "
                + "FROM classes "
                + "WHERE idclasses = " + classId +";"; 
        try{
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
        while (rs.next()){
                timeChosen = rs.getInt("time");
    
            }    
        con.close();
            
            
        }catch (Exception e) {
            System.err.println(e);
        }
        return timeChosen;
    }

            

  @Override
    public boolean book(Classes c) {
        boolean value;
        Connection con = null;

        String sql = "UPDATE classes "
                + "SET type = '" + c.getType() + "', quantity_students ='" + c.getQuantityStudents()+"'"
                + "WHERE idclasses = "+c.getId();
        try {
            con = getConnection();
            pst = con.prepareStatement(sql);

            
           int res = pst.executeUpdate();

            if (res > 0) {
                System.out.println("You have been registered");
                value = true;
            } else {
                System.out.println("Error");
                value = false;
            }

            con.close();
            return value;

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }


    }
    public int checkQuantityStudents (int classID){
        Connection con = null;
        int quantityStudents = 0;
        
        String sql = "SELECT quantity_students "
                + "FROM classes "
                + "WHERE idclasses = '"+classID+"';";
        
        try{
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                quantityStudents = rs.getInt("quantity_students");    
            }    
            con.close();
            
            
        }catch (Exception e) {
            System.err.println(e);
        }
        return quantityStudents;
            
        
        
    }
    
  @Override
    public void insertQuantityStudents(Classes c, int qs){
         Connection con = null;

        String sql = "UPDATE classes "
                + "SET quantity_students = '" + qs + "'"
                + "WHERE idclasses = "+c.getId();
        try {
            con = getConnection();
            pst = con.prepareStatement(sql);

            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.err.println(e);
        }

    }

  @Override
    public Classes getClass(int classId) {
        Classes c = null;
        
        //Fields    
        int idclass = 0;
        Date date = null;
        int time = 0;
        String type = null;
        int quantityStudents = 0;
        
        Connection con = null;
        String sql = "SELECT "
                + "idclasses,  date, time, type, quantity_students "
                + "FROM classes "
                + "WHERE idclasses = '" + classId + "';";
        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                idclass = rs.getInt("idclasses");
                date = rs.getDate("date");
                time = rs.getInt("time");
                type = rs.getString("type");
                quantityStudents = rs.getInt("quantity_students");
            }
          
            c = new Classes(idclass, date, time, type, quantityStudents);
            
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return c;
    }
}
