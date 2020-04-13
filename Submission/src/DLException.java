import java.sql.*;
import java.util.*;
import java.io.*;

/**
  *
  * A class to handle all exceptions and log them for the various classes
  * built into the project files. 
  *
  * @author Jay Long
  * ISTE-330 Section 01
  * @since 2020-04-10
  *
  */
public class DLException extends Exception {

    Exception e = new Exception();
    ArrayList<ArrayList<String>> info = new ArrayList<ArrayList<String>>();
    
    /**
      *
      * Constructor that accepts an exception.
      *
      * @param _e is the exception passed in.
      *
      */
    public DLException(Exception _e) {
        e = _e;
        writeLog();
    } // end constructor that accepts exception
    
    /**
      *
      * Constructor that accepts an exception and a 2D ArrayList containing
      * additional info.
      *
      * @param _e is the exception passed in.
      * @param _info is the 2D ArrayList containing additional information.
      *
      */
    public DLException(Exception _e, ArrayList<ArrayList<String>> _info) {
        e = _e;
        info = _info;
        writeLog();
    } // end constructor with exception and string data
    
    /**
      *
      * Writes information to a log file that already exists. Will always write information
      * about the exception and the date, and will add any additional info if it exists.
      *
      */
    private void writeLog() {
        try {
            // create a printwriter to write to the log file
            FileWriter fw = new FileWriter("errors.log", true);
            PrintWriter pw = new PrintWriter(fw);
            // get the current time
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            // write information about the exception to the log file
            pw.println("Exception info: ");
            e.printStackTrace(pw);
            // check to see if any additional info was given, and if it was,
            // write it to the log file
            if (info != null) {
                for (ArrayList<String> data : info) {
                    pw.println(data.toString());
                } // end for loop
            } // end if loop
            // write the current time to the log file
            pw.println("Current time: " + timestamp.toString());
            pw.println();
            // close the printwriter
            pw.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Log file does not exist.");
        } catch (IOException ioe) {
            System.out.println("Error could not be logged.");
        } // end try-catch
    } // end writeLog()

} // end DLException