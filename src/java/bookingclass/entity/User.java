package bookingclass.entity;

/**
 *
 * @author Aldana
 */
public class User extends Person {

    private int id;    
    private String email;
    private String password;
    private String phone;

    public User() {
    }

    public User(int id, String email, String password, String phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public User(int id, String email, String password, String phone, String name, String surname) {
        super(name, surname);
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
