import java.util.ArrayList;

/**
 * A generic class we use for CRUD methods. AARON, YOU WRITE THIS DOCUMENTATION
 */

public class DLObject {

    public void fetch(String tableName, String pkName, String pkData) throws DLException{
        MySQLDatabase db = new MySQLDatabase("username", "password");
        if(db.connect()) {
            String sql = "SELECT * FROM " + tableName + " WHERE " + pkName + " = ?;";
            ArrayList<String> values = new ArrayList<>();
            values.add(pkData);
            ArrayList<ArrayList<String>> data = db.getData(sql, values);
        }
    }
    public int put(String tableName, ArrayList<String> columnNames, ArrayList<String> values) throws DLException{
        MySQLDatabase db = new MySQLDatabase("username", "password");
        if (db.connect()){
            StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");
            for (int i = 0; i < columnNames.size(); i++){
                String column = columnNames.get(i);
                if (i == columnNames.size() - 1){
                    sql.append(column).append(" = ?;");
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
