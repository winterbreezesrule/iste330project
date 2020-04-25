import io.jsonwebtoken.*;
import javafx.beans.binding.IntegerBinding;

import java.nio.IntBuffer;
import java.util.ArrayList;

/**
 * A generic class we use for CRUD methods.
 * This class is extended by all of the other data objects
 * Each of those classes uses these methods with its own attributes
 *
 * @author Aaron Erhart
 */

public class DLObject {
    private final String uName = "root";
    private final String uPass = "USO800rubysky#1!";

    /**
     * Fetch method for objects that have more than one primary key
     *
     * @param tableName name of the table to get data from
     * @param pkNames ArrayList containing the names of the primary key attributes
     * @param pkData ArrayList containing the values of the primary keys
     * @return 2D ArrayList containing the selected data
     * @throws DLException custom exception that logs errors in a separate file
     */
    public ArrayList<ArrayList<String>> fetch(String tableName, ArrayList<String> pkNames, ArrayList<String> pkData, Jws<Claims> token) throws DLException{

        MySQLDatabase db = new MySQLDatabase(uName, uPass);
        if (db.connect()) {
            int isAdmin = Integer.parseInt((String) token.getBody().get("IsAdmin"));
            int loginUserId = Integer.parseInt((String) token.getBody().get("UserID"));

            boolean hasAccess = false;

            if ((!tableName.equals("Papers")) && (!tableName.equals("Users")) && isAdmin != 1) {
                System.out.println("Access Denied: Only Admins can do that!");
            } else if (isAdmin == 1) {
                hasAccess = true;
            } else {
                if (tableName.equals("Users")) {
                    if (loginUserId == Integer.parseInt(pkData.get(0))) {
                        hasAccess = true;
                    }
                } else {
                    String query = "SELECT * FROM PaperAuthors WHERE paperId = ?;";
                    ArrayList<String> paperIdHolder = new ArrayList<>();
                    paperIdHolder.add(pkData.get(0));
                    ArrayList<ArrayList<String>> fullResults = db.getData(query, paperIdHolder);
                    ArrayList<ArrayList<String>> results = new ArrayList<>();
                    for (int i = 2; i < fullResults.size(); i++) {
                        results.add(fullResults.get(i));
                    }
                    for (int i = 0; i < results.size(); i++) {
                        if (loginUserId == Integer.parseInt(results.get(i).get(0))) {
                            hasAccess = true;
                        }
                    }
                }
            }

            if (hasAccess) {
                StringBuilder sql = new StringBuilder("SELECT * FROM " + tableName + " WHERE ");
                System.out.println(pkNames.size());
                System.out.println(pkData.size());
                for (int i = 0; i < pkNames.size(); i++) {
                    String pk = pkNames.get(i);
                    if (i == pkNames.size() - 1) {
                        sql.append(pk).append(" = ?;");
                    } else {
                        sql.append(pk).append(" = ? AND ");
                    }
                }

                return db.getData(sql.toString(), pkData);
            } else {
                System.out.println("Access Denied");
                return new ArrayList<>();
            }
        }
        else {
            System.out.println("Failed to connect!");
            return new ArrayList<>();
        }
    }


    /**
     * Fetch method for objects that have a single primary key
     *
     * @param tableName name of the table to get data from
     * @param pkName name of the table's primary key
     * @param pkData value for the primary key
     * @return 2D ArrayList containing the selected data
     * @throws DLException custom exception that logs errors in a separate file
     */
    public ArrayList<ArrayList<String>> fetch(String tableName, String pkName, String pkData, Jws<Claims> token) throws DLException{
        MySQLDatabase db = new MySQLDatabase(uName, uPass);
        if (db.connect()) {
            int isAdmin = Integer.parseInt((String) token.getBody().get("IsAdmin"));
            int loginUserId = Integer.parseInt((String) token.getBody().get("UserID"));

            boolean hasAccess = false;

            if ((!tableName.equals("Papers")) && (!tableName.equals("Users")) && isAdmin != 1) {
                System.out.println("Access Denied: Only Admins can do that!");
            } else if (isAdmin == 1) {
                hasAccess = true;
            } else {
                if (tableName.equals("Users")) {
                    if (loginUserId == Integer.parseInt(pkData)) {
                        hasAccess = true;
                    }
                } else {
                    String query = "SELECT * FROM PaperAuthors WHERE paperId = ?;";
                    ArrayList<String> paperIdHolder = new ArrayList<>();
                    paperIdHolder.add(pkData);
                    ArrayList<ArrayList<String>> fullResults = db.getData(query, paperIdHolder);
                    ArrayList<ArrayList<String>> results = new ArrayList<>();
                    for (int i = 2; i < fullResults.size(); i++) {
                        results.add(fullResults.get(i));
                    }
                    for (int i = 0; i < results.size(); i++) {
                        if (loginUserId == Integer.parseInt(results.get(i).get(0))) {
                            hasAccess = true;
                        }
                    }
                }
            }
            if (hasAccess) {
                String sql = "SELECT * FROM " + tableName + " WHERE " + pkName + " = ?;";
                ArrayList<String> values = new ArrayList<>();
                values.add(pkData);
                return db.getData(sql, values);
            } else {
                return new ArrayList<>();
            }
        }
        else {
            System.out.println("Failed to connect!");
            return new ArrayList<>();
        }
    }

    /**
     * Put method
     *
     * @param tableName name of the table to update data in
     * @param columnNames ArrayList containing the names of the attributes to change
     * @param values ArrayList containing the new values
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int put(String tableName, ArrayList<String> columnNames, ArrayList<String> values, int numKeys, Jws<Claims> token) throws DLException{
        MySQLDatabase db = new MySQLDatabase(uName, uPass);
        if (db.connect()) {
            int isAdmin = Integer.parseInt((String) token.getBody().get("IsAdmin"));
            int loginUserId = Integer.parseInt((String) token.getBody().get("UserID"));

            boolean hasAccess = false;

            if ((!tableName.equals("Papers")) && (!tableName.equals("Users")) && isAdmin != 1) {
                System.out.println("Access Denied: Only Admins can do that!");
            } else if (isAdmin == 1) {
                hasAccess = true;
            } else {
                if (tableName.equals("Users")) {
                    if (loginUserId == Integer.parseInt(values.get(values.size() - 1))) {
                        hasAccess = true;
                    }
                } else {
                    String query = "SELECT * FROM PaperAuthors WHERE paperId = ?;";
                    ArrayList<String> paperIdHolder = new ArrayList<>();
                    paperIdHolder.add(values.get(values.size() - 1));

                    ArrayList<ArrayList<String>> fullResults = db.getData(query, paperIdHolder);
                    ArrayList<ArrayList<String>> results = new ArrayList<>();

                    for (int i = 2; i < fullResults.size(); i++) {
                        results.add(fullResults.get(i));
                    }
                    for (int i = 0; i < results.size(); i++) {
                        if (loginUserId == Integer.parseInt(results.get(i).get(0))) {
                            hasAccess = true;
                        }
                    }
                }
            }
            if (hasAccess) {
                StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");
                for (int i = 0; i < columnNames.size(); i++) {
                    String column = columnNames.get(i);
                    if (i == (columnNames.size() - numKeys)) {
                        sql.append("WHERE ").append(column).append(" = ?;");
                    } else if (i == ((columnNames.size() - numKeys) - 1)) {
                        sql.append(column).append(" = ? ");
                    } else {
                        sql.append(column).append(" = ?, ");
                    }
                }
                return db.setData(sql.toString(), values);
            } else {
                return -1;
            }
        }
        else {
            System.out.println("Failed to connect!");
            return -1;
        }
    }

    /**
     * Post method for data objects
     *
     * @param tableName name of the table to post data to
     * @param columnNames ArrayList containing the attribute names for the table
     * @param values ArrayList containing the values to be inserted
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int post(String tableName, ArrayList<String> columnNames, ArrayList<String> values, Jws<Claims> token) throws DLException{
        MySQLDatabase db = new MySQLDatabase(uName, uPass);
        if (db.connect()) {
            int isAdmin = Integer.parseInt((String) token.getBody().get("IsAdmin"));
            int loginUserId = Integer.parseInt((String) token.getBody().get("UserID"));

            boolean hasAccess = false;

            if ((!tableName.equals("Papers")) && (!tableName.equals("Users")) && isAdmin != 1) {
                System.out.println("Access Denied: Only Admins can do that!");
            } else if (isAdmin == 1) {
                hasAccess = true;
            } else {
                if (tableName.equals("Users")) {
                    if (loginUserId == Integer.parseInt(values.get(0))) {
                        hasAccess = true;
                    }
                } else {
                    String query = "SELECT * FROM PaperAuthors WHERE paperId = ?;";
                    ArrayList<String> paperIdHolder = new ArrayList<>();
                    paperIdHolder.add(values.get(0));

                    ArrayList<ArrayList<String>> fullResults = db.getData(query, paperIdHolder);
                    ArrayList<ArrayList<String>> results = new ArrayList<>();

                    for (int i = 2; i < fullResults.size(); i++) {
                        results.add(fullResults.get(i));
                    }
                    for (int i = 0; i < results.size(); i++) {
                        if (loginUserId == Integer.parseInt(results.get(i).get(0))) {
                            hasAccess = true;
                        }
                    }
                }
            }
            if (db.connect()) {
                StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " VALUES ( ");
                for (int i = 0; i < columnNames.size(); i++) {
                    String column = columnNames.get(i);
                    if (i == columnNames.size() - 1) {
                        sql.append(column).append("?);");
                    } else {
                        sql.append(column).append("?, ");
                    }
                }
                return db.setData(sql.toString(), values);
            } else {
                return -1;
            }
        }
        else {
            System.out.println("Failed to connect!");
            return -1;
        }
    }

    /**
     * Delete method for objects with more than one primary key
     *
     * @param tableName name of the table to delete data from
     * @param pkNames ArrayList containing the names of the primary key attributes
     * @param pkData ArrayList containing the values of the primary keys
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int delete(String tableName, ArrayList<String> pkNames, ArrayList<String> pkData, Jws<Claims> token) throws DLException{
        MySQLDatabase db = new MySQLDatabase(uName, uPass);
        int isAdmin = Integer.parseInt((String) token.getBody().get("IsAdmin"));

        if (db.connect()) {
            if (isAdmin == 1) {
                StringBuilder sql = new StringBuilder("DELETE FROM " + tableName + " WHERE ");
                for (int i = 0; i < pkNames.size(); i++) {
                    String pk = pkNames.get(i);
                    if (i == pkNames.size() - 1) {
                        sql.append(pk).append(" = ?;");
                    } else {
                        sql.append(pk).append(" = ? AND ");
                    }
                }

                return db.setData(sql.toString(), pkData);
            }
            else {
                System.out.println("Access Denied: Only Admins can do that!");
                return -1;
            }
        }
        else {
            return -1;
        }
    }

    /**
     * Delete method for objects with one primary key
     *
     * @param tableName name of the table to delete data from
     * @param pkName name of the primary key attribute
     * @param pkData value of the primary key
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int delete(String tableName, String pkName, String pkData, Jws<Claims> token) throws DLException{
        MySQLDatabase db = new MySQLDatabase(uName, uPass);
        int isAdmin = Integer.parseInt((String) token.getBody().get("IsAdmin"));

        if (db.connect()) {
            if (isAdmin == 1) {
                String sql = "DELETE FROM " + tableName + " WHERE " + pkName + " = ?;";
                ArrayList<String> values = new ArrayList<>();
                values.add(pkData);
                return db.setData(sql, values);
            }
            else {
                System.out.println("Access Denied: Only Admins can do that!");
                return -1;
            }
        }
        else {
            return -1;
        }
    }
}
