import java.util.ArrayList;

/**
 * A generic class we use for CRUD methods.
 * This class is extended by all of the other data objects
 * Each of those classes uses these methods with its own attributes
 *
 * @author Aaron Erhart
 */
// TODO ADD JAVADOCS FOR ALL OF THESE
public class DLObject {

    /**
     * Fetch method for objects that have more than one primary key
     *
     * @param tableName name of the table to get data from
     * @param pkNames ArrayList containing the names of the primary key attributes
     * @param pkData ArrayList containing the values of the primary keys
     * @return 2D ArrayList containing the selected data
     * @throws DLException custom exception that logs errors in a separate file
     */
    public ArrayList<ArrayList<String>> fetch(String tableName, ArrayList<String> pkNames, ArrayList<String> pkData) throws DLException{
        MySQLDatabase db = new MySQLDatabase("username", "password");
        if(db.connect()) {
            StringBuilder sql = new StringBuilder("SELECT * FROM " + tableName + " WHERE ");
            System.out.println(pkNames.size());
            System.out.println(pkData.size());
            for (int i = 0; i < pkNames.size(); i++){
                String pk = pkNames.get(i);
                if (i == pkNames.size() - 1){
                    sql.append(pk).append(" = ?;");
                }
                else {
                    sql.append(pk).append(" = ? AND ");
                }
            }

            return db.getData(sql.toString(), pkData);
        }
        else {
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
    public ArrayList<ArrayList<String>> fetch(String tableName, String pkName, String pkData) throws DLException{
        MySQLDatabase db = new MySQLDatabase("username", "password");
        if (db.connect()) {
            String sql = "SELECT * FROM " + tableName + " WHERE " + pkName + " = ?;";
            ArrayList<String> values = new ArrayList<>();
            values.add(pkData);
            return db.getData(sql, values);
        }
        else {
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
    public int put(String tableName, ArrayList<String> columnNames, ArrayList<String> values) throws DLException{
        MySQLDatabase db = new MySQLDatabase("username", "password");
        if (db.connect()){
            StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");
            for (int i = 0; i < columnNames.size(); i++){
                String column = columnNames.get(i);
                if (i == columnNames.size() - 1){
                    sql.append("WHERE ").append(column).append(" = ?;");
                }
                else if (i == columnNames.size() - 2){
                    sql.append(column).append(" = ? ");
                }
                else {
                    sql.append(column).append(" = ?, ");
                }
            }
            return db.setData(sql.toString(), values);
        }
        else {
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
    public int post(String tableName, ArrayList<String> columnNames, ArrayList<String> values) throws DLException{
        MySQLDatabase db = new MySQLDatabase("username", "password");
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
        }
        else {
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
    public int delete(String tableName, ArrayList<String> pkNames, ArrayList<String> pkData) throws DLException{
        MySQLDatabase db = new MySQLDatabase("username", "password");
        if (db.connect()) {
            StringBuilder sql = new StringBuilder("DELETE FROM " + tableName + " WHERE ");
            for (int i = 0; i < pkNames.size(); i++){
                String pk = pkNames.get(i);
                if (i == pkNames.size() - 1){
                    sql.append(pk).append(" = ?;");
                }
                else {
                    sql.append(pk).append(" = ? AND ");
                }
            }

            return db.setData(sql.toString(), pkData);
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
    public int delete(String tableName, String pkName, String pkData) throws DLException{
        MySQLDatabase db = new MySQLDatabase("username", "password");
        if (db.connect()) {
            String sql = "DELETE FROM " + tableName + " WHERE " + pkName + " = ?;";
            ArrayList<String> values = new ArrayList<>();
            values.add(pkData);
            return db.setData(sql, values);
        }
        else {
            return -1;
        }
    }
}
