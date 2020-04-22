import java.util.ArrayList;

/**
 * A generic class we use for CRUD methods.
 * This class is extended by all of the other data objects
 * Each of those classes uses these methods with its own attributes
 *
 * @author Aaron Erhart
 */

public class DLObject {

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
