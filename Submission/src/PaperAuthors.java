/**
 * Used to represent the PaperAuthors table in the CSM database.
 */

public class PaperAuthors {

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

    }

    public String put() throws DLException {
        return "Hi.";
    }

    public String post() throws DLException {
        return "Hi.";
    }

    public String delete() throws DLException {
        return "Hi.";
    }

} // end PaperAuthors