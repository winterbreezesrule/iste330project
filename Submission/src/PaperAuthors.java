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

    public void fetch() throws DLException {
        // add primary key to ArrayList for passing into superclass method
        ArrayList<String> pkNames = new ArrayList<>();
        pkNames.add("paperId");
        pkNames.add("userId");

        // add primary key data to ArrayList for passing into superclass method
        ArrayList<String> pkData = new ArrayList<>();
        pkData.add(Integer.toString(paperId));
        pkData.add(Integer.toString(userId));

        super.fetch("PaperAuthors", pkNames, pkData);
    }

    public int put() throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("paperId");
        // TODO fix the composite key problem with the put method by adding a numKeys parameter to put in DLObject

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        return 1;
    }

    public int post() throws DLException {
        return 1;
    }

    public int delete() throws DLException {
        return 1;
    }

} // end PaperAuthors