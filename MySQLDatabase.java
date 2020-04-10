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
      * Method to create a prepared statement for further usage.
      *
      * @param sql is the SQL statement passed in
      * @param values is an arraylist of values to be bound to the statement
      * @return the prepared statement
      *
      */
    private PreparedStatement prepare(String sql, ArrayList<String> values) throws DLException {
        try {
            // prepare the statement
            PreparedStatement ps = conn.prepareStatement(sql);
            // bind the values
            for (int i = 1; i <= values.size(); i++) {
                ps.setString(i, values.get(i - 1));
            } 
            // return the prepared statement
            return ps;
        } catch (Exception e) {
            System.out.println("Statement could not be prepared.");
            // create 2d ArrayList to hold extra info
            ArrayList<ArrayList<String>> info = new ArrayList<ArrayList<String>>();
            ArrayList<String> statement = new ArrayList<String>();
            // add info on passed in sql statement
            statement.add("SQL Query:");
            statement.add(sql);
            // add info to 2d ArrayList
            info.add(statement);
            // add info on values to be bound
            values.add(0, "Values to be bound:");
            info.add(values);
            throw new DLException(e, info);
        }
    } // end prepare()
    
    /**
      *
      * Gets data using prepared statements.
      *
      * @param sql is the SQL statement passed in
      * @param values is an arraylist of values to be bound to the statement
      * @return an array list with relevant data. Returns null if no data returned.
      *
      */
    public ArrayList<ArrayList<String>> getData(String sql, ArrayList<String> values) throws DLException {
        try {
            // create prepared statement
            PreparedStatement ps = prepare(sql, values);
            // get result set, create arraylist to hold results
            ResultSet rs = ps.executeQuery();
            ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
            // get metadata about the results
            ResultSetMetaData rsmd = rs.getMetaData();
            int resultColumns = rsmd.getColumnCount();
            
            ArrayList<String> fieldnames = new ArrayList<String>();
            ArrayList<String> fieldwidths = new ArrayList<String>();
            for (int i = 1; i <= resultColumns; i++) {
                fieldnames.add(rsmd.getColumnLabel(i));
                fieldwidths.add(Integer.toString(rsmd.getColumnDisplaySize(i)));
            } // end for loop
            fieldnames.toString();
            fieldwidths.toString();
            results.add(fieldnames);
            results.add(fieldwidths);
            
            // iterate through resultset and put data into arraylist
            while (rs.next()) {
                ArrayList<String> resultrow = new ArrayList<String>();
                for (int i = 1; i <= resultColumns; i++) {
                    resultrow.add(rs.getString(i));
                } // end for loop
                results.add(resultrow);
            } // end while loop
            // return results
            return results;
        } catch (Exception e) {
            System.out.println("Data could not be retrieved.");
            // create 2d ArrayList to hold extra info
            ArrayList<ArrayList<String>> info = new ArrayList<ArrayList<String>>();
            ArrayList<String> statement = new ArrayList<String>();
            // add info on passed in sql statement
            statement.add("SQL Query:");
            statement.add(sql);
            // add info to 2d ArrayList
            info.add(statement); 
            // add info on values attempted to be bound
            values.add(0, "Values to be bound:");
            info.add(values);           
            throw new DLException(e, info);
        }
    } // end getData()
    
    /**
      *
      * Sets data using prepared statements.
      * 
      * @param sql is the SQL statement passed in
      * @param values is an arraylist of values to be bound to the statement
      * @return an int indicating how many rows were changed
      *
      */
    public int setData(String sql, ArrayList<String> values) throws DLException {
        try {
            return executeStmt(sql, values);
        } catch (Exception e) {
            System.out.println("Data could not be changed.");
            // create 2d ArrayList to hold extra info
            ArrayList<ArrayList<String>> info = new ArrayList<ArrayList<String>>();
            ArrayList<String> statement = new ArrayList<String>();
            // add info on passed in sql statement
            statement.add("SQL Query:");
            statement.add(sql);
            // add info to 2d ArrayList
            info.add(statement); 
            // add info on values attempted to be bound
            values.add(0, "Values to be bound:");
            info.add(values);           
            throw new DLException(e, info);
        }
    } // end setData()
    
    /**
      *
      * Executes a statement using prepared statements.
      *
      * 
      * @param sql is the SQL statement passed in
      * @param values is an arraylist of values to be bound to the statement
      * @return an int indicating how many rows were changed
      *
      */
    private int executeStmt(String sql, ArrayList<String> values) throws DLException {
        try {
            PreparedStatement ps = prepare(sql, values);
            int changed;
            changed = ps.executeUpdate();
            return changed;
        } catch (Exception e) {
            System.out.println("Statement could not be executed.");
            // create 2d ArrayList to hold extra info
            ArrayList<ArrayList<String>> info = new ArrayList<ArrayList<String>>();
            ArrayList<String> statement = new ArrayList<String>();
            // add info on passed in sql statement
            statement.add("SQL Query:");
            statement.add(sql);
            // add info to 2d ArrayList
            info.add(statement); 
            // add info on values attempted to be bound
            values.add(0, "Values to be bound:");
            info.add(values);           
            throw new DLException(e, info);
        }
    } // end executeStmt()
    
    /**
      *
      * Sets autocommit to false, because that is how a transaction is started in Java.
      *
      */
    public void startTrans() throws DLException {
        try {
            conn.setAutoCommit(false);
        } catch (Exception e) {
            System.out.println("Transaction could not be started.");
            ArrayList<ArrayList<String>> info = new ArrayList<ArrayList<String>>();
            ArrayList<String> statement = new ArrayList<String>();
            statement.add("Attempted to start a SQL transaction. The connection's autocommit value"
                          + " could not be set to false.");
            info.add(statement);
            throw new DLException(e, info);
        }
    } // end startTrans()
    
    /**
      *
      * Commits a transaction, and sets autocommit to true.
      *
      */
    public void endTrans() throws DLException {
        try {
            conn.commit();
            conn.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println("Transaction could not be ended.");
            ArrayList<ArrayList<String>> info = new ArrayList<ArrayList<String>>();
            ArrayList<String> statement = new ArrayList<String>();
            statement.add("Attempted to end a SQL transaction. The transaction either could not"
                           + " be successfully committed, or the connection's autocommit value" 
                           + " could not be set to true.");
            info.add(statement);
            throw new DLException(e, info);
        }
    }
    
    /**
      *
      * Rolls back a transaction, and sets autocommit to true.
      *
      */
    public void rollbackTrans() throws DLException {
        try {
            conn.rollback();
            conn.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println("Transaction could not be ended.");
            ArrayList<ArrayList<String>> info = new ArrayList<ArrayList<String>>();
            ArrayList<String> statement = new ArrayList<String>();
            statement.add("Attempted to roll back a SQL transaction. The transaction either could not"
                           + " be successfully rolled back, or the connection's autocommit value" 
                           + " could not be set to true.");
            info.add(statement);
            throw new DLException(e, info);
        }
    }

} // end MySQLDatabase 