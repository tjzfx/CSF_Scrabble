import java.sql.*;

/**
 * Created by rachelmann on 2/23/14.
 */
public class User {

    public String userName;
    public String userEmail;

    public User(String userName, String userEmail){
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public void saveUser (User user, Connection db){

        userName = user.userName.toString();
        userEmail = user.userEmail.toString();

        try{

            Statement st = db.createStatement();

            String sql = "INSERT INTO Users (UserName, Email) VALUES ('"+userName+"', '"+userEmail+"')";
            int rowsAdded = st.executeUpdate(sql);

            st.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public Boolean userExists(User user, Connection db){

        try{

            userName = user.userName.toString();

            Statement st = db.createStatement();
            String sql = "SELECT * FROM Users WHERE username = '"+userName+"'";
            ResultSet rs = st.executeQuery(sql);
            int i = 0;

            while (rs.next()){
                i++;
            }

            if (i > 0){
                System.out.println("User already exists");
                return true;
            } else{
                System.out.println("This is a new user");
                return false;
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public void printAllUsers(Connection db){

        try{

            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Users;");

            while (rs.next()){
                int userID = rs.getInt(1);
                String userName = rs.getString(2);
                String userEmail = rs.getString(3);
                System.out.println(userID+" "+userName+" "+userEmail);
            } rs.close();
            st.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
