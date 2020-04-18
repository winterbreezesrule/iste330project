/**
 * Used to represent the _Affiliations table in the CSM database.
 */

public class Affiliations {
    
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

} // end Affiliations 