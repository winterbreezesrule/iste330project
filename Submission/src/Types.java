import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import java.util.ArrayList;

/**
 * Used to represent the _Types table in the CSM database.
 */

public class Types extends DLObject {

    // table attributes
    private int typeId;
    private String typeName;

    /**
     * Get the type ID.
     * @return the type ID.
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * Set the type ID.
     * @param typeId is the new type ID.
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    /**
     * Get the type name.
     * @return the type name.
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Set the type name.
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * fetch method for the type object. Passes info from this class
     * to the superclass fetch method, where the query is created and executed.
     *
     * @throws DLException custom exception that logs errors in a separate file
     */
    public void fetch(Jws<Claims> token) throws DLException {
        ArrayList<ArrayList<String>> data = super.fetch("_Types", "typeId", Integer.toString(typeId), token);

        try {
            setTypeId(Integer.parseInt(data.get(2).get(0)));
            setTypeName(data.get(2).get(1));
        } catch (Exception e) {
            System.out.println("Information could not be applied to this object.");
            throw new DLException(e);
        }
     }

    /**
     * put method for the type object. Passes info from this class
     * to the superclass put method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int put(Jws<Claims> token) throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("typeName");
        columnNames.add("typeId");

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        values.add(typeName);
        values.add(Integer.toString(typeId));

        return super.put("_Types", columnNames, values, 1, token);
    }

    /**
     * post method for the type object. Passes info from this class
     * to the superclass post method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int post(Jws<Claims> token) throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("typeId");
        columnNames.add("typeName");

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        values.add(Integer.toString(typeId));
        values.add(typeName);

        return super.post("_Types", columnNames, values, token);
    }

    /**
     * delete method for the type object. Passes info from this class
     * to the superclass delete method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int delete(Jws<Claims> token) throws DLException {
        return super.delete("_Types", "typeId", Integer.toString(typeId), token);
    }

} // end Types