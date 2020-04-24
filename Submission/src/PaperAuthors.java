import java.util.ArrayList;

/**
 * Used to represent the PaperAuthors table in the CSM database.
 */

public class PaperAuthors extends DLObject {

    // table attributes
    private int paperId;
    private int userId;
    private int displayOrder;

    /**
     * Gets the ID of the paper.
     * @return the ID of the paper.
     */
    public int getPaperId() {
        return paperId;
    }

    /**
     * Sets the ID of the paper.
     * @param paperId is the paper ID to be set to.
     */
    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    /**
     * Gets the ID of the user.
     * @return the ID of the user.
     */
    public int getUserId() {
        return userId;
    }

    /**
     *  Sets the ID of the user.
     * @param userId is the user ID to be set to.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the display order for the paper author.
     * @return the position in which the associated author's name appears.
     */
    public int getDisplayOrder() {
        return displayOrder;
    }

    /**
     * Sets the display order for the paper author.
     * @param displayOrder is the position in which the author's name will appear.
     */
    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    /**
     * fetch method for the paperAuthor object. Passes info from this class
     * to the superclass fetch method, where the query is created and executed.
     *
     * @throws DLException custom exception that logs errors in a separate file
     */
    public void fetch() throws DLException {
        // add primary key to ArrayList for passing into superclass method
        ArrayList<String> pkNames = new ArrayList<>();
        pkNames.add("paperId");
        pkNames.add("userId");

        // add primary key data to ArrayList for passing into superclass method
        ArrayList<String> pkData = new ArrayList<>();
        pkData.add(Integer.toString(paperId));
        pkData.add(Integer.toString(userId));

        ArrayList<ArrayList<String>> data = super.fetch("PaperAuthors", pkNames, pkData);
    }

    /**
     * put method for the paperAuthor object. Passes info from this class
     * to the superclass put method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int put() throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("displayOrder");
        columnNames.add("paperId");
        columnNames.add("userId");

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        values.add(Integer.toString(displayOrder));
        values.add(Integer.toString(paperId));
        values.add(Integer.toString(userId));

        return super.put("PaperAuthors", columnNames, values, 2);
    }

    /**
     * post method for the paperAuthor object. Passes info from this class
     * to the superclass post method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int post() throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("paperId");
        columnNames.add("userId");
        columnNames.add("displayOrder");

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        values.add(Integer.toString(paperId));
        values.add(Integer.toString(userId));
        values.add(Integer.toString(displayOrder));

        return super.post("PaperAuthors", columnNames, values);
    }

    /**
     * delete method for the paperAuthor object. Passes info from this class
     * to the superclass delete method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int delete() throws DLException {
        // add primary keys to ArrayList for passing into superclass method
        ArrayList<String> pkNames = new ArrayList<>();
        pkNames.add("paperId");
        pkNames.add("userId");

        // add primary keys data to ArrayList for passing into superclass method
        ArrayList<String> pkData = new ArrayList<>();
        pkData.add(Integer.toString(paperId));
        pkData.add(Integer.toString(userId));

        return super.delete("PaperAuthors", pkNames, pkData);
    }

} // end PaperAuthors