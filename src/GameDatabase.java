import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by rachelmann on 2/23/14.
 */
public class GameDatabase {
    public String url;
    public String username;
    public String password;

//    Connection db = null;
    public GameDatabase(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection connectToDb(){

        Connection db = null;

        try{

            db = DriverManager.getConnection(url, username, password);
            if (db != null){
                System.out.println("Connection Successful :-)");
                return db;
            } else System.out.println("Connection Failed :-(");

        } catch (Exception e){
            e.printStackTrace();
        }

        return db;
    }
}

