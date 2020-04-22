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

    public void fetch() throws DLException {
        // add primary key to ArrayList for passing into superclass method
        ArrayList<String> pkNames = new ArrayList<>();
        pkNames.add("subjectId");

        // add primary key data to ArrayList for passing into superclass method
        ArrayList<String> pkData = new ArrayList<>();
        pkData.add(Integer.toString(subjectId));

        ArrayList<ArrayList<String>> data = super.fetch("Subjects", pkNames, pkData);
    }

    public int put() throws DLException {
        return 1;
    }

    public int post() throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("subjectId");
        columnNames.add("subjectName");

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        values.add(Integer.toString(subjectId));
        values.add(subjectName);

        return super.post("Subjects", columnNames, values);
    }

    public int delete() throws DLException {
        return 1;
    }

} // end Subjects 