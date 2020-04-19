/**
 * Used to represent the PaperSubjects table in the CSM database.
 */
public class PaperSubjects {

    // attributes
    private int paperId;
    private int subjectId;

    /**
     * Gets the paper ID.
     * @return the paper ID.
     */
    public int getPaperId() {
        return paperId;
    }

    /**
     * Sets the paper ID.
     * @param paperId is the new paper ID.
     */
    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

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

} // end PaperSubjects