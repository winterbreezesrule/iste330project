import java.sql.*;
import java.util.*;

/**
  *
  * A class to connect to a MySQL database. 
  * Written for the class project.
  *
  * @author Jay Long
  * ISTE-330 Section 01
  * @since 2020-04-10
  *
  */
public class MySQLDatabase {

    private String database;
    private String user;
    private String pass;
    private Connection conn;
    private ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
    
    /**
      *
      * The constructor for this class. Because someone using it may have
      * different credentials on their MySQL instance installed on their machine,
      * the only valid constructor takes a username and password. Because the
      * database remains the same throughout, that does not need to be added.
      *
      */

    public MySQLDatabase(String _user, String _pass) {
        user = _user;
        pass = _pass;
        database = "jdbc:mysql://localhost/travel?useSSL=false";
    } // end constructor
    
    /**
      *
      * Method to connect to the MySQL database.
      *
      * @return true if connection was successful. An exception is thrown otherwise.
      * 
      */
    public boolean connect() throws DLException {
        try {
            conn = DriverManager.getConnection(database, user, pass);
            return true;
        } catch (Exception e) {
            System.out.println("Connection could not be created.");
            throw new DLException(e);
        } // end try-catch
    } // end connect()
    
    /**
      *
      *
      * Method to close the connection to the MySQL Database.
      *
      * @return true if the connection was closed successfully. An
      * exception is thrown otherwise.
      */
    public boolean close() throws DLException {
        try {
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Connection could not be closed.");
            throw new DLException(e);
        } // end try-catch
    } // end close()
      
    /**
      *
      * METHOD TO CREATE PREPARED STATEMENTS GOES HERE
      *
      */
      
    /**
      *
      * METHOD TO GET DATA USING PREP STATES GOES HERE
      *
      */
    
    /**
      *
      * METHOD TO SET DATA USING PREP STATES GOES HERE
      *
      */
      
    /**
      *
      * METHOD TO EXECUTE STATEMENT USING PREP STATES GOES HERE
      *
      */
      
    /**
      *
      * METHODS TO START, END, AND ROLLBACK TRANSACTIONS GO HERE
      *
      */

} // end MySQLDatabase 