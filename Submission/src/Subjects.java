import java.util.ArrayList;

/**
 * Used to represent the _Subjects table in the CSM database.
 */
public class Subjects extends DLObject{

    // table attributes
    private int subjectId;
    private String subjectName;

    /**
     * Gets the subject ID.
     * @return the subject ID.
     */
    public int getSubjectId() {
        return subjectId;
    }

    /**
     * Sets the subject ID.
     * @param subjectId is the new subject ID.
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Gets the subject name.
     * @return the new subject name.
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Sets the subject name.
     * @param subjectName is the new subject name.
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * fetch method for the subject object. Passes info from this class
     * to the superclass fetch method, where the query is created and executed.
     *
     * @throws DLException custom exception that logs errors in a separate file
     */
    public void fetch() throws DLException {
        // add primary key to ArrayList for passing into superclass method
        ArrayList<String> pkNames = new ArrayList<>();
        pkNames.add("subjectId");

        // add primary key data to ArrayList for passing into superclass method
        ArrayList<String> pkData = new ArrayList<>();
        pkData.add(Integer.toString(subjectId));

        ArrayList<ArrayList<String>> data = super.fetch("_Subjects", pkNames, pkData);
    }

    /**
     * put method for the subject object. Passes info from this class
     * to the superclass put method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int put() throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("subjectName");
        columnNames.add("subjectId");

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        values.add(subjectName);
        values.add(Integer.toString(subjectId));

        return super.put("_Subjects", columnNames, values, 1);
    }

    /**
     * post method for the subject object. Passes info from this class
     * to the superclass post method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int post() throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("subjectId");
        columnNames.add("subjectName");

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        values.add(Integer.toString(subjectId));
        values.add(subjectName);

        return super.post("_Subjects", columnNames, values);
    }

    /**
     * delete method for the subject object. Passes info from this class
     * to the superclass delete method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int delete() throws DLException {
        return super.delete("_Subjects", "subjectId", Integer.toString(subjectId));
    }

} // end Subjects 