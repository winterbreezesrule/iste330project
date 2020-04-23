import java.util.ArrayList;

/**
 * Used to represent the _Affiliations table in the CSM database.
 */

public class Affiliations extends DLObject {
    
    // table attributes
    private int affiliationId;
    private String affiliationName;

    /**
     * Get the affiliation ID.
     * @return the affiliation ID.
     */
    public int getAffiliationId() {
        return affiliationId;
    }

    /**
     * Set the affiliation ID.
     * @param affiliationId is the new affiliation ID.
     */
    public void setAffiliationId(int affiliationId) {
        this.affiliationId = affiliationId;
    }

    /**
     * Get the affiliation name.
     * @return the affiliation name.
     */
    public String getAffiliationName() {
        return affiliationName;
    }

    /**
     * Set the affiliation name.
     * @param affiliationName is the new affiliation name.
     */
    public void setAffiliationName(String affiliationName) {
        this.affiliationName = affiliationName;
    }

    /**
     * fetch method for the affiliation object. Passes info from this class
     * to the superclass fetch method, where the query is created and executed.
     *
     * @throws DLException custom exception that logs errors in a separate file
     */
    public void fetch() throws DLException {
        ArrayList<ArrayList<String>> data = super.fetch("Affiliations", "affiliationId", Integer.toString(affiliationId));
    }

    /**
     * put method for the affiliation object. Passes info from this class
     * to the superclass put method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int put() throws DLException {
        return 1;
    }

    /**
     * post method for the affiliation object. Passes info from this class
     * to the superclass post method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int post() throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("affiliationId");
        columnNames.add("affiliationName");

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        values.add(Integer.toString(affiliationId));
        values.add(affiliationName);

        return super.post("Affiliations", columnNames, values);
    }

    /**
     * delete method for the affiliation object. Passes info from this class
     * to the superclass delete method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int delete() throws DLException {
        return super.delete("Affiliations", "affiliationId", Integer.toString(affiliationId));
    }

} // end Affiliations 